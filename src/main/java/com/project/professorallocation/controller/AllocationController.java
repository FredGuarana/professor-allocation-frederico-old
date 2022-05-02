package com.project.professorallocation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.professorallocation.service.AllocationService;

@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {

	private final AllocationService service;

	public AllocationController(AllocationService service) {
		super();
		this.service = service;
	}
	
	
}
