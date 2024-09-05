package com.studentrecordapp.sms.service;

import java.util.List;

import com.studentrecordapp.sms.entity.Student;



public interface StudentService {

	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long studentKey);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long studentKey);
	

	Student findStudentByName(String studentName);
	


	Student getAllStudentsNames(String studentName);

	List<Student> getAllStudents(String keyword);

}
