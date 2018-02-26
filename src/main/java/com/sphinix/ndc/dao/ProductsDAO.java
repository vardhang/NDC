/**
 * 
 */
package com.sphinix.ndc.dao;

import java.util.List;

import com.sphinix.ndc.model.ProductRates;
import com.sphinix.ndc.model.Products;

/**
 * @author Vardhan
 *
 */
public interface ProductsDAO {
	
	public List<Products> getAllProducts() throws Exception;
	
	public List<Products> getProductsByName(String productName) throws Exception;
	
	public List<Products> getProductsByCode(String productCode) throws Exception;
	
	public String insertProducts(String productCode, String productName, String productDetails) throws Exception;
	
	public String updateProducts(String productCode, String productName, String productDetails) throws Exception;
	
	public List<ProductRates> getProductRates( String productCode,String productName) throws Exception;
	
	public List<ProductRates> getProductSupplierRates(String productId)throws Exception;
}
