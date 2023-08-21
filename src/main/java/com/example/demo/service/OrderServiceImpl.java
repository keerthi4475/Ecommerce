package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repo.CartRepository;
import com.example.demo.repo.OrderRepository;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.UserRepository;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderrepo;
	
	@Autowired
	ProductRepository productrepo;
	@Autowired
	private ProductService productservice;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private CartRepository cartrepo;
	@Override
	public Order createOrder(User user, List<Product> products) {
        Order order = new Order();
        double cost=0;
        order.setUser(user);
       // List<Product> p=new ArrayList<>();
        for(int i=0;i<products.size();i++) {
        	//p.add(prepo.findById(products.get(i).getId()).get());
        	cost+=products.get(i).getPrice();
        }
        order.setProducts(products);
        order.setOrder_total(cost);
		return orderrepo.save(order);
	}
	@Override
	public List<Order> getOrdersByUser(User user) {
		return orderrepo.findByUser(user);
	}
	@Override
	public String deleteOrder(Long orderId) {
			orderrepo.deleteById(orderId);
			return "deleted Succesfully";
	}
	
	@Override
	public List<Order> viewOrdersByUsername(String username) {
		User user = userService.getUserByUsername(username);
        return orderrepo.findByUser(user);
	}
	@Override
	public Order submitCart(User user) {
		List<Cart> cart=user.getCart();
		List<Long> cartPro=new ArrayList<>();
		for(int i=0;i<cart.size();i++)
		{
			cartPro.add(cart.get(i).getProductid());
		}
		
		Order order =new Order();
		order.setUser(user);
		order.setProducts(productrepo.findAllById(cartPro));
		orderrepo.save(order);
		
		return order;
	}

}
