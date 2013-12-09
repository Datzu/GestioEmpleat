package com.gestioempleats.employeetypes;

import java.util.List;

public class Programmer extends Employee {
	
	/**
	 * @author Gerard
	 * @param languages Llenguatges de programacio que coneix l'empleat
	 * Clase que referencia a un programador
	 */
	
	private List<String> languages;

	public Programmer(int employeeId, String user, String password,
			String name, String lastname1, String lastname2, String birthday,
			String contractDate, float income, int level) {
		super(employeeId, user, password, name, lastname1, lastname2, birthday,
				contractDate, income, level);
	}
	
	public void addLanguage(String language) {
		this.languages.add(language);
	}

}
