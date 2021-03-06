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
import java.awt.Color;

public class FirstFrame extends JPanel {
	
	private static JTextField textFieldUser;
	private static JPasswordField passwordFieldPassword;
	private static JPasswordField passwordFieldValidatePassword;
	private static JButton btnCreate;
	private static JLabel lblShowError;
	
	/**
	 * @author Adrian Garcia
	 * Primera finestra en mostrarse si no existeis un compte creat, es mostra i et demana que creeis un de nou
	 */

	public FirstFrame() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(73dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(108dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(69dlu;default)"),},
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
		
		lblShowError = new JLabel("");
		lblShowError.setForeground(Color.RED);
		add(lblShowError, "2, 10, 3, 1");

		btnCreate = new JButton("Crear");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldUser.getText().toString().length() > 3) {
					if (passwordFieldPassword.getText().toString().length() > 3) {
						try {
							String[] data = new String[2];
							if (passwordFieldPassword
									.getText()
									.toString()
									.equals(passwordFieldValidatePassword.getText()
											.toString())) {
								data[0] = textFieldUser.getText().toString();
								data[1] = Encrypt.encrypt(passwordFieldPassword
										.getText().toString());
								Admin mAdmin = new Admin();
								mAdmin.set(data);
								mAdmin.put("user", data[0]);
								mAdmin.put("password", data[1]);
								mAdmin.put("level", 0);
								mAdmin.saveToMongo();
								MainFrame.loadLoginFrame();
		
							} else {
								lblShowError.setText("Les contrasenyes han de ser iguals!");
							}
						} catch (Exception e) {
							System.out.println("There was a problem creating the Super Admin!");
						}
					} else {
						lblShowError.setText("La contrasenya ha de tenir com ha minim 3 caracters!");
					}
				} else {
					lblShowError.setText("L'usuari ha de tenir com a minim 4 caracters!");
				}
				
			}
		});
		add(btnCreate, "4, 12");
	}
}
