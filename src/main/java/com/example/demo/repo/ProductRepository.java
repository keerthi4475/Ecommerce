package com.example.demo.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByItemtype(String itemtype);
    @Query(value = "SELECT * FROM product WHERE name LIKE %:byname%", nativeQuery = true)
    List<Product> searchProductsByName(String byname);
    @Query(value="select id from product",nativeQuery=true)
    List<Long> getAllIds();
    
}
