package es.altran.curso;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = -6572446215284230076L;
	int id;
	double price;
	String name;
	
	public Product(int id, double price, String name) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", name=" + name + "]";
	}
	
	

}
