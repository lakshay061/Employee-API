package com.employee.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.employee.entities.Employee;

public class EmployeeResponse {

	private Integer empId;

	private String empName;

	private String empCompanyId;

	private String empPassword;

	private String empDesignation;

	private String empContact;

	private Character empGender;

	private String empAddress;

	private LocalDate empDob;

	// getters setters
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
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

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public String getEmpCompanyId() {
		return empCompanyId;
	}

	public void setEmpCompanyId(String empCompanyId) {
		this.empCompanyId = empCompanyId;
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

	public EmployeeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static EmployeeResponse convertResp(Employee employee) {
		EmployeeResponse resp = new EmployeeResponse();

		resp.setEmpId(employee.getEmpId());
		resp.setEmpName(employee.getEmpName());
		resp.setEmpCompanyId(employee.getEmpCompanyId());
		resp.setEmpPassword(employee.getEmpPassword());
		resp.setEmpDesignation(employee.getEmpDesignation());
		resp.setEmpContact(employee.getEmpContact());
		resp.setEmpGender(employee.getEmpGender());
		resp.setEmpAddress(employee.getEmpAddress());
		resp.setEmpDob(employee.getEmpDob());

		return resp;
	}

	public static List<EmployeeResponse> convertRespList(List<Employee> empList) {

		List<EmployeeResponse> respList = new ArrayList<>();

		for (Employee employee : empList) {
			
			EmployeeResponse resp = new EmployeeResponse();

			resp.setEmpId(employee.getEmpId());
			resp.setEmpName(employee.getEmpName());
			resp.setEmpCompanyId(employee.getEmpCompanyId());
			resp.setEmpPassword(employee.getEmpPassword());
			resp.setEmpDesignation(employee.getEmpDesignation());
			resp.setEmpContact(employee.getEmpContact());
			resp.setEmpGender(employee.getEmpGender());
			resp.setEmpAddress(employee.getEmpAddress());
			resp.setEmpDob(employee.getEmpDob());
			
			respList.add(resp);
		}
		return respList;
	}

}
