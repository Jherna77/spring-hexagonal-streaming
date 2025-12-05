package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.ContentServicePort;
import es.uned.tw.application.port.FeatureServicePort;
import es.uned.tw.application.port.PreferencesServicePort;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.*;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The class Admin contents controller.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminContentsController {

    private final ContentServicePort contentService;
    private final ContentRestMapper contentMapper;
    private final ContentTypeRestMapper contentTypeMapper;

    private final FeatureServicePort featureService;
    private final FeatureRestMapper featureMapper;

    private final PreferencesServicePort preferencesService;
    private final GenreRestMapper genreMapper;
    private final DirectorRestMapper directorMapper;
    private final ActorRestMapper actorMapper;

    /**
     * Content types list.
     *
     * @return the content type list
     */
    @ModelAttribute("types")
    public List<ContentTypeRequest> types() {
        return this.contentTypeMapper.fromDomain(this.contentService.getContentTypes());
    }

    /**
     * Features list.
     *
     * @return the features list
     */
    @ModelAttribute("features")
    public List<FeatureRequest> features() {
        return this.featureMapper.fromDomain(this.featureService.getFeatures());
    }

    /**
     * Genres list.
     *
     * @return the genres list
     */
    @ModelAttribute("genres")
    public List<GenreRequest> genres() {
        return this.genreMapper.fromDomain(this.preferencesService.getGenres());
    }

    /**
     * Directors list.
     *
     * @return the diretors list
     */
    @ModelAttribute("directors")
    public List<DirectorRequest> directors() {
        return this.directorMapper.fromDomain(this.preferencesService.getDirectors());
    }

    /**
     * Actors list.
     *
     * @return the actors list
     */
    @ModelAttribute("actors")
    public List<ActorRequest> actors() {
        return this.actorMapper.fromDomain(this.preferencesService.getActors());
    }

    /**
     * Get all contents
     *
     * @param model the model
     * @return the tempate name
     */
    @SneakyThrows
    @GetMapping({"/admin-contents"})
    public String contents(final Model model) {
        log.info("Administrating contents");
        model.addAttribute("contents", this.contentService.getContents());
        return "admin/admin-contents";
    }

    /**
     * Drop all contents
     *
     * @param model the model
     * @return the url redirect to admin contents
     */
    @SneakyThrows
    @PostMapping({"/admin-contents/delete"})
    public String drop(final Model model) {
        log.info("Drop all contents");
        this.contentService.deleteContents();
        return "redirect:/admin-contents";
    }

    /**
     * Get content by id.
     *
     * @param model the model
     * @param id    the id
     * @return the template name
     */
    @SneakyThrows
    @GetMapping({"/admin-content"})
    public String content(final Model model, @RequestParam(name = "id", required = false) final Long id) {
        log.info("Administrating content id {}", id);
        model.addAttribute("id", 0);

        //Comprueba si es una creación o edición de contenido
        if (Objects.isNull(id) || id <= 0) {
            final ContentRequest content = new ContentRequest();
            content.setType(new ContentTypeRequest());
            content.getType().setId(0L);
            content.setFeature(new FeatureRequest());
            content.getFeature().setId(0L);
            model.addAttribute("content", content);
        } else {
            //Obtiene el usuario y establece su subscripción si es miembro
            final ContentRequest content = this.contentMapper.fromDomain(this.contentService.getContentById(id).get());

            //Establece las preferencias existentes
            content.setSelectedGenres(content.getGenres().stream().
                    map(g -> g.getId().toString()).collect(Collectors.toList()));
            content.setSelectedDirectors(content.getDirectors().stream().
                    map(d -> d.getId().toString()).collect(Collectors.toList()));
            content.setSelectedActors(content.getActors().stream().
                    map(a -> a.getId().toString()).collect(Collectors.toList()));
            model.addAttribute("content", content);
        }

        return "admin/admin-content";
    }

    /**
     * Create content
     *
     * @param model the model
     * @return the url redirect to admin contents
     */
    @SneakyThrows
    @PostMapping({"/admin-content/create"})
    public String create(final Model model) {
        log.info("Creating new content");
        return "redirect:/admin-content";
    }

    /**
     * Get content by id
     *
     * @param model the model
     * @param id    the id
     * @return the model and view with url redirect to admin contents
     */
    @SneakyThrows
    @PostMapping({"/admin-content/edit"})
    public ModelAndView update(final ModelMap model, @RequestParam final Long id) {
        log.info("Editing content {}", id);
        model.addAttribute("id", id);
        return new ModelAndView("redirect:/admin-content", model);
    }

    /**
     * Delete content by id.
     *
     * @param model the model
     * @param id    the id
     * @return the url redirect to admin contents
     */
    @SneakyThrows
    @PostMapping({"/admin-content/delete"})
    public String delete(final Model model, @RequestParam final Long id) {
        log.info("Deleting content {}", id);
        this.contentService.deleteContent(id);
        return "redirect:/admin-contents";
    }

    /**
     * Update content.
     *
     * @param model   the model
     * @param content the content
     * @return the url redirect to admin contents
     */
    @SneakyThrows
    @PostMapping({"/admin-content"})
    public String update(final Model model, @ModelAttribute("content") final ContentRequest content) {
        log.info("Updating content {}", content);

        //Actualiza el contenido
        this.setContentPreferences(content);
        this.contentService.updateContent(this.contentMapper.toDomain(content));
        return "redirect:/admin-contents";
    }

    private void setContentPreferences(@NonNull final ContentRequest content) {
        content.setGenres(this.genres().stream().
                filter(g -> content.getSelectedGenres().contains(g.getId().toString())).
                collect(Collectors.toList()));
        content.setDirectors(this.directors().stream().
                filter(g -> content.getSelectedDirectors().contains(g.getId().toString())).
                collect(Collectors.toList()));
        content.setActors(this.actors().stream().
                filter(g -> content.getSelectedActors().contains(g.getId().toString())).
                collect(Collectors.toList()));
    }
}