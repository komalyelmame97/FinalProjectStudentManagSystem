package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.entity.Student;
import com.spring.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository studRepo;
//	@Autowired
//	private CourseRepository cRepo;

	public List<Student> getStudent() {
		return studRepo.findAll();
	}

	public Student addStudent(Student student) {
		return studRepo.save(student);
	}

	public void deleteStudentById(int id) {
		studRepo.deleteById(id);
	}

	public Student SearchStudentById(int id) {
		return studRepo.findById(id).get();
	}

	public Student updateStudent(int id, Student student) {
		student.setStud_id(id);
		return studRepo.save(student);
	}

	public Student searchByName(String studname) {
		return this.studRepo.findBystudname(studname);
	}

}
