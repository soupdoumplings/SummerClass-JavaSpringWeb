package io.rushi.SpringWebProject.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(csrf -> csrf.disable());
        //Http build garnu aghi http ma csrd bhanne function disable gareko
        //http build garera return garnu cha - securityfilterchain
        http.authorizeHttpRequests(auth->auth.anyRequest().permitAll());

        return http.build();
    }
}
