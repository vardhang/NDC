package sphinix.sysusers.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sphinix.sysusers.dao.SuppliersDAO;
import sphinix.sysusers.model.Products;
import sphinix.sysusers.model.Suppliers;

import com.google.gson.Gson;

@Controller
public class SupplierController {
	private static Logger logger = Logger.getLogger(SupplierController.class);
	@Autowired
	private SuppliersDAO suppliersDAO;

	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("sysusers/suppliers");

	}
	
	@RequestMapping(value = "/insert_suppliers", method = RequestMethod.GET)
	public @ResponseBody
	String insertSuppliers(@RequestParam("supplierName") String supplierName,@RequestParam("contact") String contact,@RequestParam("contactPerson") String contactPerson,@RequestParam("supplierDetails") String supplierDetails ) {
		String result=null;
		try {
			logger.info(" supplierName >> "+ supplierName+ " contact >> "+ contact+" contactPerson >>"+ contactPerson+" supplierDetails "+supplierDetails);
			result = suppliersDAO.insertProducts(supplierName, contact, contactPerson,supplierDetails);
			logger.info(" Resule >> "+ result);
		} catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}
		return result;
	}

	@RequestMapping(value = "/update_suppliers", method = RequestMethod.GET)
	public @ResponseBody
	String updateSuppliers(@RequestParam("supplierName") String supplierName,@RequestParam("contact") String contact,@RequestParam("contactPerson") String contactPerson,@RequestParam("supplierDetails") String supplierDetails ) {
		String result=null;
		try {
			logger.info(" supplierName >> "+ supplierName+ " contact >> "+ contact+" contactPerson >>"+ contactPerson+" supplierDetails "+supplierDetails);
			result = suppliersDAO.insertProducts(supplierName, contact, contactPerson,supplierDetails);
			logger.info(" Resule >> "+ result);
		} catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}
		return result;
	}

	
@RequestMapping(value = "/get_suppliers", method = RequestMethod.GET)
public @ResponseBody String getSuppliers() {
	try {
		List<Suppliers> supplierList = suppliersDAO.getSuppliers();
		Gson gson = new Gson();
		return gson.toJson(supplierList);
	}
	catch (Exception e) {
		System.out.println(e);
		return (e.getMessage());
	}
 }

@RequestMapping(value = "/get_suppliers_by_name", method = RequestMethod.GET)
public @ResponseBody String getSuppliersByName(@RequestParam("supplierName") String supplierName) {
	try {
		List<Suppliers> supplierList = suppliersDAO.getSuppliersByName(supplierName);
		Gson gson = new Gson();
		return gson.toJson(supplierList);
	}
	catch (Exception e) {
		System.out.println(e);
		return (e.getMessage());
	}
 }

@RequestMapping(value = "/get_supplier_name", method = RequestMethod.GET)
public @ResponseBody
String getSuppliersNames(@RequestParam("term") String query) {
	try {
		List<String> supplierNames = new ArrayList<String>();
		List<Suppliers> supplierList =  suppliersDAO.getSuppliersByName(query);
		 for (Suppliers suppliers : supplierList) {
			 supplierNames.add(suppliers.getSupplierName());
			}
		Gson gson = new Gson();
		return gson.toJson(supplierNames);
	}catch (Exception e) {
		System.out.println(e);
		return e.getMessage();
	}
}

}