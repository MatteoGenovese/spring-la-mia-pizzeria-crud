package org.generation.italy.demo.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizza")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@NotNull(message="Pizza name must not be null")
	@Size(min=3, max=32, message="Pizza name must be min 3 charachters")
	@Column(name="name")
	private String name;
	
	
	@NotNull
	@NotEmpty(message = "description must contain something")
	@Column(length = 128)
	private String description;
	

	@Min(value=0)
	private int price;

	public Pizza() { }
	public Pizza(
			@NotNull(message = "Pizza name must not be null") @Size(min = 3, max = 32, message = "Pizza name must be min 3 charachters") String name,
			@NotNull @NotEmpty(message = "description must contain something") String description,
			@NotNull @Min(0) int price) {
		super();
		setName(name);
		setDescription(description) ;
		setPrice(price);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {

		return "id - "+getId()+
				"\nname - "+ getName()+
				"\ndescription - "+ getDescription()+
				"\nprice - "+ getPrice();
	}
	
	
	
	
	

}