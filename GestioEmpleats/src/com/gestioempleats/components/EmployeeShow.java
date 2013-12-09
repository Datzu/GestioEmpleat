package com.gestioempleats.components;

import javax.swing.JPanel;

import com.gestioempleats.start.MainFrame;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeShow extends JPanel {
	
	private String id = "";
	private String name = "";
	private String surname1 = "";
	private String surname2 = "";
	private String birthday = "";
	private String phone = "";
	
	public EmployeeShow() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(45dlu;default)"),},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		getValues();
		
		JLabel lblShowUsername = new JLabel((String) null);
		add(lblShowUsername, "2, 2");
		
		JLabel lblLevel = new JLabel("Level:");
		add(lblLevel, "2, 6, right, default");
		
		JLabel lblShowLevel = new JLabel(String.valueOf(MainFrame.currentUser.getLevel()));
		add(lblShowLevel, "4, 6, left, default");
		
		JLabel lblId = new JLabel("ID:");
		add(lblId, "2, 10, right, default");
		
		JLabel lblSId = new JLabel(this.id);
		add(lblSId, "4, 10");
		
		JLabel lblName = new JLabel("Name:");
		add(lblName, "2, 14, right, default");
		
		JLabel lblSName = new JLabel(this.name);
		add(lblSName, "4, 14");
		
		JLabel lblSurname1 = new JLabel("Surname1:");
		add(lblSurname1, "2, 16, right, default");
		
		JLabel lblSSurname1 = new JLabel(this.surname1);
		add(lblSSurname1, "4, 16");
		
		JLabel lblSurname2 = new JLabel("Surname2:");
		add(lblSurname2, "2, 18, right, default");
		
		JLabel lblSSurname2 = new JLabel(this.surname2);
		add(lblSSurname2, "4, 18");
		
		JLabel lblBirthdate = new JLabel("BirthDate:");
		add(lblBirthdate, "2, 20, right, default");
		
		JLabel lblSBirthdate = new JLabel(this.birthday);
		add(lblSBirthdate, "4, 20");
		
		JLabel lblPhone = new JLabel("Phone:");
		add(lblPhone, "2, 22, right, default");
		
		JLabel lblSPhone = new JLabel(this.phone);
		add(lblSPhone, "4, 22");
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.loadHomeFrame();
			}
		});
		add(btnReturn, "4, 24");

	}

	private void getValues() {
		BasicDBObject queryUser = new BasicDBObject();
		queryUser.put("user", MainFrame.currentUser.getUser());
		DBCursor cursor = MongoDBUtils.coll.find(queryUser);
		if (cursor.hasNext()) {
			DBObject userObject = cursor.next();
			setId(userObject.get("_id").toString());
			setName(userObject.get("name").toString());
			setSurname1(userObject.get("lastname1").toString());
			setSurname2(userObject.get("lastname2").toString());
			setBirthday(userObject.get("birthday").toString());
			setPhone(userObject.get("phone").toString());
			cursor.close();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
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

}