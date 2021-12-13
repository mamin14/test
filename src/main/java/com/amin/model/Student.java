package com.amin.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	
	private String name;


	
	@ManyToMany(cascade={CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Set<Subject> subject = new HashSet<>();




	private int subCount;
	public Student() {}
	public Student(String name) {
		this.name = name;
	}


	public int getSubCount() {
		return this.subject.size();
	}
	public void setSubCount(int subCount) {
		this.subCount = subCount;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Subject> getSubject() {
		return subject;
	}
	public void setSubject(Set<Subject> subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [name=" + name +  ", subject=" + subject + "]";
	}
	
	
	
}



