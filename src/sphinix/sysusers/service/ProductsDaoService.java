/**
 * 
 */
package sphinix.sysusers.service;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import sphinix.sysusers.dao.ProductsDAO;
import sphinix.sysusers.dao.mapper.ProductRateMapper;
import sphinix.sysusers.dao.mapper.ProductsMapper;
import sphinix.sysusers.model.ProductRates;
import sphinix.sysusers.model.Products;

/**
 * @author Vardhan
 * 
 */
public class ProductsDaoService implements ProductsDAO {

	private static Logger logger = Logger.getLogger(ProductsDaoService.class);

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
	 * @see sphinix.sysusers.dao.ProductDAO#getProducts()
	 */
	@Override
	public List<Products> getAllProducts() throws Exception {
		List<Products> productsList = null;
		String sql = " SELECT * from Product";
		try {
			productsList = jdbcTemplate.query(sql, new ProductsMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return productsList;
	}

	@Override
	public List<Products> getProductsByName(String productName)
			throws Exception {
		List<Products> productsList = null;
		String sql = " SELECT * from Product where product_name like  ?";
		try {
			productsList = jdbcTemplate.query(sql, new Object[] { "%"
					+ productName + "%" }, new ProductsMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return productsList;
	}

	@Override
	public List<Products> getProductsByCode(String productCode)
			throws Exception {
		List<Products> productsList = null;
		String sql = " SELECT * from Product where product_code like  ?";
		try {
			productsList = jdbcTemplate.query(sql, new Object[] { "%"
					+ productCode + "%" }, new ProductsMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return productsList;
	}

	@Override
	public String insertProducts(String productCode, String productName,
			String productDetails) throws Exception {
		// TODO Auto-generated method stub
		int maxRows = jdbcTemplate
				.queryForInt("select max(product_id) from product");
		logger.info(" Max rows >>> " + maxRows);
		Object[] params = new Object[] { (maxRows + 1), productCode,
				productName, productDetails };
		int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR };
		String insertSql = "INSERT INTO product (product_id, product_code, product_name, product_details) VALUES (?,?,?,?)";
		int row = jdbcTemplate.update(insertSql, params, types);
		String message = null;
		if (row == 1) {
			message = "Success";
		} else {
			message = "Failure";
		}
		return message;
	}

	@Override
	public List<ProductRates> getProductRates( String productCode,String productName)
			throws Exception {
		List<ProductRates> productRateList = null;
		String sql=null;
		String temp=null;
		if(productCode!="" && productCode!=null){
			temp=productCode;
		 sql = " select P.product_id,P.product_code, P.product_name, S.supplier_name, PR.rate from product P, product_rate PR, supplier S"
				+ " where   P.product_id = PR.product_id and S.supplier_id = PR.supplier_id and P.product_code=? order by rate limit 1";
		} else {
			temp = productName;
			sql = " select P.product_id,P.product_code, P.product_name, S.supplier_name, PR.rate from product P, product_rate PR, supplier S"
					+ " where   P.product_id = PR.product_id and S.supplier_id = PR.supplier_id and P.product_name=? order by rate limit 1";
		}
		
		try {
			productRateList = jdbcTemplate.query(sql,
					new Object[] { temp }, new ProductRateMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return productRateList;
	}

	@Override
	public List<ProductRates> getProductSupplierRates(String productId)
			throws Exception {
		List<ProductRates> productRateList = null;
		String sql = null;
		try {
			System.out.println(" Product Id in Dao >>>>>>>>>>>>>> ");
			if (productId != null && productId != "") {
				logger.info(" Product Id from UI page >>> " + productId);
				sql = "select p.product_id, p.product_code, p.product_name, s.supplier_name, pr.rate from product p, supplier s, "
						+ "product_rate pr where p.product_code = ? and p.product_id=pr.product_id and pr.supplier_id=s.supplier_id order by pr.rate ";
				productRateList = jdbcTemplate.query(sql,
						new Object[] { productId }, new ProductRateMapper());

			} else {
				sql = "select p.product_id,p.product_code, p.product_name, s.supplier_name, pr.rate from product p, supplier s,"
						+ "product_rate pr where p.product_id=pr.product_id and pr.supplier_id=s.supplier_id ";
				productRateList = jdbcTemplate.query(sql, new Object[] {},
						new ProductRateMapper());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		logger.info(" Result Size >>> "+ productRateList.size());
		return productRateList;
	}

	@Override
	public String updateProducts(String productCode, String productName,
			String productDetails) throws Exception {
		logger.info(" Update Products >>>> ");
		Object[] params = new Object[] { productName, productDetails,
				productCode };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		String insertSql = "UPDATE product SET product_name=?, product_details=? where product_code=?";
		int row = jdbcTemplate.update(insertSql, params, types);
		String message = null;
		if (row == 1) {
			message = "Successfully Updated";
		} else {
			message = "Failure";
		}
		return message;
	}

}
