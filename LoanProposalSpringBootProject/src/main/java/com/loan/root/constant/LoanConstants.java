package com.loan.root.constant;

import java.util.ArrayList;

import com.loan.root.model.Collateral;

public class LoanConstants {

	public static final ArrayList<Collateral> COLLATERAL_TYPE = new ArrayList<Collateral>();
	public static final String[] LOAN_TYP= {"Home","Vehicle","Education"};
	public static final String[] ID_TYPE ={"Passport", "Driving license","PAN Card","Adharcard"};
	public static final String LOANTABLE="LOAN_101666";
	public static final String CUSTOMERTABLE= "CUSTOMERTABLE_101666";
	public static final String EMPLOYEETABLE= "EMPLOYEETABLE_101666";
	public static final String LOANCOLLATERALTABLE= "LOANCOLLATERALTABLE_101666";
	public static final String COLLATERALTABLE="COLLATERALTABLE_101666";

	public LoanConstants() {
	}
	public static double calculateRate(double period) {
		if(period <= 2)
			return 0.05;
		else if(period >2 && period <5)
			return 0.06;
		else if(period >=5 && period < 8)
			return 0.08;
		else
			return 0.085;
	}
}
