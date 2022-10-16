package com.loan.root.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.loan.root.model.Loan;

public interface LoanRepository extends CrudRepository<Loan, String> {
	
	@Query(value = "select * from loan where employee_Id=:empId",nativeQuery = true)
	public List<Loan> findByEmployeeEmployeeId(String empId);
	
	@Query(value = "select * from loan where loanId=:loanId",nativeQuery = true)
	public Optional<Loan> findByLoanId(String loanId);

}
