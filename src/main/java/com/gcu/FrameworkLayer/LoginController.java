package com.gcu.FrameworkLayer;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.BusinessLayer.SessionBean;
import com.gcu.ReferenceArchitectureLayer.UserDatabaseModelInterface;
import com.gcu.ReferenceArchitectureLayer.UserModel;

@Controller
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	private UserDatabaseModelInterface userBS;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String display(Model model)
	{
		// Display login Form view
		model.addAttribute("title", "Login Form");
		model.addAttribute("userModel", new UserModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid UserModel userModel, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		List<UserModel> databaseReturns = userBS.getAllusers();
		
		System.out.println(">> " + databaseReturns.size());
		for(int i = 0; i < databaseReturns.size(); i++)
		{
			System.out.println(">>>" + databaseReturns.get(i).getUsername());
			
			if (userModel.getUsername().equals(databaseReturns.get(i).getUsername()) && userModel.getPassword().equals(databaseReturns.get(i).getPassword()))
			{
				SessionBean currentSession = new SessionBean();
				currentSession.setCurrentUser(userModel);
				
				model.addAttribute("user", userModel);
				return "home";
			}
		}
		
		return "login";
		
		/*if (databaseReturns.size() <= 0 || databaseReturns.get(1).getPassword() != userModel.getPassword())
		{
			
		}
		else
		{
			//@Autowired
			
		}*/

	}
}