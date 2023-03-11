package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HelloWorldController {

	// controller method to show HTML Form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// controller method to process HTML form

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// a new controller method to read form data and data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request parameter from HTML form
		String theName = request.getParameter("studentName");

		// convert the data to uppercase
		theName = theName.toUpperCase();

		// create the message
		String result = "YO!! " + theName;

		// add message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model) {

		// convert the data to uppercase
		theName = theName.toUpperCase();

		// create the message
		String result = "Hey my friend from v3!! " + theName;

		// add message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}

}
