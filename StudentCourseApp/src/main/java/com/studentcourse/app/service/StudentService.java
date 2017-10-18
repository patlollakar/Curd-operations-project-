package com.studentcourse.app.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentcourse.app.dao.StudentRepository;
import com.studentcourse.app.model.Student;

@Service
public class StudentService {

	
	@Autowired
	public StudentRepository studentRepository;

	public Student createStudent(Student student) throws Exception {
			return studentRepository.save(student);
	}

	public Student updateStudent(Student student) throws Exception {
			return studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) throws Exception {
			studentRepository.delete(studentId);
	}

	public List<Student> getAllStudents() throws Exception {
				return studentRepository.findAll();
	}

	public Student getStudentById(Long studentId) throws Exception {
				return studentRepository.findOne(studentId);
	}

	public List<Student> getStudentByAddress(String studentAddress) throws Exception {
				return studentRepository.getStudentByAddress("%," + studentAddress);
	}
}
