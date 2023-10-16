package com.opensource.queezly.config.cors;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableConfigurationProperties(CorsFilterProperties.class)
@RequiredArgsConstructor
public class CorsFilterConfiguration {

    private final CorsFilterProperties properties;

    @Bean("corsFilter")
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        final CorsConfiguration config = buildCorsConfiguration();
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new FilterRegistrationBean(new CorsFilter(source));
    }

    private CorsConfiguration buildCorsConfiguration() {
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);

        if (properties.getMaxAge() != null) {
            config.setMaxAge(properties.getMaxAge());
        }

        if (!CollectionUtils.isEmpty(properties.getAllowedMethods())) {
            config.setAllowedMethods(properties.getAllowedMethods());
        }

        if (!CollectionUtils.isEmpty(properties.getAllowedHeaders())) {
            config.setAllowedHeaders(properties.getAllowedHeaders());
        }

        if (!CollectionUtils.isEmpty(properties.getAllowedOrigins())) {
            config.setAllowedOrigins(properties.getAllowedOrigins());
        }

        return config;
    }
}