package com.studentrecordapp.sms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name =  "students")
public class Student {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentKey;
	
	@Column(name = "student_name", nullable = false)
	private String studentName;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	@Column(name = "grade")
	private int grade;
	
	@Column(name = "remarks")
	private String remarks;
	
	public Student() {
		
	}
	public Student(Long studentKey, String studentName, String subjectName, int grade, String remarks) {
		super();
		this.studentKey = studentKey;
		this.studentName = studentName;
		this.subjectName = subjectName;
		this.grade = grade;
		this.remarks = remarks;
	}


	public Long getStudentKey() {
		return studentKey;
	}

	public void setStudentKey(Long studentKey) {
		this.studentKey = studentKey;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getRemarks() {
		return grade>=75?"Pass" : "Fail";
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/*
	 * public void setRemarks(String remarks) { this.remarks = remarks; }
	 */
	
	
}
