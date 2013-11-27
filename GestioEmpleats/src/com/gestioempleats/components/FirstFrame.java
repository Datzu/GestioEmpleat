package com.gestioempleats.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.gestioempleats.employeetypes.Admin;
import com.gestioempleats.start.MainFrame;
import com.gestioempleats.utils.Encrypt;
import com.gestioempleats.utils.MongoDBUtils;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class FirstFrame extends JPanel {
	private static JTextField textFieldUser;
	private static JPasswordField passwordFieldPassword;
	private static JPasswordField passwordFieldValidatePassword;

	public FirstFrame() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(73dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(108dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(69dlu;default)"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblFirstFrame = new JLabel("Crea un compte d'administrador.");
		add(lblFirstFrame, "2, 2");

		JLabel lblUser = new JLabel("Usuari:");
		add(lblUser, "2, 4, right, default");

		textFieldUser = new JTextField();
		add(textFieldUser, "4, 4, fill, default");
		textFieldUser.setColumns(10);

		JLabel lblPassword = new JLabel("Contrassenya:");
		add(lblPassword, "2, 6, right, default");

		passwordFieldPassword = new JPasswordField();
		add(passwordFieldPassword, "4, 6, fill, default");

		JLabel lblValidatePassword = new JLabel("Confirma la contrassenya:");
		add(lblValidatePassword, "2, 8, right, default");

		passwordFieldValidatePassword = new JPasswordField();
		add(passwordFieldValidatePassword, "4, 8, fill, default");

		JButton btnCreate = new JButton("Crear");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] data = new String[2];
					if (passwordFieldPassword
							.getText()
							.toString()
							.equals(passwordFieldValidatePassword.getText()
									.toString())) {
						data[0] = textFieldUser.getText().toString();
						// data[0] = Encrypt.encrypt(data[1]); // TODO encrypt password
						data[1] = passwordFieldPassword.getText().toString();
						Admin mAdmin = new Admin();
						mAdmin.set(data);
						mAdmin.put("user", data[0]);
						mAdmin.put("password", data[1]);
						MongoDBUtils.db = MongoDBUtils.mongoClient.getDB("db");
						mAdmin.saveToMongo();
						MainFrame.loadLoginFrame();
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		add(btnCreate, "4, 10");
	}
}
