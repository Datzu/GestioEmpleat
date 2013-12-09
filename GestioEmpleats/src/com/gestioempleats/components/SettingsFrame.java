package com.gestioempleats.components;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingsFrame extends JPanel {

	/**
	 * @author Adrian Garcia
	 * Serveix per modificar les opcions que tenim disponible al nostre programa
	 */
	public SettingsFrame() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(65dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(25dlu;default):grow"),
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel, "2, 2, center, default");
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton, "4, 2, center, default");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		add(lblNewLabel_1, "2, 4, center, default");
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1, "4, 4, center, default");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		add(lblNewLabel_2, "2, 6, center, default");
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2, "4, 6, center, default");
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		add(btnNewButton_3, "4, 8");

	}

}
