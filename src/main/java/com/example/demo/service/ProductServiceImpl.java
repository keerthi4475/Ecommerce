package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
   @Autowired
   private ProductRepository productrepo;

@Override
public Product addProduct(Product product) {
	return productrepo.save(product);
}

@Override
public List<Product> getAllProducts() {

	return productrepo.findAll();
}

@Override
public String deleteProduct(Long Id) {
	 productrepo.deleteById(Id);
	return "deleted Succesfully";
}

@Override
public List<Product> searchProductsByName(String byname) {
	return productrepo.searchProductsByName(byname);
}

@Override
public List<Product> getProductsByIds(List<Long> productid) {
	
	return productrepo.findAllById(productid);
}
}
