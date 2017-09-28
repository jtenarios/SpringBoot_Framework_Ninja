package com.udemy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable>
//public interface CourseJpaRepository extends JpaRepository<CourseModel, Serializable>
{
		
	/*
	// Métodos personalizados
	public abstract Course findByPrice(int price); // Hace una query automática y busca por precio
	
	public abstract Course finByPriceAndName(int price, String name); // Hace una query automática y busca por precio y nombre
	
	public abstract List<Course> findByNameOrderByHours(String name); // Hace una query automática y busca por nombre y ordena por horas
	
	public abstract Course findByNameOrPrice(String name, int price);
	*/
	

}
