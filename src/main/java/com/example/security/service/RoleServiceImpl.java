package com.example.security.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.model.Role;
import com.example.security.model.User;
import com.example.security.repository.UserRepository;



@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Set<Role> findRoleByUserName(String login) {
		User user =userRepository.findByUsername(login);
		Set<Role> roleList = user.getRoles();
		return roleList;
	}
	
	
}
