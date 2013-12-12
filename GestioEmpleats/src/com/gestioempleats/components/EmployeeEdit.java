package com.gestioempleats.components;

import javax.swing.JPanel;

import com.gestioempleats.start.MainFrame;
import com.gestioempleats.utils.Encrypt;
import com.gestioempleats.utils.MongoDBUtils;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EmployeeEdit extends JPanel {

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
	
	private int level;
	
	private String aditional;
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
	
	JComboBox comboBox = new JComboBox();

	public EmployeeEdit() {
		
		setValues();
		
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(94dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(14dlu;default)"),},
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
		
		JLabel lblLevel = new JLabel("Level:");
		add(lblLevel, "2, 4, right, default");
		
		JLabel lblShowLevel = new JLabel(String.valueOf(level));
		add(lblShowLevel, "4, 4, left, default");
		
		JLabel lblId = new JLabel("ID:");
		add(lblId, "2, 8, right, default");
		
		JLabel lblSId = new JLabel(this.id);
		add(lblSId, "4, 8");
		
		JLabel lblUser = new JLabel("User:");
		add(lblUser, "2, 10, right, default");
		
		txtUser = new JTextField(this.user);
		add(txtUser, "4, 10, fill, default");
		txtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		add(lblPassword, "2, 12, right, default");
		
		txtPassword = new JTextField(this.password);
		add(txtPassword, "4, 12, fill, default");
		txtPassword.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		add(lblName, "2, 18, right, default");
		
		txtName = new JTextField(this.name);
		add(txtName, "4, 18, fill, default");
		txtName.setColumns(10);
		
		JLabel lblLastname1 = new JLabel("Lastname1:");
		add(lblLastname1, "2, 20, right, default");
		
		txtLastname1 = new JTextField(this.lastname1);
		add(txtLastname1, "4, 20, fill, default");
		txtLastname1.setColumns(10);
		
		JLabel lblLastname2 = new JLabel("Lastname2:");
		add(lblLastname2, "2, 22, right, default");
		
		txtLastname2 = new JTextField(this.lastname2);
		add(txtLastname2, "4, 22, fill, default");
		txtLastname2.setColumns(10);
		
		JLabel lblBirthdate = new JLabel("BirthDate:");
		add(lblBirthdate, "2, 24, right, default");
		
		txtBirthay = new JTextField(this.birthday);
		add(txtBirthay, "4, 24, fill, default");
		txtBirthay.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		add(lblPhone, "2, 26, right, default");
		
		txtPhone = new JTextField(this.phone);
		add(txtPhone, "4, 26, fill, default");
		txtPhone.setColumns(10);
		
		JLabel lblContractDate = new JLabel("Contract date:");
		add(lblContractDate, "2, 28, right, default");
		
		txtContractDate = new JTextField(this.contractDate);
		add(txtContractDate, "4, 28, fill, default");
		txtContractDate.setColumns(10);
		
		JLabel lblIncome = new JLabel("Income:");
		add(lblIncome, "2, 30, right, default");
		
		txtIncome = new JTextField(String.valueOf(this.income));
		add(txtIncome, "4, 30, fill, default");
		txtIncome.setColumns(10);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Programador", "Secretaria", "Becari", "Commercial"}));
		comboBox.setToolTipText("");
		comboBox.setSelectedIndex(level);
		add(comboBox, "4, 32, fill, default");
		
		txtAditional = new JTextField(this.aditional);
		add(txtAditional, "4, 34, fill, default");
		txtAditional.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBObject oldEmployee = MainFrame.tmp;
				BasicDBObject newEmployee = new BasicDBObject();
				//newEmployee.put("_id", txtId.getText().toString());
				newEmployee.put("user", txtUser.getText().toString());
				newEmployee.put("password", Encrypt.encrypt(txtPassword.getText().toString()));
				newEmployee.put("name", txtName.getText().toString());
				newEmployee.put("lastname1", txtLastname1.getText().toString());
				newEmployee.put("lastname2", txtLastname2.getText().toString());
				newEmployee.put("birthday", txtBirthay.getText().toString());
				newEmployee.put("phone", txtPhone.getText().toString());
				newEmployee.put("contractDate", txtContractDate.getText().toString());
				newEmployee.put("income", txtIncome.getText().toString());
				newEmployee.put("level", comboBox.getSelectedIndex());
				newEmployee.put("aditional", txtAditional.getText().toString());
				MongoDBUtils.updateEmployee(oldEmployee, newEmployee);
			}
		});
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.loadHomeFrame();
			}
		});
		
		JLabel lblType = new JLabel("Type:");
		add(lblType, "2, 32, right, default");
		
		add(btnReturn, "2, 38");
		add(btnSave, "4, 38, right, default");

	}

	private void setValues() {
		try {
			DBObject userObject = MainFrame.tmp;
			if (userObject != null) {
				setId(userObject.get("_id").toString());
				setUser(userObject.get("user").toString());
				setPassword(userObject.get("password").toString());
				setName(userObject.get("name").toString());
				setLastname1(userObject.get("lastname1").toString());
				setLastname2(userObject.get("lastname2").toString());
				setBirthday(userObject.get("birthday").toString());
				setPhone(userObject.get("phone").toString());
				setContractDate(userObject.get("contractDate").toString());
				setIncome(Float.valueOf(userObject.get("income").toString()));
				setLevel(Integer.valueOf(userObject.get("level").toString()));
				setAditional(userObject.get("aditional").toString());
			}
		} catch (Exception e) {
			return;
		}	
	}

	private void setLevel(Integer level) {
		this.level = level;
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
	
	public String getAditional() {
		return aditional;
	}

	public void setAditional(String aditional) {
		this.aditional = aditional;
	}

}
