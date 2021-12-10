package com.gcu.FrameworkLayer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController
{
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String display(Model model)
	{
		// Display login Form view
		return "account";
	}
}