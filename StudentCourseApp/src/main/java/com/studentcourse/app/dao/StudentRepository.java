package com.studentcourse.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentcourse.app.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	@Query(value="select * from student where studentAddress like ?1", nativeQuery= true)
    List<Student> getStudentByAddress(String studentAddress);
}
