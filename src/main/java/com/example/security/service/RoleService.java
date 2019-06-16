package com.example.security.service;

import java.util.Set;

import com.example.security.model.Role;



public interface RoleService {
	
	Set<Role> findRoleByUserName(String login);
}
