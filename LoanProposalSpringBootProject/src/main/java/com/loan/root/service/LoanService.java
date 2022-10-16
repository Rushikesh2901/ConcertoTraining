package com.loan.root.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.loan.root.model.Collateral;
import com.loan.root.constant.LoanConstants;
import com.loan.root.model.Customer;
import com.loan.root.model.Employee;
import com.loan.root.model.Loan;
import com.loan.root.repository.CollateralRepository;
import com.loan.root.repository.CustomerRepository;
import com.loan.root.repository.EmployeeRepository;
import com.loan.root.repository.LoanRepository;


public class LoanService {
	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CollateralRepository collateralRepository;
	
	public Loan findLoanById(String loanid) { 
		Optional<Loan> loan = this.loanRepository.findById(loanid); 
		return loan.orElseThrow(() -> new EntityNotFoundException("Loan with specified id not found")); 
	}
	
	public Loan applyForLoan(String loanType, double loanAmount, double period, String email) { 
		Loan loan = new Loan();
		loan.setLoanId("test"+this.loanRepository.count()+1); 
		loan.setLoanType(loanType); 
		loan.setLoanAmount(loanAmount); 
		loan.setInterestRate(LoanConstants.calculateRate(period));
		loan.setPeriod(period);
		loan.setRemarks("Approved");
		
		loan.setCustomer(this.customerRepository.findById(email).get());
		
		List<Employee> employees = new ArrayList<>();
		int i = (int)(Math.random()* (employeeRepository.count()));
		this.employeeRepository.findAll().forEach(employee -> employees.add(employee));
		loan.setEmployee(employees.get(i)); 
		
		this.loanRepository.save(loan);
		return loan;
			
	}
	
	
	public boolean uploadCollateral(String loanId, List<String> collateralIds) 
	{
		Optional<Loan> loan = this.loanRepository.findById(loanId);
		
		if(loan.isPresent()) {
			loan.ifPresent(c->{
				List<Collateral> collaterals = new ArrayList<Collateral>();
				collateralIds.forEach(id->{
					collaterals.add(this.collateralRepository.findById(id).get());
				});
				System.out.println(collaterals);
				c.setCollaterals(collaterals);
				this.loanRepository.save(c);
			});
			return true;	
		}else
		{
			return false;
		}
	}
}
