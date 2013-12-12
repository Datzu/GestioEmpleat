package com.gestioempleats.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gestioempleats.start.MainFrame;
import com.gestioempleats.utils.Encrypt;
import com.gestioempleats.utils.MongoDBUtils;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Color;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class EmployeeNew extends JPanel {

	/**
	 * @author Adrian Garcia Crea una nova finestra de tipus empleat buida per
	 *         omplir i guardar a la base de dades
	 */

	private String id = "";
	private String user = "";
	private String password = "";
	private String name = "";
	private String lastname1 = "";
	private String lastname2 = "";
	private String birthday = "";
	private String phone = "";
	private String contractDate = "";
	private float income;
	private int type;
	private String aditional;

	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtLastname1;
	private JTextField txtLastname2;
	private JTextField txtBirthay;
	private JTextField txtPhone;
	private JTextField txtUser;
	private JTextField txtPassword;
	private JTextField txtContractDate;
	private JTextField txtIncome;
	private JTextField txtAditional;

	JLabel lblShowLevel = new JLabel("0");
	JLabel lblShowError = new JLabel("");
	
	JComboBox comboBox = new JComboBox();
	
	public EmployeeNew() {

		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(94dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(14dlu;default)"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblLevel = new JLabel("Level:");
		add(lblLevel, "2, 4, right, default");

		add(lblShowLevel, "4, 4, left, default");

		JLabel lblId = new JLabel("ID:");
		add(lblId, "2, 8, right, default");

		txtId = new JTextField();
		add(txtId, "4, 8, fill, default");
		txtId.setColumns(10);

		JLabel lblUser = new JLabel("User:");
		add(lblUser, "2, 10, right, default");

		txtUser = new JTextField();
		add(txtUser, "4, 10, fill, default");
		txtUser.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		add(lblPassword, "2, 12, right, default");

		txtPassword = new JTextField();
		add(txtPassword, "4, 12, fill, default");
		txtPassword.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		add(lblName, "2, 18, right, default");

		txtName = new JTextField();
		add(txtName, "4, 18, fill, default");
		txtName.setColumns(10);

		JLabel lblLastname1 = new JLabel("Lastname1:");
		add(lblLastname1, "2, 20, right, default");

		txtLastname1 = new JTextField();
		add(txtLastname1, "4, 20, fill, default");
		txtLastname1.setColumns(10);

		JLabel lblLastname2 = new JLabel("Lastname2:");
		add(lblLastname2, "2, 22, right, default");

		txtLastname2 = new JTextField();
		add(txtLastname2, "4, 22, fill, default");
		txtLastname2.setColumns(10);

		JLabel lblBirthdate = new JLabel("BirthDate:");
		add(lblBirthdate, "2, 24, right, default");

		txtBirthay = new JTextField();
		add(txtBirthay, "4, 24, fill, default");
		txtBirthay.setColumns(10);

		JLabel lblPhone = new JLabel("Phone:");
		add(lblPhone, "2, 26, right, default");

		txtPhone = new JTextField();
		add(txtPhone, "4, 26, fill, default");
		txtPhone.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setValues();
				if (check()) {				
					switch (getType()) {
						case 0:
							setAditional(txtAditional.getText().toString());
							break;
						case 1:
							setAditional(txtAditional.getText().toString());
							break;
						case 2:
							setAditional(txtAditional.getText().toString());
							break;
						case 3:
							setAditional(txtAditional.getText().toString());
							break;
					}
					MongoDBUtils.saveEmployee(id, user, password, name, lastname1,
							lastname2, birthday, phone, contractDate, income,
							comboBox.getSelectedIndex(), type, aditional);
					MainFrame.loadEmployeeNew();
				}
			}
		});

		JLabel lblContractDate = new JLabel("Contract date:");
		add(lblContractDate, "2, 28, right, default");

		txtContractDate = new JTextField();
		add(txtContractDate, "4, 28, fill, default");
		txtContractDate.setColumns(10);

		JLabel lblIncome = new JLabel("Income:");
		add(lblIncome, "2, 30, right, default");

		txtIncome = new JTextField();
		add(txtIncome, "4, 30, fill, default");
		txtIncome.setColumns(10);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.loadHomeFrame();
			}
		});

		txtAditional = new JTextField();
		add(txtAditional, "4, 34, fill, default");
		txtAditional.setColumns(10);
		
		lblShowError.setForeground(Color.RED);
		add(lblShowError, "2, 36, 3, 1");
		
		add(btnReturn, "2, 38");
		add(btnSave, "4, 38, right, default");

		JLabel lblType = new JLabel("Type:");
		add(lblType, "2, 32, right, default");

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent i) {
				setType(comboBox.getSelectedIndex());
				lblShowLevel.setText(String.valueOf(comboBox.getSelectedIndex()));
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Administrador", "Programador", "Secretaria", "Becari",
				"Commercial" }));
		comboBox.setToolTipText("");
		add(comboBox, "4, 32, fill, default");
		add(btnReturn, "2, 38");
		add(btnSave, "4, 38, right, default");

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname1() {
		return lastname1;
	}

	public void setLastname1(String lastname1) {
		this.lastname1 = lastname1;
	}

	public String getLastname2() {
		return lastname2;
	}

	public void setLastname2(String lastname2) {
		this.lastname2 = lastname2;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	public String getContractDate() {
		return contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public void setType(int num) {
		this.type = num;
	}

	public int getType() {
		return type;
	}
	
	public String getAditional() {
		return this.aditional;
	}

	public void setAditional(String aditional) {
		this.aditional = aditional;
	}
	
	public void setValues(){
		try {
			this.id = txtId.getText().toString();
			this.user = txtUser.getText().toString();
			this.password = txtPassword.getText().toString();
			this.name = txtName.getText().toString();
			this.lastname1 = txtLastname1.getText().toString();
			this.lastname2 = txtLastname2.getText().toString();
			this.birthday = txtBirthay.getText().toString();
			this.phone = txtPhone.getText().toString();
			this.contractDate = txtContractDate.getText().toString();
			this.income = Integer.valueOf(txtIncome.getText().toString());
			this.aditional = txtAditional.getText().toString();
		} catch (Exception e) {
			return;
		}
	}
	
	private boolean check() {
		if (this.id.length() < 3) {
			lblShowError.setText("Id te que tenir minim 3 caracters!");
			return false;
		}
		if (this.user.length() < 3) {
			lblShowError.setText("L'usuari te que tenir minim 3 caracters!");
			return false;
		}
		if (this.password.length() < 3) {
			lblShowError.setText("La contrasenya te que tenir minim 3 caracters!");
			return false;
		}
		if (this.name.length() < 1) {
			lblShowError.setText("Tens que omplir el nom!");
			return false;
		}
		if (this.lastname1.length() < 1) {
			lblShowError.setText("Tens que omplir el primer cognom!");
			return false;
		}
		if (this.lastname2.length() < 1) {
			lblShowError.setText("Tens que omplir el segon cognom!");
			return false;
		}
		if (this.birthday.length() < 3) {
			lblShowError.setText("La data te que ser correcta!");
			return false;
		}
		if (this.phone.length() != 9) {
			lblShowError.setText("El telefon te que tenir 9 digits!");
			return false;
		}
		if (this.contractDate.length() < 3) {
			lblShowError.setText("La data te que ser correcta!");
			return false;
		}
		if (this.income < 0) {
			lblShowError.setText("El salari no pot ser negatiu!!");
			return false;
		}
		if (this.aditional.length() < 1) {
			lblShowError.setText("Tens que omplir el camp adicional!!");
			return false;
		}
		return true;
	}
	
}
