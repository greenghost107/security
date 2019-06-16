//package com.example.security.repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import com.example.security.model.Role;
//import com.example.security.model.User;
//import com.example.security.model.UserDto;
//import com.example.security.service.UserService;
//
//@Component
//public class DbInit {
//	@Autowired
//    private UserService userService;
//	
//	@Bean
//	public String ds(UserDto userDto) {
//		Set<Role> userRoles = new HashSet<Role>();
////		userRoles.add(userDto.getRoles());
//		
//		if (userService.findByUsername(userDto.getUsername()) != null) return "found";
//		User user = new User();
//		user.setUsername(userDto.getUsername());
//		user.setPassword(userDto.getPassword());
//		userService.save(user);
//		return "hello";
//	}
//}
