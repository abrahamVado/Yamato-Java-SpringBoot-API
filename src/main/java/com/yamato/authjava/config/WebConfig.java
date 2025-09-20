package com.yamato.authjava.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class WebConfig {

    @Value("${cors.origins:http://localhost:3000}")
    private String corsOrigins;

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        List<String> origins = Arrays.stream(corsOrigins.split(","))
                .map(String::trim).filter(s -> !s.isEmpty()).toList();

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(origins);
        config.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("Origin","Content-Type","Accept","Authorization","X-CSRF-Token"));
        config.setExposedHeaders(Arrays.asList("X-Request-Id"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
