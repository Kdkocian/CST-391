package com.kyle.milestonegames.entities;

import javax.persistence.*;

@Entity
@Table(name = "Games")
public class Game {
	//Game Variables
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "Title")
	private String Title;
	
	@Column(name = "Type")
	private String Type;
	
	@Column(name = "Price")
	private Float price;

	
	//Getters and Setters for game variables
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
		 
}
