package com.gestioempleats.components;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class TroubleInfoFrame extends JPanel {
	private JTextField textFieldId;
	private JTextField textFieldDateCreation;
	private JTextField textFieldEmployee;
	private JTextArea textAreaComment;
	/**
	 * Create the panel.
	 */
	public TroubleInfoFrame() {
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		textFieldId = new JTextField();
		add(textFieldId, "2, 4, fill, default");
		textFieldId.setColumns(10);
		
		textFieldDateCreation = new JTextField();
		add(textFieldDateCreation, "2, 8, fill, default");
		textFieldDateCreation.setColumns(10);
		
		textFieldEmployee = new JTextField();
		add(textFieldEmployee, "2, 10, fill, default");
		textFieldEmployee.setColumns(10);
		

		textAreaComment = new JTextArea();
		add(textAreaComment, "2, 12, fill, fill");

	}

}