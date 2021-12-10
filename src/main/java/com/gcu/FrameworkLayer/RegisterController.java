package com.gcu.FrameworkLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.ReferenceArchitectureLayer.UserDatabaseModelInterface;
import com.gcu.ReferenceArchitectureLayer.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController 
{
	@Autowired
	private UserDatabaseModelInterface userBS;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String display(Model model)
	{
		// Display register Form view
		model.addAttribute("title", "Register Form");
		model.addAttribute("user", new UserModel());
		return "register";
	}
	
	@RequestMapping("/saveaccount")
	public String saveAccount(UserModel newuser)
	{
		System.out.println("==> " + newuser.toString());
		newuser.setFirstName("temp");
		newuser.setLastName("temp");
		newuser.setPhoneNumber("temp");
		
		userBS.addUser(newuser);
		System.out.println();
		System.out.println("FrameworkLayer/RegisterController: Creating '" + newuser.getUsername() + "' as a new user");
		System.out.println("	-> " + newuser.toString());
		System.out.println("	-> There are now a total of " + userBS.getAllusers().size() + " users registered");
		return "home";
	}
}