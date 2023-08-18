package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repo.CartRepository;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private CartRepository cartrepo;
	@Autowired
	ProductRepository prepo;
	@Override
	public User createUser(User user) {
		return userrepo.save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userrepo.findByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userrepo.findAll();
	}
	@Override
	public String deleteUser(Long userId) {
		userrepo.deleteById(userId);
		return "user deleted successfully";
	}
	@Override
	public String blockUser(String username) {
		User user=userrepo.findByUsername(username);
		user.setBlocked("block");
		userrepo.save(user);
		return "User blocked";
	}
	@Override
	public User login(String username, String password) {
		return userrepo.getUserPwd(username, password);
	}
	@Override
	public String releaseUser(String username) {
		User user=userrepo.findByUsername(username);
		user.setBlocked("unblock");
		userrepo.save(user);
		return "User unblocked";
	}
	@Override
	public void addToCart(String username, List<Long> products) {
		User user=userrepo.findByUsername(username);
		List<Long> list=prepo.getAllIds();
		for(int i=0;i<products.size();i++)
		{
		Cart cart=new Cart();
		cart.setUser(user);
		if(list.contains(products.get(i)))
		{
			cart.setProductid(products.get(i));
			cartrepo.save(cart);
		}
		}
	}
	
//	@Override
//	public User editUserProfile(String username, User user) {
//		 User user1 = getUserByUsername(username);
//	        user1.setEmail(email);
//	        user1.setUsername(username);
//	        user1.setPassword(password);
//	return userrepo.save(user1);
//	}
	@Override
	public User editUserProfile(String username, User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
