package es.uned.tw.infrastructure.adapter.inbound.security;

import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * The class Security interceptor adapter that handler concrete interceptors.
 * It permits check if session was expired with user is requesting any endpoint
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class SecurityInterceptorAdapter implements HandlerInterceptor {
    private final UserRequest userRequest;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean authenticated = !SecurityContextHolder.getContext()
                .getAuthentication()
                .getName()
                .equals("anonymousUser");
        if (authenticated && (Objects.isNull(this.userRequest) ||
                Objects.isNull(this.userRequest.getEmail()) || this.userRequest.getEmail().isEmpty())) {
            log.info("Session expired {}", this.userRequest);
            response.sendRedirect("/logout");
            return false;
        }
        return true;
    }
}