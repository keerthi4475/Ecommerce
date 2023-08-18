package com.example.demo.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
@Repository
public interface CartRepository extends JpaRepository<Cart,Long>{
    @Query(value="select id from cart",nativeQuery=true)
    List<Long> getAllIds();
}


