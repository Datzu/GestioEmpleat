package com.gestioempleats.components;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeEditFrameComplete extends JPanel {

	/**
	 * Create the panel.
	 */
	public EmployeeEditFrameComplete() {
		setLayout(null);
		
		EmployeeCardFrame employeeCardFrame = new EmployeeCardFrame((String) null);
		employeeCardFrame.setBounds(10, 5, 195, 361);
		add(employeeCardFrame);
		
		EmployeeInfoFrame employeeInfoFrame = new EmployeeInfoFrame();
		employeeInfoFrame.setBounds(215, 5, 315, 429);
		add(employeeInfoFrame);
		
		ReturnFrame returnFrame = new ReturnFrame();
		returnFrame.setBounds(20, 350, 104, 29);
		add(returnFrame);

	}
}
