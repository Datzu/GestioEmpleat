package com.gestioempleats.components;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SearchFrame extends JPanel {
	private JTextField textFieldSearchText;

	/**
	 * Create the panel.
	 */
	public SearchFrame() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default)"),
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblTitleFrame = new JLabel(titleFrame);
		lblTitleFrame.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitleFrame, "2, 2, center, default");
		
		JLabel lblId = new JLabel("Filtrar:");
		add(lblId, "2, 4, right, default");
		
		JComboBox comboBoxSearchType = new JComboBox();
		add(comboBoxSearchType, "4, 4, fill, default");
		
		JLabel lblSearchText = new JLabel("Text a cercar:");
		add(lblSearchText, "2, 6, right, default");
		
		textFieldSearchText = new JTextField();
		add(textFieldSearchText, "4, 6, fill, default");
		textFieldSearchText.setColumns(10);
		
		JButton btnSearch = new JButton("Cercar");
		add(btnSearch, "4, 8");
		
	}

}
