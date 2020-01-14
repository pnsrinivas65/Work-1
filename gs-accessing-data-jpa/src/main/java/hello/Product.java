package hello;

import java.math.BigDecimal;



public class Product {
    String name;
    ProductType type;
    BigDecimal price;
    
    public Product(String name, ProductType type, BigDecimal price) {
    	this.name = name;
    	this.type = type;
    	this.price = price;
    }
    // Getters and Setters omitted
	public ProductType getType() {
		
		return type;
	}
	
	public void setType(ProductType type) {
		this.type = type;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
		
	}
}

