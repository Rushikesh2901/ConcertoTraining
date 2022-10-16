package com.loan.root.repository;

import org.springframework.data.repository.CrudRepository;

import com.loan.root.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
