package com.wellsfargo.coronakit.entity;

public class CoronaKit {

	private Integer id;
	private String name;
	private String description;
	private Double cost;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public CoronaKit(Integer id, String name, String description, Double cost) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "CoronaKit [id=" + id + ", name=" + name + ", description=" + description + ", cost=" + cost + "]";
	}
	
	
	
}
