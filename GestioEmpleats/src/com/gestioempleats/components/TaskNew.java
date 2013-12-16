package com.gestioempleats.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class TaskNew extends JPanel {
	private JTextField txtTaskId;
	private JTextField txtDateCreation;
	private JTextField txtDateEnd;
	private JTextField txtDateDelivery;
	private JTextArea  txtComment;
	private JComboBox  ComboEmployeeAssigned;

	/**
	 * @author Gerard, Adrian Garcia
	 * Crea una nova tasca
	 */
	public TaskNew() {
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
		
		JLabel lblTitleFrame = new JLabel("Nova Tasca");
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");
		
		JLabel lblId = new JLabel("ID: ");
		add(lblId, "2, 4, right, default");
		
		txtTaskId = new JTextField();
		add(txtTaskId, "4, 4, fill, default");
		txtTaskId.setColumns(10);
		
		JLabel lblTaskInfo = new JLabel("Estat de la Tasca:");
		lblTaskInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTaskInfo, "2, 6, right, default");
		
		JLabel lblDateCreation = new JLabel("Data Creació: ");
		add(lblDateCreation, "2, 8, right, default");
		
		txtDateCreation = new JTextField();
		add(txtDateCreation, "4, 8, fill, default");
		txtDateCreation.setColumns(10);
		
		JLabel lblDateEnd = new JLabel("Data Finalització: ");
		add(lblDateEnd, "2, 10, right, default");
		
		txtDateEnd = new JTextField();
		add(txtDateEnd, "4, 10, fill, default");
		txtDateEnd.setColumns(10);
		
		JLabel lblDateDelivery = new JLabel("Data d'Entrega: ");
		add(lblDateDelivery, "2, 12, right, default");
		
		txtDateDelivery = new JTextField();
		add(txtDateDelivery, "4, 12, fill, default");
		txtDateDelivery.setColumns(10);
		
		JLabel lblComment = new JLabel("Comentari: ");
		add(lblComment, "2, 14, right, default");
		
		txtComment = new JTextArea();
		add(txtComment, "4, 14, fill, fill");
		
		JLabel lblEmployeeAssigned = new JLabel("Empleat assignat: ");
		add(lblEmployeeAssigned, "2, 16, right, default");
		
		ComboEmployeeAssigned = new JComboBox();
		ArrayList<String> employeeArray = MongoDBUtils.getAllEmployee();
		for (String employeeName : employeeArray) {
			ComboEmployeeAssigned.addItem(employeeName);
		}
		add(ComboEmployeeAssigned, "4, 16, fill, default");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MongoDBUtils.saveTask(
						Integer.parseInt(txtTaskId.getText().toString()), 
						txtDateCreation.getText().toString(),
						txtDateEnd.getText().toString(),
						txtDateDelivery.getText().toString(),
						txtComment.getText().toString(),
						ComboEmployeeAssigned.getSelectedItem().toString(),
						4
						);
			}
		});
		
		JButton button = new JButton("Tornar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.loadHomeFrame();
			}
		});
		add(button, "2, 18, center, default");
		add(btnGuardar, "4, 18, right, default");
		
		

	}

}
