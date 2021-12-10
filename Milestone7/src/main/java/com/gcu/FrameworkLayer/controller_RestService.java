package com.gcu.FrameworkLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.BusinessLayer.ProductBusinessServiceInterface;
import com.gcu.ReferenceArchitectureLayer.ProductModel;

@Controller
@RequestMapping("/rest-service")
public class controller_RestService 
{
	@Autowired
	private ProductBusinessServiceInterface productBS;
	
	@GetMapping("/")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String restService_Home(Model model)
	{
		model.addAttribute("title", "Rest Service");
		return "restService_Home";
	}
	
	@GetMapping(path="/products", produces= {"application/json"})
	public ResponseEntity<?> restService_ReturnProducts(Model model)
	{	
		try
		{
			List<ProductModel> products = productBS.getAllproducts();
			if (products == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(products, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}