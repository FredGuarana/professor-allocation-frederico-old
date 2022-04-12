package com.project.professorallocation.model;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne(optional = false)
	@JoinColumn(name = "courseId", nullable = false, insertable = false, updatable = false)
	private Course course;
	
	private Long professorId;
	@ManyToOne(optional = false)
	@JoinColumn(name = "professorId", nullable = false, insertable = false, updatable = false)
	private Professor professor;
	
	

	public Allocation() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Date getStartHour() {
		return startHour;
	}

	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}

	public Date getEndHour() {
		return endHour;
	}

	public void setEndHour(Date endHour) {
		this.endHour = endHour;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	

}
