package com.project.professorallocation.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Course;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseServiceTests {

	@Test
	public void create() {
		Course course = new Course();
		course.setName("Administração");
		
	}
}
