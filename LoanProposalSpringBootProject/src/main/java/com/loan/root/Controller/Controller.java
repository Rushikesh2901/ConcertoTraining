package com.loan.root.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.loan.root.service.EmployeeService;
import com.loan.root.model.Employee;
import com.loan.root.model.Collateral;
import com.loan.root.model.Customer;
import com.loan.root.model.Loan;
import com.loan.root.repository.CollateralRepository;
import com.loan.root.service.CustomerService;
import com.loan.root.service.LoanService;



public class Controller {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private CollateralRepository collatoralRepository;
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping("/home")
	public String home() {
		return "This is home page";
	}
	
	@PostMapping(path="/customer", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		this.customerService.addCustomer(customer);
		return ResponseEntity.of(Optional.of("Customer addedd........."));
	}
	
	@GetMapping("/customer/{email}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
		System.out.println(email);
		Customer c= this.customerService.findCustomerByEmail(email);
		return ResponseEntity.of(Optional.of(c));	
	}
	
	@PostMapping(path="/employee", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		this.employeeService.addEmployee(employee);
		return ResponseEntity.of(Optional.of("Employee added........"));
	}
	
	@GetMapping("/employee/{employeeId}")
	public boolean searchByEmployeeById(@PathVariable String employeeId) {
		System.out.println(employeeId);
		return this.employeeService.searchByEmployeeById(employeeId);
	}
	
	
	@GetMapping("/loan/{id}")
	public ResponseEntity<Loan> getLoanById(@PathVariable String id) {
		System.out.println("Id:"+id);
		Loan loan=this.loanService.findLoanById(id);
		return ResponseEntity.of(Optional.of(loan));
	}	
	
	@PostMapping("/{email}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Loan applyLoan(@RequestBody Loan loan, @PathVariable String email) throws Exception
	{
		return this.loanService.applyForLoan(loan.getLoanType(),
				loan.getLoanAmount(), loan.getPeriod(), email);
	}
	
	@PostMapping("/upload/{loanid}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> uploadCollaterals(@PathVariable String loanid, @RequestBody List<String> collateralIds)
	{
		System.out.println("In..");
		 if(this.loanService.uploadCollateral(loanid, collateralIds))
			 return ResponseEntity.of(Optional.of("collaterl uploaded........"));
		return ResponseEntity.of(Optional.of("Collateral not uploaded........"));
	}
	
	@PostMapping("/approveLoan/{employeeId}")
	public void approveLoan(@PathVariable String employeeId) throws Exception 
	{
		if(this.employeeService.searchByEmployeeById(employeeId)) {
			this.employeeService.approveLoan(employeeId);
			
		}
	}
	
	
}
