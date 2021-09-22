package com.computacenter.emergencyappbackend.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(httpSecurityCorsConfigurer -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
            //configuration.setAllowedMethods(Arrays.asList("GET", "POST", "**"));
            configuration.addAllowedMethod(CorsConfiguration.ALL);
            configuration.addAllowedOrigin(CorsConfiguration.ALL);
            configuration.addAllowedHeader(CorsConfiguration.ALL);
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            httpSecurityCorsConfigurer.configurationSource(source);
        })
                .authorizeRequests(
                        authorizeRequests -> authorizeRequests.anyRequest().permitAll())
                .cors().and().csrf().disable();
    }
}
