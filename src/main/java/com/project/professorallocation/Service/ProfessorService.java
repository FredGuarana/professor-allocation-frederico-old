package com.project.professorallocation.Service;

import org.springframework.stereotype.Service;

import com.project.professorallocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository repository;

	public ProfessorService(ProfessorRepository professor) {
		super();
		this.repository = repository;
	}
	
	
	
}
