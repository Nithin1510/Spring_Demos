package com.spring.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Student {
	
	private String name;
	
	private String department;
	
	private Course course;

	public Student(Course course) {
		super();
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", department=" + department + ", course=" + course + "]";
	}

	public String getName() {
		return name;
	}

	@Value("${student.name}")
	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	@Value("${student.department")
	public void setDepartment(String department) {
		this.department = department;
	}

	
}
