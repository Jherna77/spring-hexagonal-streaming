package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.PlanServicePort;
import es.uned.tw.application.port.PreferencesServicePort;
import es.uned.tw.application.port.SubscriptionServicePort;
import es.uned.tw.application.port.UserServicePort;
import es.uned.tw.domain.model.User;
import es.uned.tw.domain.type.UserRoleType;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The class Admin users controller.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminUsersController {

    private final UserRequest userRequest;
    private final UserServicePort userService;
    private final UserRestMapper userMapper;
    private final UserRoleRestMapper roleMapper;

    private final PreferencesServicePort preferencesService;
    private final GenreRestMapper genreMapper;
    private final DirectorRestMapper directorMapper;
    private final ActorRestMapper actorMapper;

    private final PlanServicePort planService;
    private final PlanRestMapper planMapper;
    private final SubscriptionServicePort subscriptionService;

    /**
     * Roles list.
     *
     * @return the list
     */
    @SneakyThrows
    @ModelAttribute("roles")
    public List<UserRoleRequest> roles() {
        return this.roleMapper.fromDomain(this.userService.getRoles());
    }

    /**
     * Genres list.
     *
     * @return the list
     */
    @ModelAttribute("genres")
    public List<GenreRequest> genres() {
        return this.genreMapper.fromDomain(this.preferencesService.getGenres());
    }

    /**
     * Directors list.
     *
     * @return the list
     */
    @ModelAttribute("directors")
    public List<DirectorRequest> directors() {
        return this.directorMapper.fromDomain(this.preferencesService.getDirectors());
    }

    /**
     * Actors list.
     *
     * @return the list
     */
    @ModelAttribute("actors")
    public List<ActorRequest> actors() {
        return this.actorMapper.fromDomain(this.preferencesService.getActors());
    }

    /**
     * Get users
     *
     * @param model the model
     * @return the template name
     */
    @SneakyThrows
    @GetMapping({"/admin-users"})
    public String users(final Model model) {
        log.info("Administrating users");
        model.addAttribute("users", this.userService.getUsers());
        return "admin/admin-users";
    }

    /**
     * Drop all users except protected master administrator
     *
     * @param model the model
     * @return the url redirect to admin users
     */
    @SneakyThrows
    @PostMapping({"/admin-users/delete"})
    public String drop(final Model model) {
        log.info("Drop all users");
        final User current = this.userService.getUserByEmail(this.userRequest.getEmail()).get();

        //Recorre los usuarios y elimina todos excepto el Administrador principal y el usuario actual
        for (final User user : this.userService.getUsers().stream().
                filter(u -> u.getId() >= 1L && !u.getId().equals(current.getId())).collect(Collectors.toList())) {
            log.info("Deleting user id {} email {}", user.getId(), user.getEmail());
            this.userService.deleteUser(user.getId());
        }
        return "redirect:/admin-users";
    }

    /**
     * Get user by id
     *
     * @param model the model
     * @param id    the id
     * @return the template name
     */
    @SneakyThrows
    @GetMapping({"/admin-user"})
    public String user(final Model model, @RequestParam(name = "id", required = false) final Long id) {
        log.info("Administrating user id {}", id);
        model.addAttribute("plans", this.planMapper.fromDomain(this.planService.getPlans()));

        //Comprueba si es una creación o edición de usuario
        if (Objects.isNull(id) || id <= 0) {
            final UserRequest user = new UserRequest();
            user.setRole(new UserRoleRequest());
            user.getRole().setId((long) UserRoleType.MEMBER.ordinal());
            user.setSelectedPlan("1");
            model.addAttribute("user", user);
        } else {
            //Obtiene el usuario y establece su subscripción si es miembro
            final UserRequest user = this.userMapper.fromDomain(this.userService.getUserById(id).get());
            if (user.getRole().getId() == UserRoleType.MEMBER.ordinal()) {
                user.setSelectedPlan(this.subscriptionService.
                        getSubscriptionByUserId(user.getId()).get().getPlan().getId().toString());
            }

            //Establece las preferencias existentes
            user.setSelectedGenres(user.getGenres().stream().
                    map(g -> g.getId().toString()).collect(Collectors.toList()));
            user.setSelectedDirectors(user.getDirectors().stream().
                    map(d -> d.getId().toString()).collect(Collectors.toList()));
            user.setSelectedActors(user.getActors().stream().
                    map(a -> a.getId().toString()).collect(Collectors.toList()));
            model.addAttribute("user", user);
        }
        return "admin/admin-user";
    }

    /**
     * Create user.
     *
     * @param model the model
     * @return the template name
     */
    @SneakyThrows
    @PostMapping({"/admin-user/create"})
    public String create(final Model model) {
        log.info("Creating new user");
        return "redirect:/admin-user";
    }

    /**
     * Update user by id
     *
     * @param model the model
     * @param id    the id
     * @return the model and view with url redirect to admin user
     */
    @SneakyThrows
    @PostMapping({"/admin-user/edit"})
    public ModelAndView update(final ModelMap model, @RequestParam final Long id) {
        log.info("Editing user {}", id);
        model.addAttribute("id", id);
        return new ModelAndView("redirect:/admin-user", model);
    }

    /**
     * Delete user by id.
     *
     * @param model the model
     * @param id    the id
     * @return the url redirect to admin users
     */
    @SneakyThrows
    @PostMapping({"/admin-user/delete"})
    public String delete(final Model model, @RequestParam final Long id) {
        log.info("Deleting user {}", id);
        this.userService.deleteUser(id);
        return "redirect:/admin-users";
    }

    /**
     * Update user
     *
     * @param model the model
     * @param user  the user
     * @return the url redirect to admin users
     */
    @SneakyThrows
    @PostMapping({"/admin-user"})
    public String update(final Model model, @ModelAttribute("user") final UserRequest user) {
        //Actualiza el usuario
        this.setUserPreferences(user);
        log.info("Updating user {}", user);
        final Optional<User> newUser = this.userService.updateUser(this.userMapper.toDomain(user));

        //Actualiza la suscripción
        if (Optional.ofNullable(user.getId()).isEmpty()) {
            log.info("Creating suscripción by user {} plan {}", newUser.get().getId(), user.getSelectedPlan());
            this.subscriptionService.createSubscription(
                    newUser.get().getId(), Long.valueOf(user.getSelectedPlan()));
        } else {
            log.info("Updating suscripción with user {} plan {}", newUser.get().getId(), user.getSelectedPlan());
            this.subscriptionService.updateSubscriptionPlan(
                    newUser.get().getId(), Long.valueOf(user.getSelectedPlan()));
        }
        return "redirect:/admin-users";
    }

    private void setUserPreferences(@NonNull final UserRequest user) {
        user.setGenres(new ArrayList<>());
        if (Optional.ofNullable(user.getSelectedGenres()).isPresent() &&
                !user.getSelectedGenres().isEmpty()) {
            user.setGenres(this.genres().stream().
                    filter(g -> user.getSelectedGenres().contains(g.getId().toString())).
                    collect(Collectors.toList()));
        }
        user.setDirectors(new ArrayList<>());
        if (Optional.ofNullable(user.getSelectedDirectors()).isPresent() &&
                !user.getSelectedDirectors().isEmpty()) {
            user.setDirectors(this.directors().stream().
                    filter(g -> user.getSelectedDirectors().contains(g.getId().toString())).
                    collect(Collectors.toList()));
        }
        user.setActors(new ArrayList<>());
        if (Optional.ofNullable(user.getSelectedActors()).isPresent() &&
                !user.getSelectedActors().isEmpty()) {
            user.getActors().addAll(this.actors().stream().
                    filter(g -> user.getSelectedActors().contains(g.getId().toString())).
                    collect(Collectors.toList()));
        }
    }
}