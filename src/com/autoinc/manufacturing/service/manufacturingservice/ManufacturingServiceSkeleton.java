/**
 * ManufacturingServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.autoinc.manufacturing.service.manufacturingservice;

import com.autoinc.manufacture.businessControler.AutoIncManufacturerControl;
import com.autoinc.manufacture.businessControler.AutoIncManufacturerControlImpl;

/**
 * ManufacturingServiceSkeleton java skeleton for the axisService
 */
public class ManufacturingServiceSkeleton {
	AutoIncManufacturerControl control = new AutoIncManufacturerControlImpl();

	/**
	 * Auto generated method signature
	 * 
	 * @param createProducts
	 * @return createProductsResponse
	 */

	public com.autoinc.manufacturing.service.manufacturingservice.CreateProductsResponse createProducts(
			com.autoinc.manufacturing.service.manufacturingservice.CreateProducts createProducts) {
		CreateProductsResponse response = new CreateProductsResponse();
		response.setIsCreated(control.createProducts(
				createProducts.getProductSpecid(),
				createProducts.getWarehouseid(), createProducts.getQuantity()) > 0 ? true
				: false);
		response.setCustomerid(createProducts.getCustomerid());
		return response;
	}

}
