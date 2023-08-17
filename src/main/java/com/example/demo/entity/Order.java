package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double order_total;
	/*@OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)

    @JoinColumn(name ="cp_fk",referencedColumnName = "id")
*/
	@ManyToOne
	
	private User user;
	@ManyToMany
	private List<Product> products;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}
}
