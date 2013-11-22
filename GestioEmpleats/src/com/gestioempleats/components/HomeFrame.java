package com.gestioempleats.components;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HomeFrame extends JPanel {

	/**
	 * Create the panel.
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(HomeFrame.class.getResource("/com/gestioempleats/components/logo.jpg")));
		add(lblLogo, "4, 2");
		
		JButton btnMngEmployee = new JButton("Modul Empleats");
		add(btnMngEmployee, "4, 4");
		
		JButton btnMngTask = new JButton("Modul Tasques");
		add(btnMngTask, "4, 6");
		
		JButton btnMngTrouble = new JButton("Modul Incidencies");
		add(btnMngTrouble, "4, 8");
		
		JButton btnMngQuerys = new JButton("Modul Consultes");
		add(btnMngQuerys, "4, 10");
		
		JButton btnSettings = new JButton("Opcions");
		add(btnSettings, "4, 12");
		
		JButton btnExit = new JButton("Sortir");
		add(btnExit, "4, 14");

	}

}
