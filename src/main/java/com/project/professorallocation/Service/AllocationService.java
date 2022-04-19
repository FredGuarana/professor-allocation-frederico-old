package com.project.professorallocation.Service;

import org.springframework.stereotype.Service;

import com.project.professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {

	private final AllocationRepository repository;

	public AllocationService(AllocationRepository repository) {
		super();
		this.repository = repository;
	}

	

}
