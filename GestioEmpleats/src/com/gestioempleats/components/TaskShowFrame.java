package com.gestioempleats.components;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;



public class TaskShowFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	public TaskShowFrame(String ID, String DateCreation, String DateEnd, String DateDelivery, String Comment, 
			String EmployeeAssigned) {

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
		FormFactory.DEFAULT_ROWSPEC,
		FormFactory.RELATED_GAP_ROWSPEC,
		FormFactory.DEFAULT_ROWSPEC,
		FormFactory.RELATED_GAP_ROWSPEC,
		FormFactory.DEFAULT_ROWSPEC,}));

JLabel lblId = new JLabel(ID);
add(lblId, "2, 4, right, default");

JLabel lblDateCreation = new JLabel(DateCreation);
add(lblDateCreation, "2, 8, right, default");

JLabel lblDateEnd = new JLabel(DateEnd);
add(lblDateEnd, "2, 10, right, default");

JLabel lblDateDelivery = new JLabel(DateDelivery);
add(lblDateDelivery, "2, 12, right, default");

JLabel lblComment = new JLabel(Comment);
add(lblComment, "2, 14, right, default");

JLabel lblEmployeeAssigned = new JLabel(EmployeeAssigned);
add(lblEmployeeAssigned, "2, 16, right, default");



}

}
