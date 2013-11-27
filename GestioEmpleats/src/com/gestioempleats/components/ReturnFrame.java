package com.gestioempleats.components;

import javax.swing.JPanel;
import javax.swing.JButton;

import com.gestioempleats.start.MainFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReturnFrame() {
		setLayout(null);
		JButton btnReturn = new JButton("Tornar");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.loadHomeFrame();
			}
		});
		btnReturn.setBounds(10, 11, 89, 23);
		add(btnReturn);

	}
}
