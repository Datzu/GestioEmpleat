package com.gestioempleats.employeetypes;

public class Employee {
	
	private int employeeId;
	private String user;
	private String password;
	private String name;
	private String lastname1;
	private String lastname2;
	private String birthday; // look for a more reliasable variable
	private String contractDate; // look for a more reliasable variable
	private float income;
	private int level;
	
	public Employee(int employeeId, String user, String password, String name,
			String lastname1, String lastname2, String birthday,
			String contractDate, float income, int level) {
		super();
		this.employeeId = employeeId;
		this.user = user;
		this.password = password;
		this.name = name;
		this.lastname1 = lastname1;
		this.lastname2 = lastname2;
		this.birthday = birthday;
		this.contractDate = contractDate;
		this.income = income;
		this.level = level;
	}

}
