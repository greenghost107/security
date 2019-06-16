package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.example.security.web" })
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		// resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/templates/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
				.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
	
//	@Bean
//	public ClassLoaderTemplateResolver templateResolver() {
//		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//		templateResolver.setPrefix("/templates/");
//		templateResolver.setCacheable(false);
//		templateResolver.setSuffix(".jsp");
//		
//		return templateResolver;
//	}
	
	// @Bean
	// public MultipartResolver multipartResolver() {
	// CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	// multipartResolver.setMaxUploadSize(5242880);
	// return multipartResolver;
	// }
}
