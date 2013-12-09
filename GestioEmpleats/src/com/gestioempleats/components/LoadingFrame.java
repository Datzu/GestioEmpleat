package com.gestioempleats.components;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class LoadingFrame extends JPanel {
	
	JLabel label = new JLabel();

	/**
	 * @author Adrian Garcia
	 * JPanel que mostra una imatge mentre es carrega el programa i fa les connexions a la base de dades
	 */
	public LoadingFrame() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		label.setIcon(new ImageIcon(LoadingFrame.class.getResource("/com/gestioempleats/components/loading.jpg")));
		add(label);

	}

}
