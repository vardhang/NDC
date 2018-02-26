/**
 * 
 */
package sphinix.sysusers.service;

import java.sql.Types;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import sphinix.sysusers.dao.RatesDAO;
import sphinix.sysusers.dao.mapper.ProductsMapper;
import sphinix.sysusers.dao.mapper.SupplierMapper;
import sphinix.sysusers.model.Products;
import sphinix.sysusers.model.Suppliers;

/**
 * @author Vardhan
 * 
 */
public class RatesDaoService implements RatesDAO {

	private static Logger logger = Logger.getLogger(RatesDaoService.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sphinix.sysusers.dao.RatesDAO#insertRates(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public String insertRates(String productName, String supplierName, String rate)
			throws Exception {
		int maxRows = jdbcTemplate.queryForInt("select max(rate_id) from product_rate");
		logger.info(" Max rows >>> " + maxRows);
		String productSql = "SELECT  * FROM product where product_name = ?";

		Products product = (Products) jdbcTemplate.queryForObject(productSql,
				new Object[] { productName }, new ProductsMapper());
		logger.info("Product Id >>> " + product.getProductId()	+ " product Name >>> " + product.getProductName());
		
		String supplierSql = "SELECT * FROM supplier where supplier_name=?";
		Suppliers supplier = (Suppliers) jdbcTemplate.queryForObject(supplierSql,
				new Object[] { supplierName }, new SupplierMapper());
		
		String insertSql = "INSERT INTO product_rate (rate_id, product_id, supplier_id,rate,created_date) VALUES (?,?,?,?,?)";

		Object[] params = new Object[] { (maxRows + 1), product.getProductId(),
				supplier.getSupplierId(), rate, new Date() };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER,
				Types.FLOAT, Types.DATE };
		int row = jdbcTemplate.update(insertSql, params, types);
		String message = null;
		if (row == 1) {
			message = "Success";
		} else {
			message = "Failure";
		}
		return message;
	}

}
