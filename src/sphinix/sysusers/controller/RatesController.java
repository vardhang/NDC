package sphinix.sysusers.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sphinix.sysusers.dao.RatesDAO;

@Controller
public class RatesController {
	private static Logger logger = Logger.getLogger(RatesController.class);
	@Autowired
	private RatesDAO ratesDAO;

	@RequestMapping(value = "/rates", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("sysusers/rates");

	}
	

	@RequestMapping(value = "/insert_rates", method = RequestMethod.GET)
	public @ResponseBody
	String insertRates(@RequestParam("productName") String productName,@RequestParam("supplierName") String supplierName,@RequestParam("rate") String rate ) {
		String result=null;
		try {
			logger.info(" productName >> "+ productName+ " supplierName >> "+ supplierName+" rate >>"+ rate);
			result = ratesDAO.insertRates(productName, supplierName, rate);
		} catch (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}
		return result;
	}
	

}
