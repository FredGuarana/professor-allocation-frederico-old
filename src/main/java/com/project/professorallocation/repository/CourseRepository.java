package com.project.professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professorallocation.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
