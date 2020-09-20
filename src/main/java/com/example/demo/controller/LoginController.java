package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.CaptchaService;

@Controller
public class LoginController{
	
	@Autowired
	CaptchaService captchaService;
	
	@GetMapping("/signup")
	public String welcome(Model model) {
		System.out.println("Inside controller");
		/*
		 * try { //model.addAttribute("message", "Welcome Rubina !!"); } catch(Exception
		 * e) { e.printStackTrace(); }
		 */
		
		return "signup";
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestParam(name = "email") String email, @RequestParam(name = "fname") String firstName, 
			@RequestParam(name = "lname") String lastName, @RequestParam(name = "g-recaptcha-response") String captchaResponse, Model model) {
		try {
		
		System.out.println("Inside controller - authenticate post ");
		
		boolean res = captchaService.processResponse(captchaResponse);
		if(res)
			model.addAttribute("message", "Successful Registration ....");
		else
			model.addAttribute("message", "Recaptcha validation failed ....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		  		 
		
		return "authenticate";
	}

}
