package com.project.professorallocation.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Course;
import com.project.professorallocation.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository repository;

	public CourseService(CourseRepository repository) {
		super();
		this.repository = repository;
	}

	public Course create(Course course) {
		course.setId(null);
		return saveInternal(course);

	}

	private Course saveInternal(Course course) {
		Course insertedCourse = repository.save(course);
		return insertedCourse;
	}

	public Course update(Course course) {
		Long id = course.getId();
		if (id == null || !repository.existsById(id)) {
			return null;
		} else {
			return saveInternal(course);
		}

	}

	private void deleteById(Long id) {
		if (repository.existsById(id)) {
		repository.deleteById(id);
		}
		
		
	}
	
	public Course indById(Long id) {
		return repository.findById(id).orElse(null);
		
	}
	
	public List<Course> findAll() {
		return repository.findAll();
	}
}
