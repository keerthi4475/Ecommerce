package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
     Product addProduct(Product product);
     List<Product> getAllProducts();
     List<Product> searchProductsByName(String byname);
     String deleteProduct(Long Id);
	List<Product> getProductsByIds(List<Long> productid);
}
