package com.flower.shop.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Product {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String image;
	
	private double price;
	
	private int guarantee;
	
	@ManyToMany
	@JoinTable(name = "cart_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "cart_id"))
	private List<Cart> cart ;

	@ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.MERGE})
	@JoinColumn(name="brand_id")
	private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.MERGE})
	@JoinColumn(name="model_id")
	private Model model;


    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.MERGE})
	@JoinColumn(name="manager_id")
	private Manager manager;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.MERGE})
	@JoinColumn(name="category_id")
	private Category category;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.MERGE})
	@JoinColumn(name="sale_id")
	private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.MERGE})
	@JoinColumn(name="description_id")
	private ProductDescription description;

	public Product() {

	}

	public Product(String name, double price, int guarantee) {
		this.name = name;
		this.price = price;
		this.guarantee = guarantee;
	}



	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(int guarantee) {
		this.guarantee = guarantee;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", guarantee=" + guarantee +
                ", cart=" + cart +
                ", brand=" + brand +
                ", model=" + model +
                ", manager=" + manager +
                ", category=" + category +
                ", sale=" + sale +
                ", description=" + description +
                '}';
    }

    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(ProductDescription description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (guarantee != product.guarantee) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        if (cart != null ? !cart.equals(product.cart) : product.cart != null) return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        if (model != null ? !model.equals(product.model) : product.model != null) return false;
        if (manager != null ? !manager.equals(product.manager) : product.manager != null) return false;
        if (category != null ? !category.equals(product.category) : product.category != null) return false;
        if (sale != null ? !sale.equals(product.sale) : product.sale != null) return false;
        return description != null ? description.equals(product.description) : product.description == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + guarantee;
        result = 31 * result + (cart != null ? cart.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (sale != null ? sale.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
