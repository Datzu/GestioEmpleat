package com.gestioempleats.components;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import java.awt.Font;

public class EmployeeCardFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	public EmployeeCardFrame() {
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
		
		JLabel lblTitleFrame = new JLabel("Titol");
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");
		
		JLabel lblId = new JLabel("ID: ");
		add(lblId, "2, 4, right, default");
		
		JLabel lblPersonalInfo = new JLabel("Dades Personals:");
		lblPersonalInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblPersonalInfo, "2, 6, right, default");
		
		JLabel lblDNI = new JLabel("DNI: ");
		add(lblDNI, "2, 8, right, default");
		
		JLabel lblName = new JLabel("Nom:");
		add(lblName, "2, 10, right, default");
		
		JLabel lblSurname1 = new JLabel("Cognom 1:");
		add(lblSurname1, "2, 12, right, default");
		
		JLabel lblSurname2 = new JLabel("Cognom2: ");
		add(lblSurname2, "2, 14, right, default");
		
		JLabel lblDateBirth = new JLabel("Data de naixement: ");
		add(lblDateBirth, "2, 16, right, default");
		
		JLabel lblPhone = new JLabel("Tel\u00E8fon:");
		add(lblPhone, "2, 18, right, default");
		
		JLabel lblMobilePhone = new JLabel("Telf. M\u00F2bil:");
		add(lblMobilePhone, "2, 20, right, default");
		
		JLabel lblEmail = new JLabel("Email:");
		add(lblEmail, "2, 22, right, default");
		
		JLabel lblContractInfo = new JLabel("Dades Contractuals:");
		lblContractInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblContractInfo, "2, 24, right, default");
		
		JLabel lblDateContract = new JLabel("Data del contracte: ");
		add(lblDateContract, "2, 26, right, default");
		
		JLabel lblSalary = new JLabel("Sou:");
		add(lblSalary, "2, 28, right, default");
		
		JLabel lblNewLabel_11 = new JLabel("Incentius:");
		add(lblNewLabel_11, "2, 30, right, default");
		
		JLabel lblUserInfo = new JLabel("Dades Usuari:");
		lblUserInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblUserInfo, "2, 32, right, default");
		
		JLabel lblUser = new JLabel("Usuari:");
		add(lblUser, "2, 34, right, default");
		
		JLabel lblPassword = new JLabel("Contrassenya:");
		add(lblPassword, "2, 36, right, default");
		
		JLabel lblConfirmPassword = new JLabel("Confirma la contrassenya:");
		add(lblConfirmPassword, "2, 38, right, default");

	}

}
