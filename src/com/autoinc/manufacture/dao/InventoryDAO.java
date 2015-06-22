package com.autoinc.manufacture.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.autoinc.manufacture.bdo.InventoryEntry;

@Entity
@Table(name = "inventory")
public class InventoryDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	@Column(name = "id",nullable=false)
	private int id;
	
	  
	@OneToOne
	@JoinColumn(name = "warehouseId",nullable=false)
	private WarehouseDAO warehouse;
	
	@OneToOne
	@JoinColumn(name = "productSpecId",nullable=false)
	private ProductDAO product;
	  
	@Column(name = "quantity",nullable=false)
	private int quantity;


	public InventoryDAO() {
	}
	
	public InventoryDAO(int quantity, ProductDAO product2, WarehouseDAO warehouse) {
		this.product = product2;
		this.quantity = quantity;
		this.warehouse = warehouse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public WarehouseDAO getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseDAO warehouse) {
		this.warehouse = warehouse;
	}

	

	public ProductDAO getProduct() {
		return product;
	}

	public void setProduct(ProductDAO product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
