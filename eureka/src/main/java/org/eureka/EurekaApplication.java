package org.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	registry.addMapping("/**")
            		.allowedOriginPatterns("*")
            		.allowedMethods("PUT", "DELETE", "GET", "POST", "HEAD", "OPTIONS")
        			.allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin,Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization", "Auth-Type")
            		.allowCredentials(true);
            }
        };
    }
}
