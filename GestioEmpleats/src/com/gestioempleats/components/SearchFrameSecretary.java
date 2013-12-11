package com.gestioempleats.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gestioempleats.start.MainFrame;
import com.gestioempleats.utils.MongoDBUtils;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.mongodb.DBCursor;

import javax.swing.DefaultComboBoxModel;

public class SearchFrameSecretary extends JPanel {
	private JTextField textFieldSearchText;
	JComboBox comboBoxSearchType = new JComboBox();
	JComboBox comboBoxSearchValue = new JComboBox();

	/**
	 * @author Gerard, Adrian Garcia
	 * @param titleFrame
	 *            Cadena de text per mostrar a dalt de tot Finestra que serveix
	 *            per agafar i marcar el que es vol buscar
	 */
	public SearchFrameSecretary() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(121dlu;default):grow"),
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
				RowSpec.decode("default:grow"),}));

		JLabel lblTitleFrame = new JLabel("Search frame");
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");

		JLabel lblId = new JLabel("Filtrar:");
		add(lblId, "2, 4, right, default");
		comboBoxSearchType.setModel(new DefaultComboBoxModel(
				new String[] { "Empleat" }));

		add(comboBoxSearchType, "4, 4, fill, default");

		JLabel lbllf = new JLabel("Filtrar:");
		add(lbllf, "2, 6, right, default");
		comboBoxSearchValue.setModel(new DefaultComboBoxModel(new String[] {
				"ID", "Nom", "Data" }));

		add(comboBoxSearchValue, "4, 6, fill, default");

		JLabel lblSearchText = new JLabel("Text a cercar:");
		add(lblSearchText, "2, 8, right, default");

		textFieldSearchText = new JTextField();
		add(textFieldSearchText, "4, 8, fill, default");
		textFieldSearchText.setColumns(10);

		JButton btnSearch = new JButton("Cercar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBCursor cursor;
				MongoDBUtils.setCollection("employee");
				cursor = MongoDBUtils.findDBObject(comboBoxSearchValue.getSelectedItem().toString(), textFieldSearchText.getText().toString());
				if (cursor == null) {
					JOptionPane.showMessageDialog(getComponent(0),
							"No s'ha trobat res.");
					MainFrame.loadSearchFrame();
				} else if (cursor.hasNext()) {
					MainFrame.tmp = cursor.next();
					cursor.close();
					MainFrame.closeSearchFrame();
					MainFrame.loadEmployeeEdit();
				}
			}
		});
		add(btnSearch, "4, 10");

	}

}
