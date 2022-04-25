package service;

//package com.project.professor.allocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.Service.AllocationService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationServiceTest {

    @Autowired
    AllocationService allocationService;




	public AllocationServiceTests() {
	
	}

}
