package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	
	private static final String EXAMPLE4_VIEW = "404";
	
	// redirecciona a otra ruta
	@GetMapping("/")
	public String redirect() {
		return "redirect:/example4/error404";
	}
	
	// abre la plantilla 404.html
	@GetMapping("error404")
	public String error404(Model model) {
		return EXAMPLE4_VIEW;
	}	
	

}
