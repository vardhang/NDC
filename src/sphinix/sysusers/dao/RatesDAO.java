/**
 * 
 */
package sphinix.sysusers.dao;


/**
 * @author Vardhan
 *
 */
public interface RatesDAO {
	
	public String insertRates(String productName, String supplierName, String rate ) throws Exception;

}
