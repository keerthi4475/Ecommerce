package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public interface UserService {
	User createUser(User user);
	User getUserByUsername(String username);
	List<User> getAllUsers();
	String deleteUser(Long userId);
	String blockUser(String username);
	User login(String username, String password);
	String releaseUser(String username);
	void addToCart(String username,List<Long> productId);
	User editUserProfile(String username, User user);
}
