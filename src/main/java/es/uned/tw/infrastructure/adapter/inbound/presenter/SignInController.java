package es.uned.tw.infrastructure.adapter.inbound.presenter;

import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The class Sign in controller.
 */
@Slf4j
@Controller
@RequestMapping({"/signin"})
@RequiredArgsConstructor
public class SignInController {

    private final UserRequest userRequest;

    /**
     * User request authorized
     *
     * @return the user requested
     */
    @ModelAttribute("user")
    public UserRequest userRequest() {
        return this.userRequest;
    }

    /**
     * Signin user.
     *
     * @return the template name
     */
    @GetMapping
    public String signin() {
        return "signin";
    }
}