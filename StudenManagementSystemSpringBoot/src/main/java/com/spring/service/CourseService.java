package com.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.entity.Course;
import com.spring.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository cRepository;
	

	public List<Course> displayCourse() {
		return cRepository.findAll();
	}

	public void addCourse(Course course) {
		cRepository.save(course);
	}

	public Course getCourseById(int id) {
		return cRepository.findById(id).get();
	}

	public void deleteCourse(int id) {
		cRepository.deleteById(id);
	}

	public Course updateCourse(int id, Course course) {
		course.setCourseid(id);
		return cRepository.save(course);
	}

    public Course searchCourseDetailById(int id) {
		return cRepository.findById(id).get();
	}
    
	public Course searchByCourseName(String coursename) {
		return this.cRepository.findBycoursename(coursename);
	}
}
