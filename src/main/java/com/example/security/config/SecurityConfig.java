package com.example.security.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import com.example.security.handler.CustomAccessDeniedHandler;
import com.example.security.model.UserDto;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/resources/**", "/registration").permitAll()
				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.failureUrl("/loginError")
				.permitAll()
				.successForwardUrl("/user/index")
//				.failureHandler(authenticationFailureHandler)
				.and()
				.logout()
				.permitAll()
				.and().exceptionHandling().accessDeniedPage("/admin/error");
//				.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler());
	}
	

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	 @Bean
	    public LocaleResolver localeResolver() {
	        final CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
	        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
	        return cookieLocaleResolver;
	    }
	 
	 
//	 @Bean
//	 public AccessDeniedHandler accessDeniedHandler(){
//	     return new CustomAccessDeniedHandler();
//	 }
	 
	 /*
	  * in the web page i am using <div sec:authorize="isAuthenticated()" style="display: inline-block;">
    Welcome, <span sec:authentication="name"></span>
    to be able to prompt the username and use the thymeleaf we need to inject dialect 
	  */
	 
	 @Bean
	 public SpringSecurityDialect securityDialect() {
	     return new SpringSecurityDialect();
	 }
	 
	
}