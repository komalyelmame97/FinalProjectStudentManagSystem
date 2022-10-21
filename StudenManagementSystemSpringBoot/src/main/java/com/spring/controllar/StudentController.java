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
import com.spring.entity.Student;
import com.spring.service.CourseService;
import com.spring.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;

	@GetMapping("/getstudent")
	public List<Student> getStudentData() {
		return this.studentService.getStudent();
	}

//	@PostMapping("/addstudent/{courseid}")
//	public String addStudentData(@RequestBody Student student, @PathVariable int courseid) {
//		Course c = this.courseService.getCourseById(courseid);
//		student.getCourse();
//		studentService.addStudent(student);
//		return "Student Added succesfully";
//	}
	@PostMapping("/getstudent")
	public String addStudentData(@RequestBody Student student) {
		studentService.addStudent(student);
		return "Student Added succesfully";
	}

	@DeleteMapping("/deletestudent/{id}")
	public String deleteStudentByRecord(@PathVariable int id) {
		this.studentService.deleteStudentById(id);
		return "Delete record Successfully";
	}

	@PutMapping("/updatestudent/{id}")
	public String updateStudentById(@PathVariable int id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
		return "Student Record updated";
	}

	@GetMapping("/searchbystuid")
	public Student getById(@RequestParam("eid") int id)// searchbyid?eid=2
	{
		return this.studentService.SearchStudentById(id);
	}

	@GetMapping("/searchbyname/{studname}")
	public Student searchName(@PathVariable String studname) {
		return this.studentService.searchByName(studname);

	}

}
