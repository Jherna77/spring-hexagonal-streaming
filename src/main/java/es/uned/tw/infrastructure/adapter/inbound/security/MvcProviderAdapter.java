package es.uned.tw.infrastructure.adapter.inbound.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The class Mvc provider adapter to configure interceptors
 */
@Configuration
@RequiredArgsConstructor
public class MvcProviderAdapter extends WebMvcConfigurerAdapter {
    private final SecurityInterceptorAdapter handlerInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(this.handlerInterceptor);
    }
}