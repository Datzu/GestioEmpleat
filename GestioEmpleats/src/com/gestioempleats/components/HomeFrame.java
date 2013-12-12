package com.gestioempleats.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.gestioempleats.start.MainFrame;
import com.gestioempleats.utils.MongoDBUtils;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.mongodb.DBCursor;

public class HomeFrame extends JPanel {

	/**
	 * @author Gerard, Adrian Garcia
	 * Aixo es el centre de tot el programa, el menu principal on es pot criar per on vols anar
	 */
	public HomeFrame() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(HomeFrame.class.getResource("/com/gestioempleats/components/logo.jpg")));
		add(lblLogo, "4, 2, center, default");
		
		JButton btnMngEmployee = new JButton("Modul Empleats");
		btnMngEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.loadManageFrame("Nou empleat", "Modificar empleat", "Esborrar empleat", 0);
			}
		});
		add(btnMngEmployee, "4, 4");
		
		JButton btnMngTask = new JButton("Modul Tasques");
		btnMngTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.loadManageFrame("Nova Tasca", "Modificar Tasca", "Esborrar Tasca", 1);
			}
		});
		add(btnMngTask, "4, 6");
		
		JButton btnMngTrouble = new JButton("Modul Incidencies");
		btnMngTrouble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.loadManageFrame("Nova incidencia", "Modificar incidencia", "Esborrar incidencia", 2);
			}
		});
		add(btnMngTrouble, "4, 8");
		
		JButton btnMngQuerys = new JButton("Modul Consultes");
		btnMngQuerys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.loadSearchFrame();
			}
		});
		add(btnMngQuerys, "4, 10");
		
		JButton btnSettings = new JButton("Opcions");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(getComponent(0),
						"No pots accedir aqui encara per la teva seguretat.");
				//MainFrame.loadSettingsFrame();
			}
		});
		add(btnSettings, "4, 12");
		
		JButton btnExit = new JButton("Sortir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.exit();
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.loadLoginFrame();
			}
		});
		add(btnLogout, "4, 14");
		add(btnExit, "4, 16");

	}

}
