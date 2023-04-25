package com.employee.service;

import org.springframework.http.ResponseEntity;

import com.employee.request.EmployeeRequest;

//@Service
public interface EmployeeService {

	ResponseEntity<?> getAllByComanyId(String companyId);
	
	ResponseEntity<?> getByEmpIdAndCompanyId(Integer empId ,String companyId);
	
	ResponseEntity<?> createEmp(EmployeeRequest request);
	
	ResponseEntity<?> deleteEmpById(Integer empId ,String companyId);
	
	ResponseEntity<?> updateEmpById(Integer empId ,EmployeeRequest employeeRequest);
	
}
