package com.realdolmen.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.realdolmen.dao.ProductDAO;
import com.realdolmen.domain.Product;

/**
 * http://localhost:8080/SpringMVC/employee
 * 
 * @author Marco Brasci
 * 
 */
@Controller
public class ProductController extends AbstractController{
	private final static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String testEmployee(Model model) {
		return "app/products/add";
	}
	@RequestMapping(value = "/products/model/deletePopup", method = RequestMethod.GET)
	public String findDeleteProductModel() {
		return "app/products/model/deletePopup";
	}
	
	@RequestMapping(value = "/products/delete", method = RequestMethod.POST)
	public @ResponseBody ErrorObject deleteProduct(@RequestBody Product product, Model model) {
		LOGGER.info("Deleting product: {}", product.getName());
		
		try{
			productDAO.delete(product);
			return new ErrorObject(Status.OK, "Product was deleted with success !");
		}catch(Exception e){
			return new ErrorObject(Status.ERROR, "Could not delete product.");
		}
	}
	
	@RequestMapping(value = "/products/products.json", method = RequestMethod.GET)
	public @ResponseBody List<Product> findAllProducts(Model model) {
		List<Product> products = productDAO.findAll();
		return products;
	}


}