package com.flower.shop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Sale {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private LocalDate date;
	
	private int discount;
	
	private double total;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="sale")
	private List<Product> products;

	public Sale() {

	}

	public Sale(int discount, double total) {
		this.discount = discount;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Sale{" +
				"id=" + id +
				", date=" + date +
				", discount=" + discount +
				", total=" + total +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Sale sale = (Sale) o;

		if (id != sale.id) return false;
		if (discount != sale.discount) return false;
		if (Double.compare(sale.total, total) != 0) return false;
		if (date != null ? !date.equals(sale.date) : sale.date != null) return false;
		if (user != null ? !user.equals(sale.user) : sale.user != null) return false;
		return products != null ? products.equals(sale.products) : sale.products == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id;
		result = 31 * result + (date != null ? date.hashCode() : 0);
		result = 31 * result + discount;
		temp = Double.doubleToLongBits(total);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (user != null ? user.hashCode() : 0);
		result = 31 * result + (products != null ? products.hashCode() : 0);
		return result;
	}
}
