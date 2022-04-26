package com.project.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Allocation;
import com.project.professorallocation.model.Professor;
import com.project.professorallocation.repository.AllocationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {

	@Autowired
	AllocationRepository allocationRepository;

	@Test
	public void findAll() {

		List<Allocation> items = allocationRepository.findAll();
		System.out.println("Quantidade de alocações registrados: " + items.size());

		for (Allocation item : items) {
			System.out.println(item);
		}

	}

}
