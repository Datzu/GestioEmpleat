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
import javax.swing.JButton;


public class TroubleShow extends JPanel {
	private String id = "";
	private String data_creacio = "";
	private String empleat = "";
	private String comentari = "";
	/**
	 * @author Gerard
	 * Mostra una incidencia
	 */
	public TroubleShow() {
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
		
		JLabel lblTitleFrame = new JLabel("Mostrar Incidencia:");
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");
		
		JLabel lblId = new JLabel("ID: ");
		add(lblId, "2, 4, right, default");
		
		JLabel lblTroubleIdShow = new JLabel(this.id);
		add(lblTroubleIdShow, "4, 4");
		
		JLabel lblTroubleInfo = new JLabel("Estat de la Incidencia:");
		lblTroubleInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTroubleInfo, "2, 6, right, default");
		
		JLabel lblDateCreation = new JLabel("Data Creació: ");
		add(lblDateCreation, "2, 8, right, default");
		
		JLabel lblDateCreationShow = new JLabel(this.data_creacio);
		add(lblDateCreationShow, "4, 8");
		
		
		JLabel lblDateEnd = new JLabel("Empelat que la genera:");
		add(lblDateEnd, "2, 10, right, default");
		
		JLabel lblEmployeeShow = new JLabel(this.empleat);
		add(lblEmployeeShow, "4, 10");
		
		
		JLabel lblDateDelivery = new JLabel("Comentari:");
		add(lblDateDelivery, "2, 12, right, default");
		
		JTextArea txtCommentShow = new JTextArea();
		txtCommentShow.setText(this.comentari);
		add(txtCommentShow, "4, 12, fill, fill");
		
		JButton button = new JButton("Tornar");
		add(button, "2, 14, center, default");
		
		

	}
	
	private void getValues() {
		BasicDBObject queryTrouble = new BasicDBObject();
		MongoDBUtils.setCollection("trouble");
		DBCursor cursor = MongoDBUtils.coll.find(MainFrame.tmp);
		if (cursor.hasNext()) {
			DBObject userObject = cursor.next();
			setId(userObject.get("_id").toString());
			setData_creacio(userObject.get("data_creacio").toString());
			setEmpleat(userObject.get("empleat_asignat").toString());
			setComentari(userObject.get("comentari").toString());
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
	public String getEmpleat() {
		return empleat;
	}
	public void setEmpleat(String empleat) {
		this.empleat = empleat;
	}
	public String getComentari() {
		return comentari;
	}
	public void setComentari(String comentari) {
		this.comentari = comentari;
	}
	
	

}
