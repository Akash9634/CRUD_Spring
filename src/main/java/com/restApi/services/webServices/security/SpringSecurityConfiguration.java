package com.restApi.services.webServices.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //all requests should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        //if a request is not authenticated , a web page is shown
        http.httpBasic(withDefaults());


        return http.build();
    }
}
