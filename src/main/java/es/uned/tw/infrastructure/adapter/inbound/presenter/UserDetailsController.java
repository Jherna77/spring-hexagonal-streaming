package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.PreferencesServicePort;
import es.uned.tw.application.port.UserServicePort;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.ActorRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.DirectorRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.GenreRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.UserRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.ActorRequest;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.DirectorRequest;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.GenreRequest;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The class User details controller.
 */
@Slf4j
@Controller
@RequestMapping({"/user-details"})
@RequiredArgsConstructor
public class UserDetailsController {

    private final UserServicePort userService;
    private final UserRestMapper userMapper;
    private final UserRequest userRequest;

    private final PreferencesServicePort preferencesService;
    private final GenreRestMapper genreMapper;
    private final DirectorRestMapper directorMapper;
    private final ActorRestMapper actorMapper;

    /**
     * User request.
     *
     * @return the user request
     */
    @SneakyThrows
    @ModelAttribute("user")
    public UserRequest user() {
        final UserRequest user = this.userMapper.fromDomain(
                this.userService.getUserByEmail(this.userRequest.getEmail()).get());
        user.setSelectedGenres(user.getGenres().stream().
                map(g -> g.getId().toString()).collect(Collectors.toList()));
        user.setSelectedDirectors(user.getDirectors().stream().
                map(d -> d.getId().toString()).collect(Collectors.toList()));
        user.setSelectedActors(user.getActors().stream().
                map(a -> a.getId().toString()).collect(Collectors.toList()));
        return user;
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
     * @return the directors list
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
     * Get user details
     *
     * @return the user details
     */
    @GetMapping
    public String details() {
        return "user/user-details";
    }

    /**
     * Update user details, preferences and subscription plan
     *
     * @param userRequest the user request
     * @return the url redirect to home page
     */
    @SneakyThrows
    @PostMapping
    public String submit(@ModelAttribute("user") final UserRequest userRequest) {
        log.info("Setting user preferences [Genres: {}] [Directors: {}] [Actors: {}]",
                userRequest.getSelectedGenres(), userRequest.getSelectedDirectors(), userRequest.getSelectedActors());
        this.setUserPreferences(userRequest);

        log.info("Updating user details preferences {}", userRequest);
        this.userService.updateUser(this.userMapper.toDomain(userRequest));
        return "redirect:/";
    }

    private void setUserPreferences(@NonNull final UserRequest userRequest) {
        userRequest.setGenres(this.genres().stream().
                filter(g -> userRequest.getSelectedGenres().contains(g.getId().toString())).
                collect(Collectors.toList()));
        userRequest.setDirectors(this.directors().stream().
                filter(g -> userRequest.getSelectedDirectors().contains(g.getId().toString())).
                collect(Collectors.toList()));
        userRequest.setActors(this.actors().stream().
                filter(g -> userRequest.getSelectedActors().contains(g.getId().toString())).
                collect(Collectors.toList()));
    }
}