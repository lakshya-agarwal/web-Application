package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecurityConfig {

	  @Bean
	    public RestTemplate template(){
	       return new RestTemplate();
	    }
	
}
