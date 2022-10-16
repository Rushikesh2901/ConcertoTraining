package com.loan.root;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.loan.root.model.Collateral;
import com.loan.root.model.Customer;
import com.loan.root.model.Employee;
import com.loan.root.model.Loan;

@SpringBootApplication
public class LoanProposalSpringBootProjectApplication {
	@Autowired
	com.loan.root.repository.LoanRepository loanRepository;
	
	@Autowired
	com.loan.root.service.EmployeeService employeeService;
	public static void main(String[] args) {
		SpringApplication.run(LoanProposalSpringBootProjectApplication.class, args);
	}
	
//	@Bean
//	public void initialize() {
//		//Adding Customer
//		Customer cust = new Customer();		
//		cust.setCustomerName("ram");
//		cust.setCustomerAddress("mumbai");
//		cust.setCustomerEmailId("ram@gmail.com");
//		cust.setCustomerIdentity("111");
//		cust.setAnnualIncome(10000.0);
//		cust.setIncomeTaxReturnAttached(true);
//		
//		Collateral co1 = new Collateral();
//		co1.setCollateralId("101");
//		co1.setCollateralType("Test101");
//		collateralRepository.save(co1);
//		
//		Collateral co2 = new Collateral();
//		co2.setCollateralId("102");
//		co2.setCollateralType("Test101");
//		collateralRepository.save(co2);
//		
//		Employee emp=new Employee();
//		emp.setEmployeeId(101+"");
//		emp.setEmployeeName("Employee"+101);
//		
//		Loan loan = new Loan();
//		loan.setLoanId("11");
//		loan.setLoanType("vehicle");
//		loan.setLoanAmount(20000.0);
//		loan.setInterestRate(8.0);
//		loan.setPeriod(3.0);
//		loan.setApproval(true);
//		loan.setRemarks("test");
//		loan.setCustomer(cust);
//		loan.setEmployee(emp);		
//		
//		this.loanRepository.save(loan);
//		
//		for(int i=1;i<=10;i++) {
//			Employee e=new Employee();
//			e.setEmployeeId(""+i);
//			e.setEmployeeName("Employee"+(i));
//			this.employeeService.addEmployee(e);
//		}		
//		
		
//}
}
