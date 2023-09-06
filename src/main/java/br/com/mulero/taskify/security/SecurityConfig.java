package br.com.mulero.taskify.security;

import br.com.mulero.taskify.security.filter.AuthenticationFilter;
import br.com.mulero.taskify.security.filter.AuthorizationFilter;
import br.com.mulero.taskify.security.jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static br.com.mulero.taskify.security.jwt.SecurityConstants.*;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsServiceImpl detailsService;

    public SecurityConfig(UserDetailsServiceImpl detailsService) {
        this.detailsService = detailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(detailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider::authenticate;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).httpBasic(withDefaults())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(LOGIN_URL, REGISTER_URL).permitAll()
                        .requestMatchers(GRAPHQL_URL).permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new AuthenticationFilter(authenticationManager(), new JwtProvider()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new AuthorizationFilter(new JwtProvider()), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}