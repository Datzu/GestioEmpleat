package com.gestioempleats.components;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class TaskInfoFrame extends JPanel {
	private JTextField textFieldId;
	private JTextField textFieldDateCreation;
	private JTextField textFieldDateEnd;
	private JTextField textFieldDateDelivery;
	private JTextField textFieldEmployeeAssigned;
	private JTextArea textAreaComment;
	/**
	 * Create the panel.
	 */
	public TaskInfoFrame() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default):grow"),
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		textFieldId = new JTextField();
		add(textFieldId, "2, 4, fill, default");
		textFieldId.setColumns(10);
		
		textFieldDateCreation = new JTextField();
		add(textFieldDateCreation, "2, 8, fill, default");
		textFieldDateCreation.setColumns(10);
		
		textFieldDateEnd = new JTextField();
		add(textFieldDateEnd, "2, 10, fill, default");
		textFieldDateEnd.setColumns(10);
		
		textFieldDateDelivery = new JTextField();
		add(textFieldDateDelivery, "2, 12, fill, default");
		textFieldDateDelivery.setColumns(10);
		
		textAreaComment = new JTextArea();
		add(textAreaComment, "2, 14, fill, fill");
		
		
		textFieldEmployeeAssigned = new JTextField();
		add(textFieldEmployeeAssigned, "2, 16, fill, default");
		textFieldEmployeeAssigned.setColumns(10);

	}

}