package com.gestioempleats.components;

import javax.swing.JPanel;
import javax.swing.JButton;

import com.gestioempleats.start.MainFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

public class ReturnFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReturnFrame() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(65dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnReturn = new JButton("Tornar");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.loadHomeFrame();
			}
		});
		add(btnReturn, "2, 2, fill, default");

	}
}
