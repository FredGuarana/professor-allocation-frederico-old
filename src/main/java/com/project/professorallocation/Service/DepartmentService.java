package com.project.professorallocation.Service;

import org.springframework.stereotype.Service;

import com.project.professorallocation.repository.CourseRepository;

@Service
public class DepartmentService {
	private CourseRepository repository;

	public DepartmentService(CourseRepository repository) {
		super();
		this.repository = repository;
	}

	

}
