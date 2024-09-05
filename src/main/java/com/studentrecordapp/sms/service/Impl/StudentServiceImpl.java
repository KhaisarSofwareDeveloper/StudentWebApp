package com.studentrecordapp.sms.service.Impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.studentrecordapp.sms.entity.Student;
import com.studentrecordapp.sms.repository.StudentRepository;
import com.studentrecordapp.sms.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService {
	
	private StudentRepository studentRepository;

	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents(String keyword) {
		if(keyword != null) {
			return studentRepository.findAll(keyword);
		}
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}

	@Override
	public Student getStudentById(Long studentKey) {
		return studentRepository.findById(studentKey).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long studentKey) {
		studentRepository.deleteById(studentKey);
	}


	@Override
	public Student findStudentByName(String studentName) {
		return studentRepository.findByStudentName(studentName);
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}


	@Override
	public Student getAllStudentsNames(String studentName) {
		// TODO Auto-generated method stub
		return null;
	}


	
	





}
