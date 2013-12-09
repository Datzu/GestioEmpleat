package com.gestioempleats.components;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;



public class TaskShowFrame extends JPanel {
	/**
	 * Create the panel.
	 */
	public TaskShowFrame(String taskID, String DateCreation, String DateEnd, String DateDelivery, String Comment, 
			String EmployeeAssigned) {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblTitleFrame = new JLabel("Show Task");
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");
		
		JLabel lblId = new JLabel("ID: ");
		add(lblId, "2, 4, right, default");
		
		JLabel lblTaskIdShow = new JLabel(taskID);
		add(lblTaskIdShow, "4, 4");
		
		JLabel lblTaskInfo = new JLabel("Estat de la Tasca:");
		lblTaskInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTaskInfo, "2, 6, right, default");
		
		JLabel lblDateCreation = new JLabel("Data Creació: ");
		add(lblDateCreation, "2, 8, right, default");
		
		JLabel lblDateCreationShow = new JLabel(DateCreation);
		add(lblDateCreationShow, "4, 8");
		
		JLabel lblDateEnd = new JLabel("Data Finalització: ");
		add(lblDateEnd, "2, 10, right, default");
		
		JLabel lblDateEndShow = new JLabel(DateEnd);
		add(lblDateEndShow, "4, 10");
		
		JLabel lblDateDelivery = new JLabel("Data d'Entrega: ");
		add(lblDateDelivery, "2, 12, right, default");
		
		JLabel lblDateDeliveryShow = new JLabel(DateDelivery);
		add(lblDateDeliveryShow, "4, 12");
				
		JLabel lblComment = new JLabel("Comentari: ");
		add(lblComment, "2, 14, right, default");
		
		JTextArea txtCommentShow = new JTextArea();
		txtCommentShow.setText(Comment);
		add(txtCommentShow, "4, 14, fill, fill");
		
		JLabel lblEmployeeAssigned = new JLabel("Empleat assignat: ");
		add(lblEmployeeAssigned, "2, 16, right, default");
		
		JLabel lblEmployeeAssignedShow = new JLabel(EmployeeAssigned);
		add(lblEmployeeAssignedShow, "4, 16");
		
		
		

	}

}
