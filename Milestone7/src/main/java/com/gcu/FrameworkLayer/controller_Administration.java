package com.gcu.FrameworkLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.BusinessLayer.ProductBusinessServiceInterface;
import com.gcu.ReferenceArchitectureLayer.ProductModel;

@Controller
@RequestMapping("/admin")
public class controller_Administration 
{
	@Autowired
	private ProductBusinessServiceInterface productBS;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String display(Model model)
	{
		model.addAttribute("title", "Edit product");
		model.addAttribute("products", productBS.getAllproducts());
		return "product_Display";
	}
	
	@PostMapping("/editproduct")
	public String editProduct(ProductModel product, Model model)
	{
		// Display register Form view
		model.addAttribute("product", product);
		return "product_Edit";
	}
	
	@RequestMapping("/saveedit")
	public String saveEdit(ProductModel newProduct, Model model)
	{
		productBS.updateProduct(newProduct);
		System.out.println();
		System.out.println("FrameworkLayer/RegisterController: Editing '" + newProduct.getName() + "'");
		System.out.println("	-> " + newProduct.toString());
		System.out.println("	-> There are a total of " + productBS.getAllproducts().size() + " products");
		
		model.addAttribute("products", productBS.getAllproducts());
		return "product_Display";
	}
	
	@PostMapping("/delete")
	public String deleteProduct(ProductModel product, Model model)
	{
		productBS.removeProduct(product);
		
		model.addAttribute("products", productBS.getAllproducts());
		return "product_Display";
	}
}
