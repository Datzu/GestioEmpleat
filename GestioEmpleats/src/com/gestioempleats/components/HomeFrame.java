package com.gestioempleats.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gestioempleats.start.MainFrame;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

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
		add(lblLogo, "4, 2, center, default");
		
		JButton btnMngEmployee = new JButton("Modul Empleats");
		add(btnMngEmployee, "4, 4");
		
		JButton btnMngTask = new JButton("Modul Tasques");
		add(btnMngTask, "4, 6");
		
		JButton btnMngTrouble = new JButton("Modul Incidencies");
		add(btnMngTrouble, "4, 8");
		
		JButton btnMngQuerys = new JButton("Modul Consultes");
		add(btnMngQuerys, "4, 10");
		
		JButton btnSettings = new JButton("Opcions");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeFrame homeFrame = new HomeFrame();
				MainFrame.contentPane.removeAll();
				MainFrame.contentPane.add(homeFrame, BorderLayout.CENTER);
				MainFrame.contentPane.revalidate();
				MainFrame.contentPane.repaint();
				MainFrame.contentPane.getRootPane().getParent().setSize(190, 370);
			}
		});
		add(btnSettings, "4, 12");
		
		JButton btnExit = new JButton("Sortir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.exit();
			}
		});
		add(btnExit, "4, 14");

	}

}
