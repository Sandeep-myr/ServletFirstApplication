package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.entity.StudentEntity;
import com.spring.repository.StudentRepo;

@Controller
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;


	
	public String saveStudent() {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setEmail("san@gmail.com");
		studentEntity.setMobileNumber(1234567890l);
		studentEntity.setStudentAddress("sdsdfghj");
		studentEntity.setStudentName("sandeep");
		studentRepo.save(studentEntity);
		return "Student Data Saved Successfully";
	}
	
	
	public void displayStudentData() {
		List<StudentEntity> studentList = studentRepo.findAll();
		studentList.stream().forEach(p->{
			System.out.println(p);
		});
		
	}

}
