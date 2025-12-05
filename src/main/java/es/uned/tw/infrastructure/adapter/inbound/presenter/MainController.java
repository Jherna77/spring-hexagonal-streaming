package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.application.port.ContentServicePort;
import es.uned.tw.application.port.PlanServicePort;
import es.uned.tw.application.port.UserServicePort;
import es.uned.tw.domain.model.User;
import es.uned.tw.domain.type.UserRoleType;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.ContentRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.ContentTypeRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.mapper.PlanRestMapper;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.ContentRequest;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Main controller.
 */
@Slf4j
@Controller
@RequestMapping({"/"})
@RequiredArgsConstructor
public class MainController {

    private final UserDetailsService userDetailsService;
    private final UserServicePort userService;
    private final UserRequest userRequest;

    private final ContentServicePort contentService;
    private final ContentRestMapper contentMapper;

    private final PlanServicePort planService;
    private final PlanRestMapper planMapper;
    private final ContentTypeRestMapper contentTypeMapper;

    /**
     * User request authorized.
     *
     * @return the user request
     */
    @ModelAttribute("user")
    public UserRequest userRequest() {
        return this.userRequest;
    }

    /**
     * Get home contents and plans or redirect to specific URL.
     * <p>
     * If user is not authorized, it returns home template name
     * If user is authorized as a member, it returns the  url redirect to contents
     * If user is authorized as employee or admin, it returns the url redirect to admin
     * </p>
     *
     * @param model the model
     * @return the template name or url redirect
     */
    @SneakyThrows
    @GetMapping
    public String home(final Model model) {
        //Comprueba si el usuario se encuentra autenticado
        if (!(SecurityContextHolder.getContext().getAuthentication()
                instanceof AnonymousAuthenticationToken)) {

            //Comprueba los roles del usuario
            final UserDetails details = this.userDetailsService.loadUserByUsername(this.userRequest.getEmail());
            log.info("User details {}", details);
            if (details != null && details.getAuthorities().stream()
                    .anyMatch(a -> List.of(UserRoleType.ADMIN.name(), UserRoleType.EMPLOYEE.name()).
                            contains(a.getAuthority()))) {
                log.info("User authenticated redirects to administration {}", this.userRequest);
                return "redirect:/admin-statistics";
            } else {
                log.info("User authenticated redirects to content {}", this.userRequest);
                model.addAttribute("types",
                        this.contentTypeMapper.fromDomain(this.contentService.getContentTypesByUserId(
                                this.userService.getUserByEmail(this.userRequest.getEmail()).get().getId())));
                return "redirect:content";
            }
        }

        //Obtiene la lista de nuevos contenidos y planes de suscripción
        final List<ContentRequest> contents = this.contentMapper.fromDomain(
                this.contentService.getContentsRecent(10));
        model.addAttribute("contents", this.getContentsGroups(contents));
        model.addAttribute("plans",
                this.planMapper.fromDomain(this.planService.getPlans()));

        return "home";
    }

    /**
     * Signup user checking if email address exists and redirecting to login o register
     *
     * @param userRequest the user request
     * @return the url redirect to admin signin or signup
     */
    @SneakyThrows
    @PostMapping
    public String signup(@ModelAttribute("user") final UserRequest userRequest) {
        log.info("Checking user '{}' to singing up", userRequest);
        final Optional<User> user = this.userService.getUserByEmail(userRequest.getEmail());
        return user.isPresent() ? "redirect:signin" : "redirect:signup";
    }

    /**
     * Redirection to 404 URL not found when endpoint is not defined
     *
     * @return the template name
     */
    @RequestMapping("*")
    public String others() {
        return "error/404";
    }

    private List<List<ContentRequest>> getContentsGroups(final List<ContentRequest> contents) {
        final List<List<ContentRequest>> groups = new ArrayList<>();
        for (final ContentRequest content : contents) {
            if (groups.isEmpty() || groups.get(groups.size() - 1).size() % 5 == 0) {
                groups.add(new ArrayList<>());
            }
            groups.get(groups.size() - 1).add(content);
        }
        return groups;
    }
}
