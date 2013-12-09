package com.gestioempleats.employeetypes;

public class Administrator extends Employee {

	private String role;
	
	/**
	 * @author Gerard
	 * @param role Quien es el seu rol dins de l'empresa
	 * Referencia a un administrador dins de l'empresa
	 */
	
	public Administrator(int employeeId, String user, String password,
			String name, String lastname1, String lastname2, String birthday,
			String contractDate, float income, int level, String role) {
		super(employeeId, user, password, name, lastname1, lastname2, birthday,
				contractDate, income, level);
		this.role = role;
	}

}
