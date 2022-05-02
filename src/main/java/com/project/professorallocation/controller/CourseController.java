package com.project.professorallocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professorallocation.model.Course;
import com.project.professorallocation.service.CourseService;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {
	
	private final CourseService service;

	public CourseController(CourseService service) {
		super();
		this.service = service;
	}
	

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Course>> findAll() {
		List<Course> allCourse = service.findAll();

		return new ResponseEntity<>(allCourse, HttpStatus.OK);

	}
	
	@GetMapping(path = "/{course_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Course> findById(@PathVariable(name = "course_id") Long id) {
		Course item = service.findById(id);

		if (item == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(item, HttpStatus.OK);

		}

	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus()
	public ResponseEntity<Course> create(@RequestBody Course course) {
		Course item = service.create(course);
		
		return new ResponseEntity<>(item,HttpStatus.CREATED);
		
	}
	
	@PutMapping(path = "/{cour_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Course> update(@PathVariable(name = "cour_id") Long id, @RequestBody Course course) {
		course.setId(id);
	    try {
	    	course = service.update(course);
	        if (course == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	            return new ResponseEntity<>(course, HttpStatus.OK);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	@DeleteMapping(path = "/{cour_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "cour_id") Long id) {
	    service.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
	// curl -v --request POST --header "Content-Type: application/json" --header "Accept: application/json" --data-raw "{\"name\": \"Introducao a Programacao\"}" "http://localhost:8082/courses"
}
