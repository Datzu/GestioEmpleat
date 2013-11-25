package com.gestioempleats.components;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class EmployeeInfoFrame extends JPanel {
	private JTextField textFieldId;
	private JTextField textFieldDNI;
	private JTextField textFieldName;
	private JTextField textFieldSurname1;
	private JTextField textFieldSurname2;
	private JTextField textFieldDateBirth;
	private JTextField textFieldPhone;
	private JTextField textFieldMobilePhone;
	private JTextField textFieldEmail;
	private JTextField textFieldDateContract;
	private JTextField textFieldSalary;
	private JTextField textFieldIncentives;
	private JTextField textFieldUser;
	private JTextField textFieldPassword;
	private JTextField textFieldConfirmPassword;

	/**
	 * Create the panel.
	 */
	public EmployeeInfoFrame() {
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
		
		textFieldDNI = new JTextField();
		add(textFieldDNI, "2, 8, fill, default");
		textFieldDNI.setColumns(10);
		
		textFieldName = new JTextField();
		add(textFieldName, "2, 10, fill, default");
		textFieldName.setColumns(10);
		
		textFieldSurname1 = new JTextField();
		add(textFieldSurname1, "2, 12, fill, default");
		textFieldSurname1.setColumns(10);
		
		textFieldSurname2 = new JTextField();
		add(textFieldSurname2, "2, 14, fill, default");
		textFieldSurname2.setColumns(10);
		
		textFieldDateBirth = new JTextField();
		add(textFieldDateBirth, "2, 16, fill, default");
		textFieldDateBirth.setColumns(10);
		
		textFieldPhone = new JTextField();
		add(textFieldPhone, "2, 18, fill, default");
		textFieldPhone.setColumns(10);
		
		textFieldMobilePhone = new JTextField();
		add(textFieldMobilePhone, "2, 20, fill, default");
		textFieldMobilePhone.setColumns(10);
		
		textFieldEmail = new JTextField();
		add(textFieldEmail, "2, 22, fill, default");
		textFieldEmail.setColumns(10);
		
		textFieldDateContract = new JTextField();
		add(textFieldDateContract, "2, 26, fill, default");
		textFieldDateContract.setColumns(10);
		
		textFieldSalary = new JTextField();
		add(textFieldSalary, "2, 28, fill, default");
		textFieldSalary.setColumns(10);
		
		textFieldIncentives = new JTextField();
		add(textFieldIncentives, "2, 30, fill, default");
		textFieldIncentives.setColumns(10);
		
		textFieldUser = new JTextField();
		add(textFieldUser, "2, 34, fill, default");
		textFieldUser.setColumns(10);
		
		textFieldPassword = new JTextField();
		add(textFieldPassword, "2, 36, fill, default");
		textFieldPassword.setColumns(10);
		
		textFieldConfirmPassword = new JTextField();
		add(textFieldConfirmPassword, "2, 38, fill, default");
		textFieldConfirmPassword.setColumns(10);

	}

}