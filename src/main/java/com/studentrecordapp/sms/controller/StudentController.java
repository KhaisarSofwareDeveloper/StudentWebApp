package com.studentrecordapp.sms.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentrecordapp.sms.entity.Student;
import com.studentrecordapp.sms.service.StudentService;
import com.studentrecordapp.sms.service.Impl.StudentServiceImpl;


@Controller
public class StudentController {
	
	private StudentServiceImpl studentService;

	
	
	public StudentController(StudentServiceImpl studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String listStudents(Model model, @Param("keyword") String keyword) {
		List<Student> studentName = studentService.getAllStudents(keyword);
		model.addAttribute("students", studentName);
		model.addAttribute("keyword", keyword);
		return "students";
	}
	
	
	/*
	 * @GetMapping("/students") public String listStudents(Model model) {
	 * model.addAttribute("students", studentService.getAllStudents()); return
	 * "students"; }
	 */
	@GetMapping("/students/studentName")
	public String findStudent(@RequestParam("studentName") String studentName, Model model) {
		Student student = studentService.findStudentByName(studentName);
		System.out.println("StudentName"+student);
		model.addAttribute("students", student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/new/{studentName}")
	public String findStudentByName(@PathVariable String studentName, Model model) {
		Student student = studentService.findStudentByName(studentName);
		System.out.println("StudentName"+student);
		model.addAttribute("students", student);
		return "studentsByName";
	}
	

	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student =  new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{studentKey}")
	public String editStudentForm(@PathVariable Long studentKey, Model model) {
		model.addAttribute("student", studentService.getStudentById(studentKey));
		return "edit_student";
	}
	
	@PostMapping("/students/{studentKey}")
	public String updateStudent(@PathVariable Long studentKey,
			@ModelAttribute("student") Student student,
			Model model) {
		
		Student existingStudent =  studentService.getStudentById(studentKey);
		existingStudent.setStudentKey(studentKey);
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setSubjectName(student.getSubjectName());
		existingStudent.setGrade(student.getGrade());
		//existingStudent.setRemarks(student.getRemarks());
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{studentKey}")
	public String deleteStudent(@PathVariable Long studentKey) {
		studentService.deleteStudentById(studentKey);
		return "redirect:/students";
		
		
		
	}

}
