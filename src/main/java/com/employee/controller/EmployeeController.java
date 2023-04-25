package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.request.EmployeeRequest;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;

	@PostMapping("/createEmp")
	public ResponseEntity<?> createEmp(@RequestBody EmployeeRequest request){
		return empService.createEmp(request);
	}
	
	@GetMapping("/getAllEmp/{companyId}")
	public ResponseEntity<?> getAllEmp(@PathVariable("companyId") String companyId){
		return empService.getAllByComanyId(companyId);
	}
	
	@GetMapping("/getEmp/{empId}/{companyId}")
	public ResponseEntity<?> getEmpById(@PathVariable("empId") Integer empId, @PathVariable("companyId") String companyId){
		return empService.getByEmpIdAndCompanyId(empId, companyId);
	}
	
	@DeleteMapping("/deleteEmp/{empId}/{companyId}")
	public ResponseEntity<?> deleteEmpById(@PathVariable("empId") Integer empId, @PathVariable("companyId") String companyId){
		return empService.deleteEmpById(empId ,companyId);
	}
	
	@PutMapping("/updateEmp/{empId}")
	public ResponseEntity<?> updateEmpById(@PathVariable("empId") Integer empId, @RequestBody EmployeeRequest employeeRequest){
		return empService.updateEmpById(empId, employeeRequest);
	}
	
}
