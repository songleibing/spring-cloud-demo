package com.garen.demo.service;

import com.garen.demo.domain.User;

public interface UserService {
	boolean add(User user);
	
	boolean delete(Long id);
	
	boolean update(User user);
	
	User get(Long id);
}
