package com.gestioempleats.employeetypes;

public class Intern extends Employee {
	
	/**
	 * @author Adrian Garcia
	 * @param origin per saber de quin tipus de centre ve
	 * Clase que fa referencia a un becari
	 */
	
	private String origin;

	public Intern(int employeeId, String user, String password, String name,
			String lastname1, String lastname2, String birthday,
			String contractDate, float income, int level, String origin) {
		super(employeeId, user, password, name, lastname1, lastname2, birthday,
				contractDate, income, level);
		this.origin = origin;
	}

}
