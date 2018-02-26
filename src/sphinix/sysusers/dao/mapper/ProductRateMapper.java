/**
 * 
 */
package sphinix.sysusers.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sphinix.sysusers.model.ProductRates;
import sphinix.sysusers.model.Products;

/**
 * @author Vardhan
 *
 */
public class ProductRateMapper implements RowMapper<ProductRates>{

	@Override
	public ProductRates mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductRates productRates = new ProductRates();
		productRates.setProductId(rs.getInt("product_id"));
		productRates.setProductCode(rs.getString("product_code"));
		productRates.setProductName(rs.getString("product_name"));
		productRates.setSupplierName(rs.getString("supplier_name"));
		productRates.setRate(rs.getString("rate"));
		return productRates;
	}

}
