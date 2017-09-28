package com.udemy.service;

import java.util.List;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

public interface CourseService {
	
	//public abstract List<Course> listAllCourse(); // Lista cursos, usando una @Entity	
	public abstract List<CourseModel> listAllCourse(); // Lista cursos, usando un @Model
	
	//public abstract Course addCourse(Course course); //Añadir nuevo curso, trabajando con una @Entity
	public abstract Course addCourse(CourseModel courseModel); //Añadir nuevo curso, trabajando con un @Model	
	
	public abstract int removeCourse(int idCourse); // Elimina el curso según Id
	
	public abstract Course updateCourse(Course course);  // Modifica un curso y lo devuelve modificado
	 
	

}
