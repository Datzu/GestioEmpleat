package com.gestioempleats.components;

import javax.swing.JPanel;
import javax.swing.JButton;

public class ManageFrame extends JPanel {

	public ManageFrame(String newString, String modifyString, String deleteString) {
		setLayout(null);
		
		JButton btnNew = new JButton(newString);
		btnNew.setBounds(10, 11, 104, 23);
		add(btnNew);
		
		JButton btnModify = new JButton(modifyString);
		btnModify.setBounds(10, 45, 104, 23);
		add(btnModify);
		
		JButton btnDelete = new JButton(deleteString);
		btnDelete.setBounds(10, 79, 104, 23);
		add(btnDelete);

	}
}
