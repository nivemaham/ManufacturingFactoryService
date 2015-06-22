package com.autoinc.manufacture.businessControler;



public interface AutoIncManufacturerControl {
	
	boolean canCreateProduct(int productSpecId);
	
	int createProducts(int productSpecId, int wareHouseId , int Quantity);
	
	String addInventoryEntry(int productSpecId, int wareHouseId , int Quantity);

}
