package com.gestioempleats.components;

import javax.swing.JPanel;
import javax.swing.JButton;

public class ExitFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	public ExitFrame() {
		setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(10, 0, 89, 23);
		add(btnExit);

	}

}
