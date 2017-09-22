package com.udemy.controller;

import javax.swing.text.View;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.component.RequestTimeInterceptor;
import com.udemy.service.CheckPoint1Service;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/ejercicio")
public class CheckPoint1Controller {
		
	private static final String EXAMPLE_VIEW = "checkPoint1";
	
	@Autowired
	@Qualifier("checkPoint1Service") // mismo Bean que el de CheckPoint1Impl
	private CheckPoint1Service checkPont1Service;	
	
	@GetMapping("/path1")
	public String redirect() {
		return "redirect:/ejercicio/path2";
	}
	
	@GetMapping("/path2")
	public ModelAndView showExercice () {
		
		// Pinto un log del sistema
		checkPont1Service.showLog();
		
		// Envio una variable mensaje al HTML y devuelvo la vista modifcada
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("mensaje", "Hola mundo desde checkPoint1Coller");			
		
		return mav;
	}
	
	

}
