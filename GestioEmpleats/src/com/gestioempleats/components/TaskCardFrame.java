package com.gestioempleats.components;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class TaskCardFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	public TaskCardFrame(String titleFrame) {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblTitleFrame = new JLabel(titleFrame);
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");
		
		JLabel lblId = new JLabel("ID: ");
		add(lblId, "2, 4, right, default");
		
		JLabel lblTaskInfo = new JLabel("Estat de la Tasca:");
		lblTaskInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTaskInfo, "2, 6, right, default");
		
		JLabel lblDateCreation = new JLabel("Data Creaci�: ");
		add(lblDateCreation, "2, 8, right, default");
		
		JLabel lblDateEnd = new JLabel("Data Finalitzaci�: ");
		add(lblDateEnd, "2, 10, right, default");
		
		JLabel lblDateDelivery = new JLabel("Data d'Entrega: ");
		add(lblDateDelivery, "2, 12, right, default");
		
		JLabel lblSurname2 = new JLabel("Comentari: ");
		add(lblSurname2, "2, 14, right, default");
		
		JLabel lblEmployeeAssigned = new JLabel("Empleat assignat: ");
		add(lblEmployeeAssigned, "2, 16, right, default");
		
		

	}

}
