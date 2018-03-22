package com.flower.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Manager {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String surname;
	
	private String patronymic;
	
	private int phone;
	
	private String mail;
	
	private String city;

	
	private String storage;
	
	@ManyToOne
	private Delivery delivery;
	
	@OneToMany(mappedBy="manager")
    @JsonIgnore
	private List<Product> products;

	public Manager(String name, String surname, String patronymic, int phone, String mail, String city, String storage) {
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.phone = phone;
		this.mail = mail;
		this.city = city;
		this.storage = storage;
	}

	public Manager() {

	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
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

        Manager manager = (Manager) o;

        if (id != manager.id) return false;
        if (phone != manager.phone) return false;
        if (name != null ? !name.equals(manager.name) : manager.name != null) return false;
        if (surname != null ? !surname.equals(manager.surname) : manager.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(manager.patronymic) : manager.patronymic != null) return false;
        if (mail != null ? !mail.equals(manager.mail) : manager.mail != null) return false;
        if (city != null ? !city.equals(manager.city) : manager.city != null) return false;
        if (storage != null ? !storage.equals(manager.storage) : manager.storage != null) return false;
        if (delivery != null ? !delivery.equals(manager.delivery) : manager.delivery != null) return false;
        return products != null ? products.equals(manager.products) : manager.products == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + phone;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (storage != null ? storage.hashCode() : 0);
        result = 31 * result + (delivery != null ? delivery.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone=" + phone +
                ", mail='" + mail + '\'' +
                ", city='" + city + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }
}
