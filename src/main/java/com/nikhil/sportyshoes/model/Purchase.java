package com.nikhil.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String date;
	private String totalCost;
	@ManyToOne
	private User user;
	
	public Purchase() {}

	public Purchase(String name, String date, String totalCost, User user) {
		super();
		this.name = name;
		this.date = date;
		this.totalCost = totalCost;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
