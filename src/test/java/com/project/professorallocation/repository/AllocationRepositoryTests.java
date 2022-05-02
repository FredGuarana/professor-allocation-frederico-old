package com.project.professorallocation.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Allocation;
import com.project.professorallocation.service.AllocationService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTests {

	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	AllocationRepository repository;

	@Test
	public void create() throws ParseException {
		Allocation allocation = new Allocation();
		allocation.setDayOfWeek(DayOfWeek.MONDAY);
		allocation.setProfessorId(2L);
		allocation.setCourseId(2L);
		allocation.setStartHour(sdf.parse("20:00-0300"));
		allocation.setEndHour(sdf.parse("22:00-0300"));

		allocation = repository.save(allocation);

		System.out.println(allocation);
	}

	@Test
	public void findAll() {

		List<Allocation> items = repository.findAll();
		System.out.println("Quantidade de alocações registrados: " + items.size());

		for (Allocation item : items) {
			System.out.println(item);
		}

	}

}
