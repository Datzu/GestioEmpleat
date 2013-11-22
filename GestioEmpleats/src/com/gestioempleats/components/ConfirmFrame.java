package com.gestioempleats.components;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ConfirmFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConfirmFrame(String classType, String identificationType, String identificationValue) {
		setLayout(new FormLayout(new ColumnSpec[] {
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblStatic = new JLabel("Estas segur que vols borrar aquest");
		add(lblStatic, "2, 2");
		
		JLabel lblClassType = new JLabel(classType);
		add(lblClassType, "4, 2");
		
		JLabel lblStatic2 = new JLabel("identificat per el");
		add(lblStatic2, "2, 4, right, default");
		
		JLabel lblIdentificationType = new JLabel(identificationType);
		add(lblIdentificationType, "4, 4");
		
		JLabel lblStatic3 = new JLabel("amb un contingut de");
		add(lblStatic3, "2, 6, right, default");
		
		JLabel lblIdentificationValue = new JLabel(identificationValue);
		add(lblIdentificationValue, "4, 6");
		
		JButton btnSi = new JButton("Si");
		add(btnSi, "2, 8, right, default");
		
		JButton btnNo = new JButton("No");
		add(btnNo, "4, 8, left, default");

	}

}
