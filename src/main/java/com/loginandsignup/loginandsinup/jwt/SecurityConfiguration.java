package com.loginandsignup.loginandsinup.jwt;

import com.loginandsignup.loginandsinup.user.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Autowired
    UserInformationRepository userInformationRepository;

    @Autowired
    AuthEntryPointJwt authEntryPointJwt;
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/userInformation/saveUserInformation").permitAll() // Public endpoint
                        .requestMatchers("/login/**").permitAll() // Public endpoint
                        .anyRequest().authenticated()             // All other endpoints require authentication
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Use stateless sessions
                )
                .csrf(csrf -> csrf.disable()).exceptionHandling(exception->exception.authenticationEntryPoint(authEntryPointJwt))
                . headers(headers->headers
                        .frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin()))
                .csrf(csrf -> csrf.disable())
                .addFilterBefore(authTokenFilter(),UsernamePasswordAuthenticationFilter.class); // Disable CSRF protection

        return http.build();
    }

    @Bean
    AuthTokenFilter authTokenFilter(){
        return new AuthTokenFilter();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userInformationRepository.findByUsername(username);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
