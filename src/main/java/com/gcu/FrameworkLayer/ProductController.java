package com.gcu.FrameworkLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.BusinessLayer.ProductBusinessServiceInterface;

@Controller
@RequestMapping("/products")
public class ProductController
{
	@Autowired
	private ProductBusinessServiceInterface productBS;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String display(Model model)
	{
		// Display login Form view
		model.addAttribute("title", "Products");
		model.addAttribute("products", productBS.getAllproducts());
		return "products";
	}
}