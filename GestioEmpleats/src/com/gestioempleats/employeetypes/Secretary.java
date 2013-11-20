package com.gestioempleats.employeetypes;

public class Secretary extends Employee {
	
	private String shift;

	public Secretary(int employeeId, String user, String password, String name,
			String lastname1, String lastname2, String birthday,
			String contractDate, float income, int level, String shift) {
		super(employeeId, user, password, name, lastname1, lastname2, birthday,
				contractDate, income, level);
		this.shift = shift;
	}
	
}
