package com.nikhil.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nikhil.sportyshoes.model.User;
import com.nikhil.sportyshoes.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public String userRegistrationPage(Model model)
	{
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") User user)
	{
		user.setRoles("USER");
		service.registerUser(user);
		return "redirect:/registration?success";
	}
}
