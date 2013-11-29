package com.gestioempleats.components;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class LoadingFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	public LoadingFrame() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoadingFrame.class.getResource("/com/gestioempleats/components/loading.jpg")));
		add(label);

	}

}
