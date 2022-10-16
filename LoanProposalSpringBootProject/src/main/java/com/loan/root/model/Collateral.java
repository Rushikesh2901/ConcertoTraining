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
@ToString
@Entity
@Table(name= LoanConstants.COLLATERALTABLE)
public class Collateral {
	@Id
	@Column(name="collateralId")
	private String collateralId;
	@Column(name="collateralType")
	private String collateralType;
}
