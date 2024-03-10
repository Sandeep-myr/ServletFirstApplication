package com.spring.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.controller.StudentController;

@Component
public class MyRunner implements CommandLineRunner{

	@Autowired
	private StudentController controller;
	@Override
	public void run(String... args) throws Exception {
		
		controller.displayStudentData();
	}

}
