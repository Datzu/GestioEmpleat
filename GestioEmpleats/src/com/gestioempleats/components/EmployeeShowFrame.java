package com.gestioempleats.components;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class EmployeeShowFrame extends JPanel {


	/**
	 * Create the panel.
	 */
	public EmployeeShowFrame(String ID, String DNI, String Name, String Surname1, String Surname2, String DateBirth,
							String Phone, String MobilePhone, String Email, String DateContract, String Salary, String Incentives,
							String User, String Password, String ConfirmPassword) {
		
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
				
		JLabel lblDNI = new JLabel(DNI);
		add(lblDNI, "2, 8, right, default");
		
		JLabel lblName = new JLabel(Name);
		add(lblName, "2, 10, right, default");
		
		JLabel lblSurname1 = new JLabel(Surname1);
		add(lblSurname1, "2, 12, right, default");
		
		JLabel lblSurname2 = new JLabel(Surname2);
		add(lblSurname2, "2, 14, right, default");
		
		JLabel lblDateBirth = new JLabel(DateBirth);
		add(lblDateBirth, "2, 16, right, default");
		
		JLabel lblPhone = new JLabel(Phone);
		add(lblPhone, "2, 18, right, default");
		
		JLabel lblMobilePhone = new JLabel(MobilePhone);
		add(lblMobilePhone, "2, 20, right, default");
		
		JLabel lblEmail = new JLabel(Email);
		add(lblEmail, "2, 22, right, default");
		
	
		JLabel lblDateContract = new JLabel(DateContract);
		add(lblDateContract, "2, 26, right, default");
		
		JLabel lblSalary = new JLabel(Salary);
		add(lblSalary, "2, 28, right, default");
		
		JLabel lblIncentives = new JLabel(Incentives);
		add(lblIncentives, "2, 30, right, default");
		
		JLabel lblUser = new JLabel(User);
		add(lblUser, "2, 34, right, default");
		
		JLabel lblPassword = new JLabel(Password);
		add(lblPassword, "2, 36, right, default");
		
		JLabel lblConfirmPassword = new JLabel(ConfirmPassword);
		add(lblConfirmPassword, "2, 38, right, default");

	}

}
