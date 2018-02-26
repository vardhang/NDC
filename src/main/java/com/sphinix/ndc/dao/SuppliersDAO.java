/**
 * 
 */
package com.sphinix.ndc.dao;

import java.util.List;

import com.sphinix.ndc.model.Suppliers;

/**
 * @author Vardhan
 * 
 */
public interface SuppliersDAO {

	public String insertProducts(String supplierName, String contact,
			String contactPerson, String supplierDetails) throws Exception;
	
	public String updateProducts(String supplierName, String contact,
			String contactPerson, String supplierDetails) throws Exception;
	
	public List<Suppliers> getSuppliers() throws Exception;
	
	public List<Suppliers> getSuppliersByName(String name) throws Exception;

}
