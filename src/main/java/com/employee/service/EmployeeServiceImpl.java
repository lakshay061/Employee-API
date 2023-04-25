package com.employee.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.entities.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.request.EmployeeRequest;
import com.employee.response.BaseResponse;
import com.employee.response.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public ResponseEntity<?> getAllByComanyId(String companyId) {
		
		BaseResponse<EmployeeResponse> bResp = new BaseResponse<>();
		List<Employee> empList = employeeRepository.findByEmpCompanyId(companyId);
		
		if(!empList.isEmpty()) {
			List<EmployeeResponse> respList = EmployeeResponse.convertRespList(empList);
			bResp.setStatus(200);
			bResp.setMessage("List successfully Fetched");
			bResp.setDataList(respList);
		}
		else {
			bResp.setStatus(200);
			bResp.setMessage("Nothing to fetched !!");
		}
		
		return new ResponseEntity<>(bResp, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> deleteEmpById(Integer empId, String companyId) {
		
		BaseResponse<EmployeeResponse> baseResponse = new BaseResponse<>();
		Employee employee = employeeRepository.findByEmpIdAndEmpCompanyId(empId, companyId).orElse(null);
		
		if(employee!=null) {
			employeeRepository.deleteById(empId);
			baseResponse.setStatus(200);
			baseResponse.setMessage("Employee successfully deleted");
		}else {
			baseResponse.setStatus(200);
			baseResponse.setMessage("No Employee found to delete");
		}
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> updateEmpById(Integer empId, EmployeeRequest employeeRequest) {
		
		BaseResponse<EmployeeResponse> baseResponse = new BaseResponse<>();
		Employee employee = employeeRepository.findById(empId).orElse(null);
		
		if(employee != null && employeeRequest != null) {
//			employee.setEmpId(empId);
//			employee.setEmpName(employeeRequest.getEmpName());
//			employee.setEmpAddress(employeeRequest.getEmpAddress());
//			employee.setEmpCompanyId(employeeRequest.getEmpCompanyId());
//			employee.setEmpContact(employeeRequest.getEmpContact());
//			employee.setEmpDesignation(employeeRequest.getEmpDesignation());
//			employee.setEmpGender(employeeRequest.getEmpGender());
//			employee.setEmpDob(employeeRequest.getEmpDob());
//			employee.setEmpPassword(employeeRequest.getEmpPassword());
			
			Employee emp = employeeRequest.convertToEmployee();
			emp.setEmpId(empId);
			
			
			employee = employeeRepository.save(emp);
			
			baseResponse.setStatus(200);
			baseResponse.setMessage("Employee details updated successfully");
			baseResponse.setData(EmployeeResponse.convertResp(employee));
		}
		else {
			baseResponse.setStatus(200);
			baseResponse.setMessage("Employee not found with this id !!");
		}
		return ResponseEntity.ok(baseResponse);
	}
	
	@Override
	public ResponseEntity<?> getByEmpIdAndCompanyId(Integer empId, String companyId) {
		
		BaseResponse<EmployeeResponse> baseResponse = new BaseResponse<>();
		Employee employee = employeeRepository.findByEmpIdAndEmpCompanyId(empId, companyId).orElse(null);
		
		if(employee != null) {
			EmployeeResponse employeeResponse = EmployeeResponse.convertResp(employee);
			baseResponse.setStatus(200);
			baseResponse.setMessage("Data Successfully Fetched");
			baseResponse.setData(employeeResponse);
		}
		else {
			baseResponse.setStatus(200);
			baseResponse.setMessage("No Data Found !!");
		}
		return ResponseEntity.ok(baseResponse);
	}
	
	
	
	
	@Override
	public ResponseEntity<?> createEmp(EmployeeRequest request) {

		Employee employee = request.convertToEmployee();
		
		Employee emp = employeeRepository.findById(request.getCreateById()).orElse(null);
		if(emp!=null) {
			employee.setCreatedBy(emp.getEmpName());
		}
		
		employee.setCreatedDate(LocalDateTime.now());
		
		employee = employeeRepository.save(employee);
		
		EmployeeResponse response = EmployeeResponse.convertResp(employee);
		
		BaseResponse<EmployeeResponse> bResp = new BaseResponse<>();
		bResp.setStatus(200);
		bResp.setMessage("Record Successfully Inserted");
		bResp.setData(response);
		return ResponseEntity.ok(bResp);
	}
	
}
