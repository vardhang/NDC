/**
 * 
 */
package com.sphinix.ndc.service;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sphinix.ndc.dao.SuppliersDAO;
import com.sphinix.ndc.dao.mapper.SupplierMapper;
import com.sphinix.ndc.model.Suppliers;


/**
 * @author Vardhan
 *
 */
public class SuppliersDaoService implements SuppliersDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see sphinix.sysusers.dao.SuppliersDAO#insertProducts(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String insertProducts(String supplierName, String contact,
			String contactPerson, String supplierDetails) throws Exception {
		int maxRows = jdbcTemplate.queryForInt("select max(supplier_id) from supplier");
		System.out.println(" Max rows >>> "+ maxRows);
		 Object[] params = new Object[] { (maxRows+1), supplierName, contact, contactPerson,supplierDetails };
		 int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		String insertSql = "INSERT INTO supplier (supplier_id, supplier_name, supplier_contact_number,supplier_contact_person, supplier_details) VALUES (?,?,?,?,?)";
		int row = jdbcTemplate.update(insertSql, params, types);
		String message=null;
		if(row == 1){
			message = "Success";
		}else{
			message = "Failure";
		}
		return message;
	}

	public List<Suppliers> getSuppliers() throws Exception {
		List<Suppliers> suppliersList=null;
		String sql = " SELECT * from supplier";
		try {
			suppliersList = jdbcTemplate.query(
					sql, new Object[] {}, new SupplierMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return suppliersList;
	}

	public List<Suppliers> getSuppliersByName(String name) throws Exception {
		List<Suppliers> suppliersList=null;
		String sql = " SELECT * from supplier where supplier_name like  ?";
		try {
			suppliersList = jdbcTemplate.query(
					sql, new Object[] {"%" + name + "%"}, new SupplierMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return suppliersList;
	}

	public String updateProducts(String supplierName, String contact,
			String contactPerson, String supplierDetails) throws Exception {
		
		 Object[] params = new Object[] {  contact, contactPerson,supplierDetails,supplierName };
		 int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		String insertSql = "UPDATE supplier SET supplier_contact_number=?,supplier_contact_person=?, supplier_details=? where supplier_name=?";
		int row = jdbcTemplate.update(insertSql, params, types);
		String message=null;
		if(row == 1){
			message = "Successfully Updated";
		}else{
			message = "Failure";
		}
		return message;
	}

}
