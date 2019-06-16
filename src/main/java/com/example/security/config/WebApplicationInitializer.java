package com.example.security.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class WebApplicationInitializer
		extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { PersistenceJPAConfig.class, SecurityConfig.class };
		//return null;
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
//	@Override
//	public void onStartup(ServletContext servletContext) 
//	  throws ServletException {
//	  super.onStartup(servletContext);
//	  ServletRegistration.Dynamic servlet = servletContext
//	    .addServlet("h2-console", new WebServlet());
//	  servlet.setLoadOnStartup(2);
//	  servlet.addMapping("/console/*");
//	}
	
}
