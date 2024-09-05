package com.studentrecordapp.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentrecordapp.sms.entity.Student;
import java.util.List;



public interface StudentRepository  extends JpaRepository<Student, Long>{
	
	Student findByStudentName(String studentName);
	
	
	@Query("SELECT s FROM Student s WHERE s.studentName LIKE %?1%")
	public List<Student> findAll(String keyword);

	
	/*
	 * @Query("SELECT s FROM Student s WHERE LOWER(s.studentName) LIKE LOWER(CONCAT('%', ?1, '%'))"
	 * + " OR LOWER(s.remarks) LIKE LOWER(CONCAT('%', ?1, '%'))") public
	 * List<Student> findAll(String keyword);
	 */
}
