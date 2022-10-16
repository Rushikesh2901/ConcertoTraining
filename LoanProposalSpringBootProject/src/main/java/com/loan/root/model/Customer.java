package com.loan.root.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
@ToString
@Entity
@Table(name= LoanConstants.CUSTOMERTABLE)
public class Customer {
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="customerAddress")
	private String customerAddress;	
	
	@Id
	@Column(name="customerEmailId")
	private String customerEmailId;
	
	@Column(name="customerIdentity")
	private String customerIdentity;
	
	@Column(name="annualIncome")
	private double annualIncome;
	
	@Column(name="incomeTaxReturnAttached")
	private boolean incomeTaxReturnAttached;

}
