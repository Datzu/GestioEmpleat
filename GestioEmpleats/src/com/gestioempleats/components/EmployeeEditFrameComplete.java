package com.gestioempleats.components;

import javax.swing.JPanel;
import java.awt.FlowLayout;

public class EmployeeEditFrameComplete extends JPanel {

	/**
	 * Create the panel.
	 */
	public EmployeeEditFrameComplete() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		EmployeeCardFrame employeeCardFrame = new EmployeeCardFrame((String) null);
		add(employeeCardFrame);
		
		EmployeeInfoFrame employeeInfoFrame = new EmployeeInfoFrame();
		add(employeeInfoFrame);

	}

}
