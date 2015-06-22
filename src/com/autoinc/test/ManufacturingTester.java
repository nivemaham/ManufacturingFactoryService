package com.autoinc.test;

import com.autoinc.manufacture.businessControler.AutoIncManufacturerControl;
import com.autoinc.manufacture.businessControler.AutoIncManufacturerControlImpl;

public class ManufacturingTester {

	public static void main(String[] args) {
		
		AutoIncManufacturerControl control = new AutoIncManufacturerControlImpl();
		
//		System.out.print( control.canCreateProduct(1));
		
//		InventoryEntry newEntry = new InventoryEntry();
//		newEntry.setProductSpecId(2);
//		newEntry.setQuantity(10);
//		newEntry.setWareHouseId(1);
//		control.addInventoryEntry(newEntry);
		
		control.createProducts(3, 2, 5);

	}

}
