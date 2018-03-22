package com.flower.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductDescription {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String description;
	
	@OneToMany(mappedBy="description")
	@JsonIgnore
	private List<Product> products;

	public ProductDescription() {
	}	

	public ProductDescription(String description) {
		this.description = description;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ProductDescription that = (ProductDescription) o;

		if (id != that.id) return false;
		if (description != null ? !description.equals(that.description) : that.description != null) return false;
		return products != null ? products.equals(that.products) : that.products == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (products != null ? products.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ProductDescription{" +
				"id=" + id +
				", description='" + description + '\'' +
				'}';
	}
}
