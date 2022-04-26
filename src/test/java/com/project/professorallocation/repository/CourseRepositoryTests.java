package com.project.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Course;
import com.project.professorallocation.repository.CourseRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTests {

	@Autowired
	CourseRepository repository;

	@Test
	public void findAll() {
		List<Course> items = repository.findAll();

		System.out.println("Quantidade de cursos registrados: " + items.size());

		for (Course item : items) {
			System.out.println(item);
		}
	}

	@Test
	public void create() {
		Course courseBeingCreated = new Course();
		courseBeingCreated.setName("Backend");

		courseBeingCreated = repository.save(courseBeingCreated);

	}

	@Test
	public void update() {
		Course courseBeingCreated = new Course();
		courseBeingCreated.setId(2L);
		courseBeingCreated.setName("Backend");

		courseBeingCreated = repository.save(courseBeingCreated);

	}

}
