package org.mazz.masterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class MasterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterServiceApplication.class, args);
	}
	
	 @Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurerAdapter() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/api/user/").allowedOrigins("http://localhost:4200");
	         }
	      };
	   }

}