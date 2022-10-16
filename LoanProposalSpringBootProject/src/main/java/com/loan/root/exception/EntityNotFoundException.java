package com.loan.root.exception;

public class EntityNotFoundException {
	String Excp;
	public EntityNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	

	public EntityNotFoundException(String Excp) {
		super();
		this.Excp = Excp;
	}


	public String getExcp() {
		return Excp;
	}

	public void setExcp(String Excp) {
		this.Excp = Excp;
	}
}
