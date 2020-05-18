package com.midhun.vehiclepricelist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_price")
public class VehiclePrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "make_name")
	private String makeName;
	@Column(name = "model_name")
	private String modelName;
	@Column(name = "price")
	private Double price;
	@Column(name = "option_name")
	private String optionName;
	@Column(name = "option_price")
	private Double optionPrice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMakeName() {
		return makeName;
	}
	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Double getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(Double optionPrice) {
		this.optionPrice = optionPrice;
	}

	
}