/**
 * 
 */
package com.sphinix.ndc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sphinix.ndc.model.Products;

/**
 * @author Vardhan
 *
 */
public class ProductsMapper implements RowMapper<Products>{

	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products products = new Products();
		products.setProductId(rs.getInt("product_id"));
		products.setProductName(rs.getString("product_name"));
		products.setProductDetails(rs.getString("product_details"));
		products.setProductCode(rs.getString("product_code"));
		return products;
	}

}
