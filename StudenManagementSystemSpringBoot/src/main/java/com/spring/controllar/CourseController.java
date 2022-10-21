package com.spring.controllar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Course;
import com.spring.entity.Student;
import com.spring.service.CourseService;
import com.spring.service.StudentService;

@RestController
public class CourseController {
	@Autowired
	private CourseService cService;
	@Autowired
	private StudentService studentService;
	@GetMapping("/getcourse")
	public List<Course> getCourseData() {
		return cService.displayCourse();
	}
	
	@PostMapping("/addcourse/{studentid}")
	public String addCourseData(@RequestBody Course course, @PathVariable int studentid) {
		Student student = this.studentService.SearchStudentById(studentid);
		course.setStudent(student);
		cService.addCourse(course);
		return "Course Added succesfully";
	}

//	@PostMapping("/addcourse")
//	public String addStudentData(@RequestBody Course course) {
//		cService.addCourse(course);
//		return "Course Added succesfully";
//	}

	@DeleteMapping("/deletecourse/{id}")
	public String deleteCourseRecord(@PathVariable int id) {
		this.cService.deleteCourse(id);
		return "Delete record Successfully";
	}

	@PutMapping("/course/{id}")
	public String updateStudentById(@PathVariable int id, @RequestBody Course course) {
		cService.updateCourse(id, course);
		return "Student Record updated";
	}

	@GetMapping("/searchbycourseid")
	public Course getById(@RequestParam("cid") int id)//// searchbyid?eid=2
	{
		return this.cService.searchCourseDetailById(id);
	}
	@GetMapping("/searchbycoursename/{coursename}")
	public Course searchName(@PathVariable String coursename) {
		return this.cService.searchByCourseName(coursename);

	}

}
