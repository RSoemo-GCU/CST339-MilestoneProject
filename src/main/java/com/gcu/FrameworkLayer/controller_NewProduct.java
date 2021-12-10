package com.gcu.FrameworkLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.BusinessLayer.ProductBusinessServiceInterface;
import com.gcu.ReferenceArchitectureLayer.ProductModel;

@Controller
@RequestMapping("/addNewproduct")
public class controller_NewProduct 
{
	@Autowired
	private ProductBusinessServiceInterface productBS;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String display(Model model)
	{
		// Display register Form view
		model.addAttribute("product", new ProductModel());
		return "product_New";
	}
	
	@RequestMapping("/save")
	public String saveAccount(ProductModel newProduct, Model model)
	{
		productBS.addProduct(newProduct);
		System.out.println();
		System.out.println("FrameworkLayer/RegisterController: Creating '" + newProduct.getName() + "' as a new product");
		System.out.println("	-> " + newProduct.toString());
		System.out.println("	-> There are now a total of " + productBS.getAllproducts().size() + " products");
		
		model.addAttribute("products", productBS.getAllproducts());
		return "product_Display";
	}
}