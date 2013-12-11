package com.gestioempleats.components;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.gestioempleats.start.MainFrame;
import com.gestioempleats.utils.MongoDBUtils;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;



public class TaskShow extends JPanel {
	private String id = "";
	private String data_creacio = "";
	private String data_finalitzacio = "";
	private String data_entrega = "";
	private String comentari = "";
	private String empleat_asignat = "";
	/**
	 * Create the panel.
	 */
	public TaskShow() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblTitleFrame = new JLabel("Show Task");
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");
		
		JLabel lblId = new JLabel("ID: ");
		add(lblId, "2, 4, right, default");
		
		JLabel lblTaskIdShow = new JLabel(this.id);
		add(lblTaskIdShow, "4, 4");
		
		JLabel lblTaskInfo = new JLabel("Estat de la Tasca:");
		lblTaskInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTaskInfo, "2, 6, right, default");
		
		JLabel lblDateCreation = new JLabel("Data Creació: ");
		add(lblDateCreation, "2, 8, right, default");
		
		JLabel lblDateCreationShow = new JLabel(this.data_creacio);
		add(lblDateCreationShow, "4, 8");
		
		JLabel lblDateEnd = new JLabel("Data Finalització: ");
		add(lblDateEnd, "2, 10, right, default");
		
		JLabel lblDateEndShow = new JLabel(this.data_finalitzacio);
		add(lblDateEndShow, "4, 10");
		
		JLabel lblDateDelivery = new JLabel("Data d'Entrega: ");
		add(lblDateDelivery, "2, 12, right, default");
		
		JLabel lblDateDeliveryShow = new JLabel(this.data_entrega);
		add(lblDateDeliveryShow, "4, 12");
				
		JLabel lblComment = new JLabel("Comentari: ");
		add(lblComment, "2, 14, right, default");
		
		JTextArea txtCommentShow = new JTextArea();
		txtCommentShow.setText(this.comentari);
		add(txtCommentShow, "4, 14, fill, fill");
		
		JLabel lblEmployeeAssigned = new JLabel("Empleat assignat: ");
		add(lblEmployeeAssigned, "2, 16, right, default");
		
		JLabel lblEmployeeAssignedShow = new JLabel(this.empleat_asignat);
		add(lblEmployeeAssignedShow, "4, 16");
		
		
		

	}
	
	private void getValues() {
		BasicDBObject queryTask = new BasicDBObject();
		MongoDBUtils.setCollection("task");
		DBCursor cursor = MongoDBUtils.coll.find(MainFrame.tmp);
		if (cursor.hasNext()) {
			DBObject userObject = cursor.next();
			setId(userObject.get("_id").toString());
			setData_creacio(userObject.get("data_creacio").toString());
			setData_finalitzacio(userObject.get("data_finalitzacio").toString());
			setData_entrega(userObject.get("data_entrega").toString());
			setComentari(userObject.get("comentari").toString());
			setEmpleat_asignat(userObject.get("empleat_asignat").toString());
			cursor.close();
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData_creacio() {
		return data_creacio;
	}
	public void setData_creacio(String data_creacio) {
		this.data_creacio = data_creacio;
	}
	public String getData_finalitzacio() {
		return data_finalitzacio;
	}
	public void setData_finalitzacio(String data_finalitzacio) {
		this.data_finalitzacio = data_finalitzacio;
	}
	public String getData_entrega() {
		return data_entrega;
	}
	public void setData_entrega(String data_entrega) {
		this.data_entrega = data_entrega;
	}
	public String getComentari() {
		return comentari;
	}
	public void setComentari(String comentari) {
		this.comentari = comentari;
	}
	public String getEmpleat_asignat() {
		return empleat_asignat;
	}
	public void setEmpleat_asignat(String empleat_asignat) {
		this.empleat_asignat = empleat_asignat;
	}

}
