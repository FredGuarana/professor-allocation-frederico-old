package com.project.professorallocation;

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
public class DepartmentRepositoryTest {

	
		// TODO Auto-generated constructor stub
		
		@Autowired
		DepartmentRepository repository;
		
		@Test
		public void findAll() {
			List<Department> items = repository.findAll();
			
			System.out.println("Qtd elements retorn " + items.size());
			
			for(Department item : items) {
				System.out.println(item);
			
			}
			
		
			
		}
		
	
		
		@Test
		public void create() {
			
			Department departmentBeingCreated = new Department();
			departmentBeingCreated.setNome("Sociologia");
			
			departmentBeingCreated = repository.save(departmentBeingCreated);
			System.out.println(departmentBeingCreated);
			
		}

}
