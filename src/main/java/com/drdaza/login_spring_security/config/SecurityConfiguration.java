package com.drdaza.login_spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
/* import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; */
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import com.drdaza.login_spring_security.users.application.userDetailsServices.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    private JpaUserDetailsService service;

    public SecurityConfiguration(JpaUserDetailsService service) {
        this.service = service;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.cors()
            .and()
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form
                                .loginPage("/login")
                                .permitAll()
                                .disable())
            .logout(out -> out
                           .logoutUrl("/api/logout")
                           .deleteCookies("JSESSIONID"))
            .authorizeRequests(auth -> auth
                                       .antMatchers("/login").permitAll()
                                       .antMatchers("/api/users").permitAll()
                                       .antMatchers("/api/users/**").hasRole("ADMIN")
                                       .antMatchers("/api/products").hasAnyRole("USER","ADMIN")
                                       .anyRequest()
                                       .authenticated())
            .userDetailsService(service)
            .headers(header -> header.frameOptions().disable())
            .httpBasic(Customizer.withDefaults());

        return http.build(); 
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
