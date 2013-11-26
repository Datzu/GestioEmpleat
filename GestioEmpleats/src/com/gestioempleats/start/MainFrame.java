package com.gestioempleats.start;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gestioempleats.components.FirstFrame;
import com.gestioempleats.components.LoginFrame;
import com.gestioempleats.utils.MongoDBUtils;
import com.gestioempleats.utils.Paths;
import com.gestioempleats.utils.Permissions;

public class MainFrame extends JFrame {
	private static JPanel contentPane = new JPanel();

	public static Paths path = new Paths();

	public static void main(String[] args) {
		Permissions.createPermissionArray();
		// System.out.println();
		if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
			path.setPathToMongoDB(System.getenv("SystemDrive") + File.separator
					+ "mongoDB");
			path.setPathToExe(System.getenv("SystemDrive") + File.separator
					+ "mongoDB" + File.separator + "bin" + "\\mongod.exe");
			File checkPathToExe = new File(path.getPathToExe());
			try {
				if (!checkPathToExe.exists()) {
					// MongoDBUtils.startDownloadMongoDB();
					MongoDBUtils.installMongoDExe();
				}
				System.out.println(System.getProperty("os.arch"));
				MongoDBUtils.startMongoDExe();
				MongoDBUtils.connectDatabase();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 187);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		if (MongoDBUtils.existsEmployee("superadmin")) {
			LoginFrame loginFrame = new LoginFrame();
			contentPane.add(loginFrame, BorderLayout.CENTER);
		} else {
			FirstFrame firstFrame = new FirstFrame();
			contentPane.add(firstFrame, BorderLayout.CENTER);
		}

	}

	public static void loadLoginFrame() {
		LoginFrame loginFrame = new LoginFrame();
		contentPane.removeAll();
		contentPane.getComponent(0).setVisible(false);
		System.out.println(contentPane.getParent().toString());
		//contentPane.add(loginFrame, BorderLayout.CENTER);
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		frame.add(loginFrame);
		//contentPane.repaint();
		//frame.setBounds(0, 0, 300, 300);
		//frame.setLocationRelativeTo(null);
		//frame.setResizable(false);
		//System.out.println(contentPane.getComponent(0).toString());

	}
}
