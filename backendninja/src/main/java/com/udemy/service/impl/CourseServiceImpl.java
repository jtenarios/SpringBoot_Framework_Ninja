package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository; // Instancia de la interface

//	@Override
//	public List<Course> listAllCourse() {		
//		LOG.info("Call: " + "listAllCourse()");
//		return courseJpaRepository.findAll();
//	}
	
	
	
	// Modifico para que reciva una lista de @Model y devuelve una lista de @Model también.
	@Override
	public List<CourseModel> listAllCourse() {		
		LOG.info("Call: " + "listAllCourse()");
								
		CourseConverter ListCourseConverter = new CourseConverter();		
		
		// Transformar de una n Entities --> n Models (relacion n a n )						
		return ListCourseConverter.listEntity2listModel(courseJpaRepository.findAll());
		
	}

	// Guarda un nuevo curso o lo sobreescribe si ya existe, trabajando con una @Entity
//	@Override
//	public Course addCourse(Course course) {
//		LOG.info("Call: " + "addCourse()");
//		return courseJpaRepository.save(course);
//	}
	
	// Guarda un nuevo curso o lo sobreescribe si ya existe, trabajando con un @Model
	@Override
	public Course addCourse(CourseModel courseModel) {
		LOG.info("Call: " + "addCourse()");
		
		// recibo un model y devuelvo una entity
		CourseConverter courseConverter = new CourseConverter();
		
		return courseJpaRepository.save(courseConverter.model2entity(courseModel));
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course); // Mete el curso que recibe, si el Id está relleno y existe lo sobreescribe, sino lo crea.
	}

}
