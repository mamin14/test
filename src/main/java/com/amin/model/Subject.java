package com.amin.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {
	
	@Id @GeneratedValue
	private Long id;
	
	private String name;


	@ManyToMany(cascade={CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Set<Student> student = new HashSet<>();

	public Subject(){}

	public Subject(String name) {
		this.name = name;
	}
	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
