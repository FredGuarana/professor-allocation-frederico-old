package com.project.professorallocation.model;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "allocation")
public class Allocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "day")
	private DayOfWeek dayOfWeek;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date startHour;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date endHour;
	private Long courseId;
	private Long professorId;

	public Allocation() {
		// TODO Auto-generated constructor stub
	}
	

}
