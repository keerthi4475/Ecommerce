package com.example.demo.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.entity.EditProfileRequest;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.login;

import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @PostMapping("/createorder/{username}")
    public Order createOrder(@PathVariable String username,@RequestBody List<Product> products) {
        User user=userService.getUserByUsername(username);
    	return orderService.createOrder(user, products);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody login login) {
        User success = userService.login(login.getUsername(), login.getPassword());
        if (success != null) {
            return new ResponseEntity<>("Login successful",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login failed",HttpStatus.OK);
        }
    }
    @GetMapping("/searc/{pname}")
    public List<Product> searchProductByProductName(@PathVariable String pname) {
    	return productService.searchProductsByName(pname);
    }
    @GetMapping("/viewproduct")
    public List<Product> getAllProducts(){
		return productService.getAllProducts();	
    }
    
    @PostMapping("/addToCart/{username}")
    public ResponseEntity<String> addToCart(@PathVariable("username") String username, @RequestBody List<Long> cart) {
        userService.addToCart(username, cart);
        return ResponseEntity.ok("Added to cart successfully");
    }
    @PostMapping("/submitCart/{username}")
    public ResponseEntity<Order> submitCart(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        Order order = orderService.submitCart(user);
        return ResponseEntity.ok(order);
    }
    @PutMapping("/editprofile/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User updated = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(updated);
    }
}



