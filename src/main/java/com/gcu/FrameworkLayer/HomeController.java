package com.gcu.FrameworkLayer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.ReferenceArchitectureLayer.LoginModel;

@Controller
@RequestMapping("")
public class HomeController
{
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String display(Model model)
	{
		// Display home page
		model.addAttribute("title", "Home");
		
		LoginModel a = new LoginModel();
		a.setUsername("a");
		model.addAttribute("user", a);
		
		
		return "home";
	}
}