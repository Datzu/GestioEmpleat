package com.gestioempleats.employeetypes;

public class Commercial extends Employee {
	
	/**
	 * @author Adrian Garcia
	 * Clase que referencia a un comercial
	 */

	public Commercial(int employeeId, String user, String password,
			String name, String lastname1, String lastname2, String birthday,
			String contractDate, float income, int level) {
		super(employeeId, user, password, name, lastname1, lastname2, birthday,
				contractDate, income, level);
	}

}
