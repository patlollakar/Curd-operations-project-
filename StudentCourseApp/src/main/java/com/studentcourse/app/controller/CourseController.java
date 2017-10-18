package com.studentcourse.app.controller;


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

import com.studentcourse.app.model.Course;
import com.studentcourse.app.model.Student;
import com.studentcourse.app.service.CourseService;


@RestController
@RequestMapping("courses")
public class CourseController {


	@Autowired
	private CourseService courseService;

	@PostMapping
	public Course createCourse(@Valid @RequestBody Course course) throws Exception {
	
		return courseService.createCourse(course);
	}

	@PutMapping
	public Course updateCourse(@Valid @RequestBody Course course) throws Exception {
			return courseService.updateCourse(course);
	}

	@DeleteMapping("/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("courseId") String courseId) throws Exception {
		courseService.deleteCourse(courseId);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping
	public List<Course> getAllCourses() throws Exception {
		
		return courseService.getAllCourses();
	}

	@GetMapping("/{courseId}")
	public Course getCourseById(@PathVariable("courseId") String courseId) throws Exception {
				return courseService.getCourseById(courseId);
	}

	@GetMapping("studentDetails/{courseId}")
	public ResponseEntity<List<Student>> getStudentsByCourseId(@PathVariable("courseId") String courseId) throws Exception{
		List<Student> students = courseService.getCourseById(courseId).getStudents();
		int count=students.size();
			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	
}