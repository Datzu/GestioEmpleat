package com.gestioempleats.start;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

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
			path.setPathToDB(System.getenv("SystemDrive") + File.separator
					+ "data" + File.separator + "db");
			File checkPathToDB = new File(path.getPathToDB());
			System.out.println(checkPathToDB.getAbsolutePath());
			try {
				if (!checkPathToDB.exists()) {
					checkPathToDB.mkdirs();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowsClosing(WindowEvent winEvt) {
				try {
					Runtime.getRuntime().exec("taskkill /F /IM mongod.exe");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		if (MongoDBUtils.existsSuperAdmin()) {
			loadLoginFrame();
		} else {
			FirstFrame firstFrame = new FirstFrame();
			contentPane.add(firstFrame, BorderLayout.CENTER);
		}
	}

	public static void loadLoginFrame() {
		LoginFrame loginFrame = new LoginFrame();
		contentPane.removeAll();
		contentPane.add(loginFrame, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(320, 285);
	}

}
