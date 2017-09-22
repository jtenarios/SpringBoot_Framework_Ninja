package com.udemy.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mysql.fabric.xmlrpc.base.Array;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

@Component("CourseConverter")
public class CourseConverter {
	
	// Transformar de una Entity --> Model (relacion 1 a 1)
	public CourseModel entity2model(Course course) {
		CourseModel courseModel = new CourseModel();
		
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getHours());
		courseModel.setHours(course.getHours());
		
		return courseModel;
	}
	
	// Transformar de un Model --> Entity
	public Course model2entity(CourseModel courseModel) {
		Course course = new Course();
		
		course.setName(courseModel.getName());
		course.setDescription(courseModel.getDescription());
		course.setPrice(courseModel.getHours());
		course.setHours(courseModel.getHours());
		
		return course;
		
	}
	
	// Transformar de una n Entities --> n Models (relacion n a n )
	public List<CourseModel> listEntity2listModel (List<Course> listCourse){
		
		List<CourseModel> miListaModel = new ArrayList<CourseModel>();		
		CourseConverter miCourseConverter = new CourseConverter();
		
		CourseModel miModel = new CourseModel();
		Course	miEntity = new Course();
		
		for (int i = 0; i < listCourse.size(); i++) {			
			
			miEntity = listCourse.get(i); 
			miModel = miCourseConverter.entity2model(miEntity);
			
			miListaModel.add(miModel);
		}
		
		return miListaModel;
			
	}
	
	

}
