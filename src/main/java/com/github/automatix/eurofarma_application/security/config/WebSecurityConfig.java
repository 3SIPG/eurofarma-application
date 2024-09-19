package com.github.automatix.eurofarma_application.security.config;

import com.github.automatix.eurofarma_application.services.EuroUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@AllArgsConstructor
@EnableWebSecurity

public class WebSecurityConfig {

    private final EuroUserService userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())  // Disable CSRF protection
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/eurofarma/v*/register/**").permitAll()  // Allow requests to these endpoints
                        .anyRequest().authenticated()) //All other requests need authentication
                .formLogin(withDefaults());
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(bCryptPasswordEncoder);
        auth.setUserDetailsService(userService);
        return auth;
    }


}
