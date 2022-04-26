package com.project.professorallocation.repository;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Department;
import com.project.professorallocation.repository.DepartmentRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTests {
	@Autowired
	DepartmentRepository repository;

	@Test
	public void findAll() {
		List<Department> items = repository.findAll();

		System.out.println("Quantidade de departamentos registrados: " + items.size());

		for (Department item : items) {
			System.out.println(item);

		}
	}

	@Test
	public void findSpecificDepartment() {
		Department dept = repository.findById(1L).orElse(null);
	}

	@Test
	public void create() {
		Department departmentBeingCreated = new Department();
		departmentBeingCreated.setNome("Departamento de Física");

		departmentBeingCreated = repository.save(departmentBeingCreated);

	}

	@Test
	public void update() {
		Department departmentBeingCreated = new Department();
		departmentBeingCreated.setId(3L);
		departmentBeingCreated.setNome("Departamento de Sociologia");

		departmentBeingCreated = repository.save(departmentBeingCreated);

	}

	@Test
	public void delete() {
		repository.deleteById(3L);
	}

	@Test
	public void deleteAll() {
		repository.deleteAllInBatch();
	}

}
