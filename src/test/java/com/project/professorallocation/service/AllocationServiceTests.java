package com.project.professorallocation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;

//package com.project.professor.allocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Allocation;
import com.project.professorallocation.service.AllocationService;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationServiceTests {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");
	
    @Autowired
    AllocationService service;
    
    @Test
	public void create() throws ParseException {
		Allocation allocation = new Allocation();
		allocation.setDayOfWeek(DayOfWeek.WEDNESDAY);
		allocation.setProfessorId(3L);
		allocation.setCourseId(1L);
		allocation.setStartHour(sdf.parse("18:00-0300"));
		allocation.setEndHour(sdf.parse("20:00-0300"));

		allocation = service.create(allocation);

		System.out.println(allocation);
	}

	@Test
	public void findAll() {

		List<Allocation> items = service.findAll();
		System.out.println("Quantidade de alocações registrados: " + items.size());

		for (Allocation item : items) {
			System.out.println(item);
		}

	}



}
