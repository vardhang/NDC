package sphinix.sysusers.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import sphinix.sysusers.dao.ProductsDAO;
import sphinix.sysusers.model.Products;

@Controller
public class ProductController {
	private static Logger logger = Logger.getLogger(ProductController.class);
	@Autowired
	private ProductsDAO productDao;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("sysusers/products");

	}

	@RequestMapping(value = "/allproducts", method = RequestMethod.GET)
	public ModelAndView index1(HttpServletRequest request) {
		String productId = request.getParameter("productId");
		return new ModelAndView("sysusers/allproducts").addObject("productId", productId);

	}
	
	@RequestMapping(value = "/get_product_code", method = RequestMethod.GET)
	public @ResponseBody
	String getProductCodes(@RequestParam("term") String query) {
		try {
			List<String> productCodes = new ArrayList<String>();
			List<Products> productsList =  productDao.getProductsByCode(query);
			 for (Products products : productsList) {
				 productCodes.add(products.getProductCode());
				}
			Gson gson = new Gson();
			return gson.toJson(productCodes);
		}catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/get_product_name", method = RequestMethod.GET)
	public @ResponseBody
	String getProductNames(@RequestParam("term") String query) {
		try {
			List<String> productNames = new ArrayList<String>();
			List<Products> productsList = productDao.getProductsByName(query);
			for (Products products : productsList) {
				productNames.add(products.getProductName());
			}
			Gson gson = new Gson();
			return gson.toJson(productNames);
		} catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}
	}

	
	@RequestMapping(value = "/insert_products", method = RequestMethod.GET)
	public @ResponseBody
	String insertProducts(@RequestParam("productCode") String productCode,@RequestParam("productName") String productName,@RequestParam("productDetails") String productDetails ) {
		String result=null;
		try {
			logger.info(" Product Code >> "+ productCode+ " Product Name >> "+ productName+" product Detail >>"+ productDetails);
			result = productDao.insertProducts(productCode, productName, productDetails);
		} catch (Exception e) {
			return "Record already existed";
		}
		return result;
	}
	
	@RequestMapping(value = "/update_products", method = RequestMethod.GET)
	public @ResponseBody
	String updateProducts(@RequestParam("productCode") String productCode,@RequestParam("productName") String productName,@RequestParam("productDetails") String productDetails ) {
		String result=null;
		try {
			logger.info(" Product Code >> "+ productCode+ " Product Name >> "+ productName+" product Detail >>"+ productDetails);
			result = productDao.updateProducts(productCode, productName, productDetails);
		} catch (Exception e) {
			return "Record already existed";
		}
		return result;
	}
	
	@RequestMapping(value = "/get_product", method = RequestMethod.GET)
	public @ResponseBody
	String getProductNameAndDetails(@RequestParam("code") String code, @RequestParam("name") String name) {
		try {
			List<Products> productsList= null; 
			if(code!=null ){
				productsList =  productDao.getProductsByCode(code);
			} else {
				productsList =  productDao.getProductsByName(name);
			}
			
			Gson gson = new Gson();
			return gson.toJson(productsList);
		}catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}
	}
}
