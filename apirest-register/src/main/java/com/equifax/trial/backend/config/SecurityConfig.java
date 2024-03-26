package com.equifax.trial.backend.config;

import com.equifax.trial.backend.filter.JwtAuthFilter;
import com.equifax.trial.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    @Lazy
    private JwtAuthFilter jwtAuthFilter;

    // User creation
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserService();
    }

    // Configuring HttpSecurity
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
      httpSecurity.authorizeHttpRequests(configure -> {
          configure
                  .requestMatchers(HttpMethod.GET, "/v1/workers").permitAll()
                  .requestMatchers(HttpMethod.GET, "/v1/worker").permitAll()
                  .requestMatchers("/v1/auth/**", "/v1/auth/user/**").permitAll();
      }).addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
              .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

      httpSecurity.httpBasic(Customizer.withDefaults());
      httpSecurity.csrf(csrf -> csrf.disable());

      return httpSecurity.build();
    }

    //Password Encoding
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


}
