/**
 * 
 */
package sphinix.sysusers.dao;

import java.util.List;

import sphinix.sysusers.model.ProductRates;
import sphinix.sysusers.model.Products;

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
