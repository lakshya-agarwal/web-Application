package com.example.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity	
public class SecurityConfig {

	 @Bean
	    public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
	        http
	            .csrf().disable()
	            // Other security configurations
	            .authorizeExchange()
	            .pathMatchers("/public/**").permitAll()
	            .anyExchange().authenticated()
	            .and()
	            .httpBasic();
	        return http.build();
	    }
	 

	    @Bean
	    public MapReactiveUserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	        UserDetails user = User.withUsername("admin")
	            .password(passwordEncoder.encode("admin"))
	            .roles("USER")
	            .build();
	        return new MapReactiveUserDetailsService(user);
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
