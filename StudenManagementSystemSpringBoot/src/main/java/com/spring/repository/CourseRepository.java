package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.spring.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Integer>{
	public Course findBycoursename(@Param("coursename") String name);
}
