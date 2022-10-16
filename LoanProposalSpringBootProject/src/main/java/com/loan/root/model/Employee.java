package com.loan.root.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.loan.root.constant.LoanConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name= LoanConstants.EMPLOYEETABLE)
public class Employee {
	
	@Id
	@Column(name="employeeId")
	private String employeeId;
	
	@Column(name="employeeName")
	private String employeeName;

}
