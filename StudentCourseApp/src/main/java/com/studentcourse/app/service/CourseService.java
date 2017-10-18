package com.studentcourse.app.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentcourse.app.dao.CourseRepository;
import com.studentcourse.app.model.Course;

@Service
public class CourseService {

		
	@Autowired
	private CourseRepository courseRepository;

	public Course createCourse(Course course) throws Exception {
			return courseRepository.save(course);
	}

	public Course updateCourse(Course course) throws Exception {
				return courseRepository.save(course);
	}

	public void deleteCourse(String courseId) throws Exception {
		courseRepository.delete(courseId);
	}

	public List<Course> getAllCourses() throws Exception {
				return courseRepository.findAll();
	}

	public Course getCourseById(String courseId) throws Exception {
			return courseRepository.findOne(courseId);
	}
}
