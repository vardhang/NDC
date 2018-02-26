package com.sphinix.ndc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sphinix.ndc.dao.ProductsDAO;
import com.sphinix.ndc.model.ProductRates;
import com.sphinix.ndc.model.Products;

@Controller
public class SearchController {
	private static Logger logger = LogManager.getLogger(SearchController.class);
	@Autowired
	private ProductsDAO productDao;

	@RequestMapping(value = "/get_search_Code", method = RequestMethod.GET)
	public @ResponseBody
	String getProductCodes(@RequestParam("term") String query) {
		System.out.println(" Product Name >>> "+ query);
		try {
			 List<Products> products = new ArrayList<Products>();
			 products =  productDao.getProductsByName(query);
			 for (Products products2 : products) {
				System.out.println(" Name >> "+ products2.getProductName());
			}
			Gson gson = new Gson();
			return gson.toJson(products);
		}catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = "/get_search_Name", method = RequestMethod.GET)
	public @ResponseBody
	String getProductNames(@RequestParam("term") String query) {
		try {
			 List<String> productNames = new ArrayList<String>();
			 List<Products> productsList =  productDao.getProductsByName(query);
			 for (Products products : productsList) {
				 productNames.add(products.getProductName());
			}
			Gson gson = new Gson();
			return gson.toJson(productNames);
		}catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}
	}


	@RequestMapping(value = "/get_products", method = RequestMethod.GET)
	public @ResponseBody
	String getProducts(@RequestParam("productName") String productName) {
		try {
			List<Products> productsList =  productDao.getProductsByName(productName);
			Gson gson = new Gson();
			logger.info((gson.toJson(productsList)));
			return gson.toJson(productsList);
		}catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}

	}
	
	
	@RequestMapping(value = "/get_product_rates", method = RequestMethod.GET)
	public @ResponseBody
	String getProductRates(@RequestParam("productCode") String productCode, @RequestParam("productName") String productName) {
		try {
			List<ProductRates> productsList =  productDao.getProductRates(productCode,productName);
			Gson gson = new Gson();
			logger.info((gson.toJson(productsList)));
			return gson.toJson(productsList);
		}catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}

	}

/*	@RequestMapping(value = "/get_supplier_product_rates", method = RequestMethod.GET)
	public @ResponseBody
	String getSupplierProductRates(@RequestParam("productId") String productId) {
		try {
			logger.info(" Supplier Product Rates >>>> "+ productId);
			List<ProductRates> productsList =  productDao.getProductSupplierRates(productId);
			Gson gson = new Gson();
			logger.info((gson.toJson(productsList)));
			return gson.toJson(productsList);
		}catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}

	}*/

	@RequestMapping(value = "/get_supplier_product_rates", method = RequestMethod.GET)
	public @ResponseBody
	String getSupplierProductRates(@RequestParam("productId") String productId) {
		try {
			logger.info(" Supplier Product Rates >>>> "+ productId);
			List<ProductRates> productsList =  productDao.getProductSupplierRates(productId);
			/*JSONObject jsonResponse = new JSONObject();
			jsonResponse.put("sEcho", 10);
			jsonResponse.put("iTotalRecords", productsList.size());
			jsonResponse.put("iTotalDisplayRecords", productsList.size());
			jsonResponse.put("aaData", productsList);
			return (jsonResponse.toString());*/
			Gson gson = new Gson();
			logger.info((gson.toJson(productsList)));
			return gson.toJson(productsList);
		}catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}

	}
	@RequestMapping(value = "/get_all_products", method = RequestMethod.GET)
	public @ResponseBody String getAllProducts() {
		try {
			List<Products> productsList =  productDao.getAllProducts();
			for (Products products : productsList) {
				System.out.println(products.getProductId()+" "+ products.getProductName()+" "+ products.getProductDetails());
			}
			JSONObject jsonResponse = new JSONObject();
			jsonResponse.put("sEcho", 10);
			jsonResponse.put("iTotalRecords", productsList.size());
			jsonResponse.put("iTotalDisplayRecords", productsList.size());
			jsonResponse.put("aaData", productsList);
			return (jsonResponse.toString());
		}catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}
	}
}
