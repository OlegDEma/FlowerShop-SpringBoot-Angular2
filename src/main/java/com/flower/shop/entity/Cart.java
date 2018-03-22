package com.flower.shop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private double total;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	@JoinTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> product ;
	
	public Cart() {

	}	
	

	public Cart(String name) {
		this.name = name;
	}
	


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	public String getNameOfCart() {
		return name;
	}


	public void setNameOfCart(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Cart cart = (Cart) o;

		if (id != cart.id) return false;
		if (Double.compare(cart.total, total) != 0) return false;
		if (name != null ? !name.equals(cart.name) : cart.name != null) return false;
		if (user != null ? !user.equals(cart.user) : cart.user != null) return false;
		return product != null ? product.equals(cart.product) : cart.product == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		temp = Double.doubleToLongBits(total);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (user != null ? user.hashCode() : 0);
		result = 31 * result + (product != null ? product.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", name='" + name + '\'' +
				", total=" + total +
				'}';
	}
}
