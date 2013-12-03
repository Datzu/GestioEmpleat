package com.gestioempleats.components;
/**
 *  0- empleat
 *  1- tasques
 *  2- incidencies
 *  3- consulta
 *  4 - settings
 */
import javax.swing.JPanel;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageFrame extends JPanel {
	static int n;

	public ManageFrame(String newString, String modifyString, String deleteString, int n) {
		this.n=n;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("190px:grow"),
				ColumnSpec.decode("max(31dlu;default)"),},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(11dlu;default):grow"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnNew = new JButton(newString);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (ManageFrame.n){
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
				}
			}
		});
		add(btnNew, "2, 2, fill, top");
		
		JButton btnModify = new JButton(modifyString);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (ManageFrame.n){
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
			}
			}
		});
		add(btnModify, "2, 4, fill, top");
		
		JButton btnDelete = new JButton(deleteString);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (ManageFrame.n){
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
			}
			}
		});
		add(btnDelete, "2, 6, fill, top");
		
		ReturnFrame returnFrame = new ReturnFrame();
		add(returnFrame, "2, 8, fill, fill");

	}
}
