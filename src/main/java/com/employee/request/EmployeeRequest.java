package com.employee.request;

import java.time.LocalDate;

import com.employee.entities.Employee;

public class EmployeeRequest {

	private Integer createById;

	private String empName;

	private String empPassword;
	
	private String empCompanyId;

	private String empDesignation;
	
	private String empContact;
	
	private Character empGender;
	
	private String empAddress;

	private LocalDate empDob;

	

	public Integer getCreateById() {
		return createById;
	}

	public void setCreateById(Integer createById) {
		this.createById = createById;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPassword() {
		return empPassword;
	}
	
	

	public String getEmpCompanyId() {
		return empCompanyId;
	}

	public void setEmpCompanyId(String empCompanyId) {
		this.empCompanyId = empCompanyId;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpContact() {
		return empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public Character getEmpGender() {
		return empGender;
	}

	public void setEmpGender(Character empGender) {
		this.empGender = empGender;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public LocalDate getEmpDob() {
		return empDob;
	}

	public void setEmpDob(LocalDate empDob) {
		this.empDob = empDob;
	}

	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee convertToEmployee() {
		Employee employee = new Employee();
		
//		employee.setEmpId(this.empId);
		employee.setEmpName(this.empName);
		employee.setEmpPassword(this.empPassword);
		employee.setEmpCompanyId(this.empCompanyId);
		employee.setEmpDesignation(this.empDesignation);
		employee.setEmpContact(this.empContact);
		employee.setEmpAddress(this.empAddress);
		employee.setEmpGender(this.empGender);
		employee.setEmpDob(this.empDob);
		
		return employee;
	}
	
}
