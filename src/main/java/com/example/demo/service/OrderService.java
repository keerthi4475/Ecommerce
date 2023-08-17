package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public interface OrderService {
	Order createOrder(User user, List<Product> products);
	List<Order> getOrdersByUser(User user);
	String deleteOrder(Long orderId);
	List<Order> viewOrdersByUsername(String username);
	//void addToCart(User user, List<Product> products);

}
