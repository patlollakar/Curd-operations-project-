package com.studentcourse.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentcourse.app.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

}
