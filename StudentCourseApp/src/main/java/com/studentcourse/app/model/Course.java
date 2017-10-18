package com.studentcourse.app.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

	@Id
	@NotBlank(message = "Course Id cannot be blank")
	private String courseId;
	@NotBlank(message = "Course name cannot be blank")
	private String courseName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, targetEntity = Student.class)
	@JoinTable(name = "Student_Course", joinColumns = {
			@JoinColumn(name = "courseId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "studentId", nullable = false) })
	@JsonIgnore
	private List<Student> students = new ArrayList<>();

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
