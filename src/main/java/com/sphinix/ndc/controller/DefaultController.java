package com.sphinix.ndc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sphinix.ndc.dao.UserDAO;

@Controller
public class DefaultController {
	private static Logger logger = LogManager.getLogger(DefaultController.class);
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("sysusers/search");

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody
	boolean checkLogin(@RequestParam("login") String login,
			@RequestParam("password") String password)  {
		logger.debug(" checking user and password " + login);
		System.out.println(" checking user and password " + login);
		Boolean isUserValid=false;
		try {
			isUserValid = userDAO.checkUser(login, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isUserValid;

	}
}
