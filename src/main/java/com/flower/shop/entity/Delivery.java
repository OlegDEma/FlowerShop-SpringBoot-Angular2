package com.flower.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Delivery {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String wayOfDelivery;
	
	private String firmOfDelivery;
	
	@OneToMany(mappedBy="delivery")
	@JsonIgnore
	private List<Manager> managers;

	public Delivery(String wayOfDelivery, String firmOfDelivery) {
		this.wayOfDelivery = wayOfDelivery;
		this.firmOfDelivery = firmOfDelivery;
	}

	public Delivery(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWayOfDelivery() {
		return wayOfDelivery;
	}

	public void setWayOfDelivery(String wayOfDelivery) {
		this.wayOfDelivery = wayOfDelivery;
	}

	public String getFirmOfDelivery() {
		return firmOfDelivery;
	}

	public void setFirmOfDelivery(String firmOfDelivery) {
		this.firmOfDelivery = firmOfDelivery;
	}

	public List<Manager> getManagers() {
		return managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Delivery delivery = (Delivery) o;

		if (id != delivery.id) return false;
		if (wayOfDelivery != null ? !wayOfDelivery.equals(delivery.wayOfDelivery) : delivery.wayOfDelivery != null)
			return false;
		if (firmOfDelivery != null ? !firmOfDelivery.equals(delivery.firmOfDelivery) : delivery.firmOfDelivery != null)
			return false;
		return managers != null ? managers.equals(delivery.managers) : delivery.managers == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (wayOfDelivery != null ? wayOfDelivery.hashCode() : 0);
		result = 31 * result + (firmOfDelivery != null ? firmOfDelivery.hashCode() : 0);
		result = 31 * result + (managers != null ? managers.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Delivery{" +
				"id=" + id +
				", wayOfDelivery='" + wayOfDelivery + '\'' +
				", firmOfDelivery='" + firmOfDelivery + '\'' +
				'}';
	}
}
