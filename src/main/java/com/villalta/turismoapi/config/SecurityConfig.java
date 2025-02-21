package com.villalta.turismoapi.config;

import com.villalta.turismoapi.model.user.Role;
import com.villalta.turismoapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.villalta.turismoapi.config.PasswordEncoderConfig;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;

    @Autowired
    PasswordEncoderConfig passwordEncoderConfig;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactivar CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/public/**").permitAll() // Endpoints públicos
                        .requestMatchers("/api/admin/**").hasRole(Role.ADMIN.name()) // Solo ADMIN
                        .requestMatchers("/api/user/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name()) // USER y ADMIN
                        .anyRequest().authenticated() // El resto de endpoints requieren autenticación
                )
                .httpBasic(Customizer.withDefaults()); // Autenticación básica (usuario y contraseña)

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authManagerBuilder
                .userDetailsService(userService) // Configura el UserDetailsService
                .passwordEncoder(passwordEncoderConfig.passwordEncoder()); // Configura el PasswordEncoder
        return authManagerBuilder.build();
    }
}
