package com.example.security.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.security.model.User;
import com.example.security.service.UserService;


@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserService userService;
	
	public User getUser(String login) {
//		List<User> userList = new ArrayList<User>();
//		Query query = openSession().createQuery("from User u where u.login = :login");
//		query.setParameter("login", login);
//		userList = query.list();
//		if (userList.size() > 0)
//			return userList.get(0);
//		else
//			return null;	
//		
		User user = userService.findByUsername(login);
		return user;
	}
}
