package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.PlanServicePort;
import es.uned.tw.application.port.PreferencesServicePort;
import es.uned.tw.application.port.SubscriptionServicePort;
import es.uned.tw.application.port.UserServicePort;
import es.uned.tw.domain.model.User;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.*;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The class Sign up controller.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final AuthenticationManager authenticationManager;
    private final UserServicePort userService;
    private final PreferencesServicePort preferencesService;
    private final UserRestMapper userMapper;
    private final UserRequest userRequest;
    private final GenreRestMapper genreMapper;
    private final DirectorRestMapper directorMapper;
    private final ActorRestMapper actorMapper;
    private final PlanServicePort planService;
    private final PlanRestMapper planMapper;
    private final SubscriptionServicePort subscriptionService;

    /**
     * User request
     *
     * @return the user
     */
    @ModelAttribute("user")
    public UserRequest userRequest() {
        return this.userRequest;
    }

    /**
     * Get user signup
     *
     * @return the template name
     */
    @GetMapping({"/signup"})
    public String user() {
        return "signup/signup-user";
    }

    /**
     * Perform signup user details.
     *
     * @param userRequest the user request
     * @return the url redirect to signup preferences
     */
    @SneakyThrows
    @PostMapping({"/signup-user"})
    public String signupUser(@ModelAttribute("user") final UserRequest userRequest) {
        log.info("Signing up user details {}", this.userRequest);
        Optional<User> user = this.userService.getUserByEmail(userRequest().getEmail());
        if (user.isPresent()) {
            this.userRequest.setEmail("");
            return "redirect:/signup?emailexists";
        }
        return "redirect:/signup-preferences";
    }

    /**
     * Preferences string.
     *
     * @param model the model
     * @return the template name
     */
    @GetMapping({"/signup-preferences"})
    public String preferences(final Model model) {
        final List<GenreRequest> genres =
                this.genreMapper.fromDomain(this.preferencesService.getGenres());
        final List<DirectorRequest> directors =
                this.directorMapper.fromDomain(this.preferencesService.getDirectors());
        final List<ActorRequest> actors =
                this.actorMapper.fromDomain(this.preferencesService.getActors());
        model.addAttribute("genres", genres);
        model.addAttribute("directors", directors);
        model.addAttribute("actors", actors);
        return "signup/signup-preferences";
    }

    /**
     * Performs signup preferences.
     *
     * @param userRequest the user request
     * @param previous    the previous
     * @return the url redirect to signup plan or come back to user details
     */
    @SneakyThrows
    @PostMapping({"/signup-preferences"})
    public String signupPreferences(@ModelAttribute("user") final UserRequest userRequest,
                                    @RequestParam(required = false) String previous) {
        log.info("Setting user preferences [Genres: {}] [Directors: {}] [Actors: {}]",
                userRequest.getSelectedGenres(), userRequest.getSelectedDirectors(), userRequest.getSelectedActors());
        userRequest.setGenres(this.genreMapper.fromDomain(this.preferencesService.getGenres().stream().
                filter(g -> userRequest.getSelectedGenres().contains(g.getId().toString())).
                collect(Collectors.toList())));
        userRequest.setDirectors(this.directorMapper.fromDomain(this.preferencesService.getDirectors().stream().
                filter(g -> userRequest.getSelectedDirectors().contains(g.getId().toString())).
                collect(Collectors.toList())));
        userRequest.setActors(this.actorMapper.fromDomain(this.preferencesService.getActors().stream().
                filter(g -> userRequest.getSelectedActors().contains(g.getId().toString())).
                collect(Collectors.toList())));
        this.userRequest.setGenres(userRequest.getGenres());
        this.userRequest.setDirectors(userRequest.getDirectors());
        this.userRequest.setActors(userRequest.getActors());

        log.info("Singing up user preferences {}", userRequest);
        return Optional.ofNullable(previous).isEmpty() ? "redirect:/signup-plan" : "redirect:/signup";
    }

    /**
     * Get plan details
     *
     * @param model the model
     * @return the template name
     */
    @SneakyThrows
    @GetMapping({"/signup-plan"})
    public String plan(final Model model) {
        final List<PlanRequest> plans = this.planMapper.fromDomain(this.planService.getPlans());
        model.addAttribute("plans", plans);
        return "signup/signup-plan";
    }

    /**
     * Perform signup plan.
     *
     * @param userRequest the user request
     * @param id          the id
     * @return the url redirect to landing page
     */
    @SneakyThrows
    @PostMapping({"/signup-plan/{plan}"})
    public String signupPlan(@ModelAttribute("user") final UserRequest userRequest,
                             @PathVariable("plan") final Long id) {
        log.info("Signing up plan {} for user {}", id, userRequest);
        final Optional<User> user = this.userService.createUser(this.userMapper.toDomain(this.userRequest));
        this.subscriptionService.createSubscription(user.get().getId(), id);
        this.autoLogin(userRequest.getEmail(), userRequest.getPassword());
        return "redirect:/";
    }

    private void autoLogin(String username, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}