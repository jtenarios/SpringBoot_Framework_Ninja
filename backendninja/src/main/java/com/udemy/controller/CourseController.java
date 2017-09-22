package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final String COURSE_VIEW  = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	// Los controller no deben usar nunca entities sino los modelos
	
	// Listar los cursos usando una @Entity
//	@GetMapping("/listcourses")
//	public ModelAndView listAllCourses(){
//		LOG.info("Call: " + "listAllCourses()");
//		ModelAndView mav = new ModelAndView(COURSE_VIEW);
//		mav.addObject("course", new Course());
//		mav.addObject("courses", courseService.listAllCourse());		
//		return mav;
//	}
	
	// Listar los cursos usando un @Model
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses(){
		LOG.info("Call: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSE_VIEW);
		mav.addObject("course", new CourseModel());
		mav.addObject("courses", courseService.listAllCourse());		
		return mav;
	}
	
	// Inserta un nuevo curso y te redirecciona a la lista de cursos actualizada
	// Ejemplo en el que recibe una @Entity
//	@PostMapping("/addcourse")
//	public String addCourse(@ModelAttribute("course") Course course) {
//		LOG.info("Call: " + "addCourse()" + " --- PARAM: " + course.toString());
//		courseService.addCourse(course);
//		return "redirect:/courses/listcourses";
//	}	
	
	// Inserta un nuevo curso y te redirecciona a la lista de cursos actualizada
	// Ejmplo en el que recibe un @Model
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel) {
		LOG.info("Call: " + "addCourse()" + " --- PARAM: " + courseModel.toString());			
		courseService.addCourse(courseModel);
		return "redirect:/courses/listcourses";
	}

}
