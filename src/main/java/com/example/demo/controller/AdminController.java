package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
@RestController
public class AdminController {
	@Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @PostMapping("/addProduct")
    public Product addproduct(@RequestBody Product product) {
    	return productService.addProduct(product);
    }
    @DeleteMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Long productId)
    {
    	return productService.deleteProduct(productId);
    }
    @GetMapping("/search/{byname}")
    public List<Product> searchProductByItemType(@PathVariable String byname) {
    	return productService.searchProductsByName(byname);
    }
    @GetMapping("/viewproducts")
    public List<Product> getAllProducts(){
		return productService.getAllProducts();	
    }
    
    @PostMapping("/createuser")
    public User adduser(@RequestBody User user) {
    	return userService.createUser(user);	
    }
    @GetMapping("/viewusers")
    public List<User> getallusers(){
    	return userService.getAllUsers();
    }
    @GetMapping("/getuserbyusername/{username}")
    public User getuserbyusername(@PathVariable String username) {
    	return userService.getUserByUsername(username);
    }
    @DeleteMapping("/deleteuser/{userid}")
    public String deleteUser(@PathVariable Long userid)
    {
    	return userService.deleteUser(userid);
    }
    @PostMapping("/blockuser/{username}")
    public String blockUser(@PathVariable String username)
    {
    	return userService.blockUser(username);
    }
    @DeleteMapping("/deleteorder/{orderid}")
    public String deleteOrder(@PathVariable Long orderid)
    {
    	return orderService.deleteOrder(orderid);
    }
    @GetMapping("/viewordersbyusername/{username}")
    public List<Order> getordersbyusername(@PathVariable String username){
    	 return orderService.viewOrdersByUsername(username);
    }
    @PostMapping("/unblockuser/{username}")
    public ResponseEntity<String> releaseUser(@PathVariable String username){
    	userService.releaseUser(username);
		return new ResponseEntity<>(username,HttpStatus.OK);   	
    }
}
