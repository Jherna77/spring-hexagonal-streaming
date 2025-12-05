package es.uned.tw.infrastructure.adapter.inbound.security;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * The class Security provider adapter.
 * It implements all configurations about secured endpoints and authentication provider
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class SecurityProviderAdapter extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Authentication provider dao authentication provider.
     *
     * @return the dao authentication provider
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(this.userDetailsService);
        auth.setPasswordEncoder(this.passwordEncoder);
        return auth;
    }

    @Override
    protected void configure(@NonNull final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.authenticationProvider());
    }

    @Override
    protected void configure(@NonNull final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                        "/h2-console/**").permitAll()
                .and().authorizeRequests().antMatchers(
                        "/",
                        "/signup/**",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/bootstrap/**").permitAll()
                .and().formLogin().usernameParameter("email").loginPage("/signin").defaultSuccessUrl("/").permitAll()
                .and().logout().invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").permitAll();
    }

    @Override
    public void configure(@NonNull final WebSecurity web) {
        web.ignoring().antMatchers("/h2-console/**");
    }
}