package com.gestioempleats.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class TroubleNew extends JPanel {
	
	private JTextField txtTroubleID;
	private JTextField txtDateCreation;
	private JTextField txtEmployee;
	private JTextArea  txtComment;

	/**
	 * @author Gerard, Adrian Garcia
	 * Crea una nova incidencia
	 */
	public TroubleNew() {
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
		
		JLabel lblTitleFrame = new JLabel("Nova Incidencia");
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");
		
		JLabel lblId = new JLabel("ID: ");
		add(lblId, "2, 4, right, default");
		
		txtTroubleID = new JTextField();
		add(txtTroubleID, "4, 4, fill, default");
		txtTroubleID.setColumns(10);
		
		JLabel lblTroubleInfo = new JLabel("Estat de la Incidencia:");
		lblTroubleInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTroubleInfo, "2, 6, right, default");
		
		JLabel lblDateCreation = new JLabel("Data Creació: ");
		add(lblDateCreation, "2, 8, right, default");
		
		txtDateCreation = new JTextField(getActualDate());
		add(txtDateCreation, "4, 8, fill, default");
		txtDateCreation.setColumns(10);
		
		JLabel lblDateEnd = new JLabel("Empelat que la genera:");
		add(lblDateEnd, "2, 10, right, default");
		
		txtEmployee = new JTextField(MainFrame.currentUser.getUser());
		add(txtEmployee, "4, 10, fill, default");
		txtEmployee.setColumns(10);
		
		JLabel lblDateDelivery = new JLabel("Comentari:");
		add(lblDateDelivery, "2, 12, right, default");
		
		txtComment = new JTextArea();
		add(txtComment, "4, 12, fill, fill");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MongoDBUtils.saveTrouble(
						Integer.parseInt(txtTroubleID.getText().toString()), 
						txtDateCreation.getText().toString(),
						txtEmployee.getText().toString(),
						txtComment.getText().toString()
						);
				MainFrame.loadTroubleNew();
			}
		});
		
		JButton btnTornar = new JButton("Tornar");
		btnTornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.loadHomeFrame();
			}
		});
		add(btnTornar, "2, 14, center, default");
		add(btnGuardar, "4, 14, right, default");

	}
	
	public static String getActualDate() {
		 Date ahora = new Date();
		 SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		 return formateador.format(ahora);
	}

}
