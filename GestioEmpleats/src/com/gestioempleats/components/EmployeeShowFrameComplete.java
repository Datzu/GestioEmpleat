package com.gestioempleats.components;

import javax.swing.JPanel;
import java.awt.FlowLayout;

public class EmployeeShowFrameComplete extends JPanel {

	/**
	 * Create the panel.
	 */
	public EmployeeShowFrameComplete() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		EmployeeCardFrame employeeCardFrame = new EmployeeCardFrame((String) null);
		add(employeeCardFrame);
		
		EmployeeShowFrame employeeShowFrame = new EmployeeShowFrame((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null);
		add(employeeShowFrame);

	}

}
