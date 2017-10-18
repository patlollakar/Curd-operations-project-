package com.studentcourse.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentcourse.app.model.Student;
import com.studentcourse.app.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public Student createStudent(@Valid @RequestBody Student student) throws Exception {
		return studentService.createStudent(student);
	}
	
	@PutMapping
	public Student updateStudent(@Valid @RequestBody Student student) throws Exception {
			return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("studentId") Long studentId ) throws Exception {
		studentService.deleteStudent(studentId);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<Student> getAllStudents() throws Exception {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{studentId}")
	public Student getStudentById(@PathVariable("studentId") Long studentId) throws Exception {
				return studentService.getStudentById(studentId);
	}
	
	@GetMapping("studentDetails/{count}")
	public ResponseEntity<List<Student>> getStudentsWithMoreThanTwoCourses(@PathVariable("count") Long count) throws Exception {
		List<Student> studentDetails = new ArrayList<>();
		List<Student> students = studentService.getAllStudents();
		for (Student s : students) {
			if (s.getCourses().size() >= count) {
				studentDetails.add(s);
			}
		}
		
		return new ResponseEntity<List<Student>>(studentDetails, HttpStatus.OK);
	}
	
	@GetMapping("/studentAddress/{studentAddress}")
	public ResponseEntity<List<Student>> getStudentByAddress(@PathVariable("studentAddress") String studentAddress) throws Exception {
		List<Student> studentList = studentService.getStudentByAddress(studentAddress);
				return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
}
