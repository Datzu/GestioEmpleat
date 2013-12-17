package com.gestioempleats.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.gestioempleats.start.MainFrame;
import com.gestioempleats.utils.MongoDBUtils;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;


public class TroubleEdit extends JPanel {
	private JTextField txtTroubleID;
	private JTextField txtDateCreation;
	private JTextField txtEmployee;
	private JTextArea txtComment;
	
	private String id;
	private String dateCreation;
	private String employee;
	private String comment;

	/**
	 * @author Gerard, Adrian Garcia
	 * Modifica una incidencia
	 */
	public TroubleEdit() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(143dlu;default):grow"),
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblTitleFrame = new JLabel("Nova Incidencia:");
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");
		
		JLabel lblId = new JLabel("ID: ");
		add(lblId, "2, 4, right, default");
		
		txtTroubleID = new JTextField(this.id);
		add(txtTroubleID, "4, 4, fill, default");
		txtTroubleID.setColumns(10);
		
		JLabel lblTroubleInfo = new JLabel("Estat de la Incidencia:");
		lblTroubleInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTroubleInfo, "2, 6, right, default");
		
		JLabel lblDateCreation = new JLabel("Data Creació: ");
		add(lblDateCreation, "2, 8, right, default");
		
		txtDateCreation = new JTextField(this.dateCreation);
		add(txtDateCreation, "4, 8, fill, default");
		txtDateCreation.setColumns(10);
		
		JLabel lblDateEnd = new JLabel("Empelat que la genera:");
		add(lblDateEnd, "2, 10, right, default");
		
		txtEmployee = new JTextField(this.employee);
		add(txtEmployee, "4, 10, fill, default");
		txtEmployee.setColumns(10);
		
		JLabel lblDateDelivery = new JLabel("Comentari:");
		add(lblDateDelivery, "2, 12, right, default");
		
		txtComment = new JTextArea(this.comment);
		add(txtComment, "4, 12, fill, fill");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBObject oldTrouble = MainFrame.tmp;
				BasicDBObject newTrouble = new BasicDBObject();
				newTrouble.put("_id", txtTroubleID.getText().toString()); 
				newTrouble.put("creationDate", txtDateCreation.getText().toString());
				newTrouble.put("employee", txtEmployee.getText().toString());
				newTrouble.put("comment", txtComment.getText().toString());
				MongoDBUtils.updateTrouble(oldTrouble, newTrouble);
			}
		});
		
		JButton button = new JButton("Tornar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.loadHomeFrame();
			}
		});
		add(button, "2, 14, center, default");
		add(btnGuardar, "4, 14, right, default");

	}
	
	private void setValues() {
		try {
			DBObject troubleObject = MainFrame.tmp;
			if (troubleObject != null) {
				setId(troubleObject.get("_id").toString());
				setDateCreation(troubleObject.get("dateCreation").toString());
				setEmployee(troubleObject.get("Employee").toString());
				setComment(troubleObject.get("Comment").toString());
			}
		} catch (Exception e) {
			return;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
