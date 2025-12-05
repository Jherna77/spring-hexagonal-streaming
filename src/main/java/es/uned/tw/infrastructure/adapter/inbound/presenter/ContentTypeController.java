package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.ContentServicePort;
import es.uned.tw.application.port.PreferencesServicePort;
import es.uned.tw.application.port.UserServicePort;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.*;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The class Content type controller.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class ContentTypeController {
    private final UserRequest userRequest;
    private final UserServicePort userService;
    private final UserRestMapper userMapper;

    private final GenreRestMapper genreMapper;
    private final DirectorRestMapper directorMapper;
    private final ActorRestMapper actorMapper;
    private final PreferencesServicePort preferencesService;

    private final ContentServicePort contentService;
    private final ContentRestMapper contentMapper;
    private final ContentTypeRestMapper contentTypeMapper;

    private final ContentRequest filter = new ContentRequest();

    /**
     * Initialize controller post construct
     */
    @PostConstruct
    public void init() {
        this.filter.setType(this.filter.getType() == null ? new ContentTypeRequest() : this.filter.getType());
        this.filter.getType().setId(this.filter.getType().getId() == null ? 0L : this.filter.getType().getId());

        this.filter.setTitle("");
        this.filter.setSelectedGenre("0");
        this.filter.setSelectedDirector("0");
        this.filter.setSelectedActor("0");
    }

    /**
     * Filter contents criteria.
     *
     * @return the content request
     */
    @ModelAttribute("filter")
    public ContentRequest filter() {
        return this.filter;
    }

    /**
     * Content type list.
     *
     * @return the list
     */
    @SneakyThrows
    @ModelAttribute("types")
    public List<ContentTypeRequest> types() {
        return this.contentTypeMapper.fromDomain(this.contentService.getContentTypesByUserId(
                this.userService.getUserByEmail(this.userRequest.getEmail()).get().getId()));
    }

    /**
     * Get contents by type id
     *
     * @param model the model
     * @param id    the type id
     * @return the template name
     */
    @SneakyThrows
    @GetMapping({"/content-type/{id}"})
    public String type(final Model model, @PathVariable final Long id) {
        //Obtiene el usuario autorizado
        final UserRequest user = this.userMapper.fromDomain(
                this.userService.getUserByEmail(this.userRequest.getEmail()).get());

        //Comprueba si se cambia de tipo de contenido
        if (!Objects.equals(id, this.filter.getType().getId())) {
            this.init();
            this.filter.getType().setId(id);
        }

        //Obtiene los contenidos y establece los modelos
        final List<ContentRequest> contents = this.contentMapper.fromDomain(
                this.contentService.getContentsByUserId(user.getId()).stream().
                        filter(c -> Objects.equals(c.getType().getId(), id)).collect(Collectors.toList()));
        model.addAttribute("content", this.getFilteredContents(contents));
        model.addAttribute("id", id);
        model.addAttribute("type", contents.stream().findFirst().get().getType().getName());
        model.addAttribute("genres", this.genreMapper.fromDomain(this.preferencesService.getGenres()));
        model.addAttribute("directors", this.directorMapper.fromDomain(this.preferencesService.getDirectors()));
        model.addAttribute("actors", this.actorMapper.fromDomain(this.preferencesService.getActors()));
        return "content/content-type";
    }

    /**
     * Set filter criteria
     *
     * @param id             the id
     * @param contentRequest the content request
     * @return the url redirect to contents type
     */
    @SneakyThrows
    @PostMapping(value = {"/content-type/{id}/filter"}, params = "submit")
    public String filter(@PathVariable final Long id,
                         @ModelAttribute("filter") final ContentRequest contentRequest) {
        log.info("Filtering content-type with id {} [Title: {}] [Genre: {}] [Directors: {}] [Actors: {}]",
                id, this.filter.getTitle(), this.filter.getSelectedGenre(),
                this.filter.getSelectedDirector(), this.filter.getSelectedActor());
        return "redirect:/content-type/" + id;
    }

    /**
     * Clear filter criteria.
     *
     * @param id the id
     * @return the url redirect to contents type
     */
    @SneakyThrows
    @PostMapping(value = {"/content-type/{id}/filter"}, params = "cancel")
    public String clear(@PathVariable final Long id) {
        log.info("Reset filter content-type with id {}", id);
        this.init();
        return "redirect:/content-type/" + id;
    }

    private List<ContentRequest> getFilteredContents(@NonNull final List<ContentRequest> contents) {
        final List<ContentRequest> result = new ArrayList<>(contents);

        //Comprueba el filtro de título de contenido
        if (!this.filter.getTitle().isEmpty()) {
            result.removeIf(c -> !c.getTitle().toLowerCase().trim().contains(
                    this.filter.getTitle().toLowerCase().trim()));
        }

        //Comprueba el filtro de género seleccionado
        final long genre = Long.parseLong(this.filter.getSelectedGenre());
        if (genre > 0) {
            result.removeIf(c -> c.getGenres().
                    stream().map(GenreRequest::getId).noneMatch(g -> g == genre));
        }

        //Comprueba el filtro de director seleccionado
        final long director = Long.parseLong(this.filter.getSelectedDirector());
        if (director > 0) {
            result.removeIf(c -> c.getDirectors().
                    stream().map(DirectorRequest::getId).noneMatch(d -> d == director));
        }

        //Comprueba el filtro de actor seleccionado
        final long actor = Long.parseLong(this.filter.getSelectedActor());
        if (actor > 0) {
            result.removeIf(c -> c.getActors().
                    stream().map(ActorRequest::getId).noneMatch(a -> a == actor));
        }

        return result;
    }
}