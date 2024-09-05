package com.studentrecordapp.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentrecordapp.sms.entity.Student;
import com.studentrecordapp.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRecordApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	

	

}
