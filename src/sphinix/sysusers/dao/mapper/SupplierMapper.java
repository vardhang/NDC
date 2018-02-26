/**
 * 
 */
package sphinix.sysusers.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sphinix.sysusers.model.Products;
import sphinix.sysusers.model.Suppliers;

/**
 * @author Vardhan
 *
 */
public class SupplierMapper implements RowMapper<Suppliers>{

	@Override
	public Suppliers mapRow(ResultSet rs, int rowNum) throws SQLException {
		Suppliers suppliers = new Suppliers();
		suppliers.setSupplierId(rs.getInt("supplier_id"));
		suppliers.setSupplierName(rs.getString("supplier_name"));
		suppliers.setSupplierContactNo(rs.getString("supplier_contact_number"));
		suppliers.setSupplierContactPerson(rs.getString("supplier_contact_person"));
		suppliers.setSupplierDetails(rs.getString("supplier_details"));
		return suppliers;
	}

}
