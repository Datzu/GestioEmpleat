package com.gestioempleats.components;

/**
 *  0- empleat
 *  1- tasques
 *  2- incidencies
 *  3- consulta
 *  4 - settings
 */
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import com.gestioempleats.start.MainFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageFrame extends JPanel {
	private int n;

	/**
	 * @author Gerard, Adrian Garcia
	 * @param newString
	 *            Cadena de text que agafara per mostrar el nou
	 * @param modifyString
	 *            Cadena de text que agafara per mostrar el modificar
	 * @param deleteString
	 *            Cadena de text que agafara per mostrar el esborrat
	 * @param n
	 *            Serveix de comodi per saber desde on vens i saber cap a on vas
	 *            carregant la finestra amb uns metodes o uns altres
	 */
	public int getFrom() {
		return this.n;
	}
	
	public void setFrom(int n) {
		this.n = n;
	}

	public ManageFrame(String newString, String modifyString,
			String deleteString, int n) {
		setFrom(n);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("190px:grow"),
				ColumnSpec.decode("max(31dlu;default)"), },
				new RowSpec[] { FormFactory.UNRELATED_GAP_ROWSPEC,
						RowSpec.decode("23px"),
						FormFactory.UNRELATED_GAP_ROWSPEC,
						RowSpec.decode("23px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("23px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(11dlu;default):grow"),
						FormFactory.UNRELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JButton btnNew = new JButton(newString);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (MainFrame.currentUser.getLevel()) {
					case 0:
						switch (getFrom()) {
						case 0:
							MainFrame.loadEmployeeNew();
							break;
						case 1:
							MainFrame.loadTaskNew();
							break;
						case 2:
							MainFrame.loadTroubleNew();
							break;
						}
						break;
					case 1:
						switch (getFrom()) {
						case 0:
							MainFrame.loadEmployeeShow();
							break;
						case 1:
							MainFrame.loadTaskNew();
							break;
						case 2:
							MainFrame.loadTroubleNew();
							break;
						}
						break;
					case 2:
						switch (getFrom()) {
						case 0:
							MainFrame.loadEmployeeNew();
							break;
						case 1:
							JOptionPane.showMessageDialog(getComponent(0),
									"No pots accedir aqui.");
							break;
						case 2:
							MainFrame.loadTroubleNew();
							break;
						}
						break;
					case 3:
						switch (getFrom()) {
						case 0:
							MainFrame.loadEmployeeShow();
							break;
						case 1:
							JOptionPane.showMessageDialog(getComponent(0),
									"No pots accedir aqui.");
							break;
						case 2:
							MainFrame.loadTroubleNew();
							break;
						}
						break;
					case 4:
						switch (getFrom()) {
						case 0:
							MainFrame.loadEmployeeShow();
							break;
						case 1:
							JOptionPane.showMessageDialog(getComponent(0),
									"No pots accedir aqui.");
							break;
						case 2:
							MainFrame.loadTroubleNew();
							break;
						}
						break;
					}
			}
		});
		add(btnNew, "2, 2, fill, top");
		
		JButton btnDelete = new JButton(deleteString);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (MainFrame.currentUser.getLevel()) {
					case 0:
						switch (getFrom()) {
							// to do
							default:
								break;
						}
					default:
						JOptionPane.showMessageDialog(getComponent(0),
								"No pots accedir aqui.");
						break;
				}
			}
		});
		add(btnDelete, "2, 4, fill, top");

		ReturnFrame returnFrame = new ReturnFrame();
		add(returnFrame, "2, 8, fill, fill");

	}

}
