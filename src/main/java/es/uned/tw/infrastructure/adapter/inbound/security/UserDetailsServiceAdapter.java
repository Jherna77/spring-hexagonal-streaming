package es.uned.tw.infrastructure.adapter.inbound.security;


import es.uned.tw.application.port.UserPersistencePort;
import es.uned.tw.domain.model.User;
import es.uned.tw.infrastructure.adapter.inbound.controller.model.UserRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class with concrete User details service adapter
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class UserDetailsServiceAdapter implements UserDetailsService {
    private final UserPersistencePort userPersistence;
    private final UserRequest userRequest;

    @Override
    public UserDetails loadUserByUsername(@NonNull final String email) {
        log.info("Sign in email: {}", email);
        this.userRequest.setEmail(email);
        final User user = this.userPersistence.getUserByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User email not founds"));
        final List<GrantedAuthority> roles = Stream.of(user.getRole().getName())
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);
    }
}