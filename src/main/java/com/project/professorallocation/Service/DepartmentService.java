package com.project.professorallocation.Service;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Department;
import com.project.professorallocation.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private final DepartmentRepository repository;

	public DepartmentService(DepartmentRepository repository) {
		super();
		this.repository = repository;
	}

	public Department create(Department department) {
		department.setId(null);
		return saveInternal(department);
				
		}

	private Department saveInternal(Department department) {
		// TODO Auto-generated method stub
		department.setId(null);
		return null;
	}
	

}
