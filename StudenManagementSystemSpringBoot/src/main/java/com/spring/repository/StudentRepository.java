package com.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Student findBystudname(@Param("studname") String name);
}
