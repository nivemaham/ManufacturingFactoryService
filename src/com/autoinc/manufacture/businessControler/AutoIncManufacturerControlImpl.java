package com.autoinc.manufacture.businessControler;

import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;

import com.autoinc.manufacture.bdo.InventoryEntry;
import com.autoinc.manufacture.dao.InventoryDAO;
import com.autoinc.manufacture.dao.ProductDAO;
import com.autoinc.manufacture.dao.WarehouseDAO;
import com.autoinc.util.HibernateUtil;
import com.autoinc.util.HibernateUtilImpl;

public class AutoIncManufacturerControlImpl implements
		AutoIncManufacturerControl {

	private HibernateUtil hibernateUtil = new HibernateUtilImpl();

	@Override
	public boolean canCreateProduct(int productSpecId) {
		return new Random().nextBoolean();
	}

	@Override
	public int createProducts(int productSpecId, int wareHouseId, int quantity) {

		Session session = hibernateUtil.getSession();
		session.beginTransaction();

		String hql = "SELECT I FROM InventoryDAO I WHERE I.warehouse.id=:warehouseId and I.product.productId=:productSpecId";
		Query query = session.createQuery(hql);
		query.setParameter("warehouseId", wareHouseId);
		query.setParameter("productSpecId", productSpecId);
		InventoryDAO results = (InventoryDAO) query.uniqueResult();

		if (results != null) {
			results.setQuantity(results.getQuantity() + quantity);
			session.saveOrUpdate(results);
		} else {
			 results = new InventoryDAO();

			ProductDAO product = (ProductDAO) session.get(ProductDAO.class,
					productSpecId);

			WarehouseDAO wareHouse = (WarehouseDAO) session.get(
					WarehouseDAO.class, wareHouseId);
			results.setProduct(product);
			results.setWarehouse(wareHouse);
			results.setQuantity(quantity);
			session.saveOrUpdate(results);
		}
		session.getTransaction().commit();
		session.close();

		return results.getId();
	}

	@Override
	public String addInventoryEntry(
			int productSpecId, int wareHouseId , int Quantity) {

		Session session = hibernateUtil.getSession();
		session.beginTransaction();

		ProductDAO product = (ProductDAO) session.get(ProductDAO.class,
				productSpecId);

		WarehouseDAO wareHouse = (WarehouseDAO) session.get(WarehouseDAO.class,
				wareHouseId);

		InventoryDAO newInventory = new InventoryDAO(Quantity,
				product, wareHouse);
		session.save(newInventory);
		session.getTransaction().commit();
		session.close();

		return Integer.toString(newInventory.getId());
	}

}
