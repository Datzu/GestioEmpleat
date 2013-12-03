package com.gestioempleats.components;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gestioempleats.utils.MongoDBUtils;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton btnSave;

	/**
	 * Create the panel.
	 */
	public EmployeeInfoFrame() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(117dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(177dlu;default)"),},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		textFieldId = new JTextField();
		add(textFieldId, "2, 4");
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
		
		btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*switch ()
				case a:
				break;
				
				MongoDBUtils.saveEmployee(
						textFieldId.getText().toString(), 
						user, 
						password, 
						textFieldName, 
						textFieldSurname1, 
						textFieldSurname2, 
						textFieldDateBirth, 
						textFieldDateContract, 
						textFieldSalary, 
						textFieldlevel, 
						textFieldtype, 
						textFieldrole, 
						textFieldshift, 
						textFieldlanguages, 
						textFieldorigin);*/
			}
		});
		add(btnSave, "2, 32");

	}

}