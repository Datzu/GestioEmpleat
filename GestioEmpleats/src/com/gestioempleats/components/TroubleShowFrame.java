package com.gestioempleats.components;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class TroubleShowFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	public TroubleShowFrame(String troubleID, String DateCreation, String Employee, String Comment) {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(143dlu;default):grow"),
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblTitleFrame = new JLabel("Show Trouble");
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");
		
		JLabel lblId = new JLabel("ID: ");
		add(lblId, "2, 4, right, default");
		
		JLabel lblTroubleIdShow = new JLabel(troubleID);
		add(lblTroubleIdShow, "4, 4");
		
		JLabel lblTroubleInfo = new JLabel("Estat de la Incidencia:");
		lblTroubleInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTroubleInfo, "2, 6, right, default");
		
		JLabel lblDateCreation = new JLabel("Data Creació: ");
		add(lblDateCreation, "2, 8, right, default");
		
		JLabel lblDateCreationShow = new JLabel(DateCreation);
		add(lblDateCreationShow, "4, 8");
		
		
		JLabel lblDateEnd = new JLabel("Empelat que la genera:");
		add(lblDateEnd, "2, 10, right, default");
		
		JLabel lblEmployeeShow = new JLabel(Employee);
		add(lblEmployeeShow, "4, 10");
		
		
		JLabel lblDateDelivery = new JLabel("Comentari:");
		add(lblDateDelivery, "2, 12, right, default");
		
		JTextArea txtCommentShow = new JTextArea();
		txtCommentShow.setText(Comment);
		add(txtCommentShow, "4, 12, fill, fill");
		
		

	}

}
