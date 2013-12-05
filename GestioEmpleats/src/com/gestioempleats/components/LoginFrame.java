package com.gestioempleats.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.gestioempleats.start.MainFrame;
import com.gestioempleats.utils.ActualSession;
import com.gestioempleats.utils.Encrypt;
import com.gestioempleats.utils.MongoDBUtils;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.Color;

public class LoginFrame extends JPanel {
	private JTextField textFieldUser;
	private JPasswordField passwordFieldPassword;
	private JLabel lblInfoLabel;
	private JButton btnLogin;
	private JLabel icon;
	private JLabel lblError;

	/**
	 * Create the panel.
	 */
	public LoginFrame() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(38dlu;default)"),
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
				RowSpec.decode("top:default"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		icon = new JLabel("");
		icon.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/gestioempleats/components/logo.jpg")));
		add(icon, "4, 2, center, default");
		
		lblInfoLabel = new JLabel("Inser your credentials to login:");
		add(lblInfoLabel, "4, 6");
		
		JLabel lblUser = new JLabel("User:");
		add(lblUser, "2, 8, right, default");
		
		textFieldUser = new JTextField();
		add(textFieldUser, "4, 8, fill, default");
		textFieldUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		add(lblPassword, "2, 10, right, default");
		
		passwordFieldPassword = new JPasswordField();
		add(passwordFieldPassword, "4, 10, fill, default");
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(MongoDBUtils.setActualUser(textFieldUser.getText().toString(), Encrypt.encrypt(passwordFieldPassword.getText().toString()))) {
					if (MainFrame.currentUser.getPassword().equals(Encrypt.encrypt(passwordFieldPassword.getText().toString()))) {
						MainFrame.loadHomeFrame();
					} else {
						lblError.setText("Incorrect password.");
					}
				} else {
					lblError.setText("User not found.");
				}
			}
		});
		add(btnLogin, "4, 12, center, default");
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		add(lblError, "2, 14, 3, 1");

	}

}
