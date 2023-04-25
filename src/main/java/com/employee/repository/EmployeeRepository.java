package com.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByEmpCompanyId(String companyId);
	
	Optional<Employee> findByEmpIdAndEmpCompanyId(Integer empId, String companyId);
}
