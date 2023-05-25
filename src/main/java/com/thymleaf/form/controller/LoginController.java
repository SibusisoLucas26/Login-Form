package com.thymleaf.form.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymleaf.form.model.LoginForm;

import ch.qos.logback.core.model.Model;

@org.springframework.stereotype.Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getForm() {
		//return login.html
		return"login";
	}
	
	@GetMapping("/")
	public String welcome() {
		return"index";
	}
	
	//details checking
	@PostMapping("/login")
	public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {
		
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		//Condition login
		if ("admin".equals(username) && "admin".equals(password)) {
			// homeAdmin.hhtp
			return"homeAdmin";
		}
		
		else if ("user".equals(username) && "user".equals(password)) {
			// user Home page
			return"userPage";
		}
		
		else {return"login";}
	
	}

}
