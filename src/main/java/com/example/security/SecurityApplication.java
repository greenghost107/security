//package com.example.security;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@SpringBootApplication
//@EnableJpaRepositories(basePackages="com.example.security")
//@ComponentScan({"com.example.security"})
//public class SecurityApplication extends SpringBootServletInitializer{
//
//	 @Override
//	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//	        return application.sources(SecurityApplication.class);
//	    }
//	
//	public static void main(String[] args) {
//		SpringApplication.run(SecurityApplication.class, args);
//	}
//
//	
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer properties() {
//	    return new PropertySourcesPlaceholderConfigurer();
//	}
//}
//
//
////http://fruzenshtein.com/spring-mvc-security-mysql-hibernate/