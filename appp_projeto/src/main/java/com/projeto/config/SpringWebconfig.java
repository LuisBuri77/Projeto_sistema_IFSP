package com.projeto.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SpringWebconfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings (CorsRegistry registry) {
		registry.addMapping("/**") 
		.allowedOrigins( 
				ConfigProjeto.URL_CLIENTE, 
				ConfigProjeto.URL_SERVIDOR 
				).allowedHeaders(
						HttpHeaders.AUTHORIZATION, 
						HttpHeaders.ACCEPT, 
						HttpHeaders.CONTENT_TYPE 
						).allowedMethods(  
							HttpMethod.GET.name(),
							HttpMethod.POST.name(), 
							HttpMethod.PUT.name(), 
							HttpMethod.PATCH.name(), 
							HttpMethod.DELETE.name(), 
							HttpMethod.OPTIONS.name() 
							).allowCredentials(false).maxAge (ConfigProjeto.MAX_AGE);
	
	}
	
}
