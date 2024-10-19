package com.example.brinquedos.config;

import com.example.brinquedos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService; // Declare o UserService

    // Construtor para injeção de dependência
    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests()
                .requestMatchers("/login", "/signup").permitAll() // Permite acesso a /login e /signup
                .requestMatchers("/brinquedos").permitAll() // Permite acesso ao endpoint /brinquedos
                .anyRequest().authenticated() // Exige autenticação para todas as outras requisições
                .and()
                .formLogin()
                .loginPage("/login") // Define a página de login
                .defaultSuccessUrl("/brinquedos", true) // Redireciona para /brinquedos após login bem-sucedido
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService); // Define o UserDetailsService
        return provider;
    }
}
