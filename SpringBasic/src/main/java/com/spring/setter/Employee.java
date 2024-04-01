package com.spring.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private String empName;
	
	private int employeeId;

	private Address address;

	public Employee() {
		super();
	}
	
	public Employee(String empName, int employeeId, Address address) {
		super();
		this.empName = empName;
		this.employeeId = employeeId;
		this.address = address;
	}

	
	public String getEmpName() {
		return empName;
	}

	@Value("Ram")
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	@Value("10")
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Address getAddress() {
		return address;
	}

	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", employeeId=" + employeeId + ", Address=" + address + "]";
	}
}
