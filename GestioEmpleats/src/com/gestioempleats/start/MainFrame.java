package com.gestioempleats.start;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gestioempleats.components.FirtsFrame;
import com.gestioempleats.components.HomeFrame;
import com.gestioempleats.components.LoadingFrame;
import com.gestioempleats.components.LoginFrame;
import com.gestioempleats.utils.MongoDBUtils;
import com.gestioempleats.utils.Paths;
import com.gestioempleats.utils.Permissions;

public class MainFrame extends JFrame {
	public static JPanel contentPane = new JPanel();
	public static MainFrame frame;

	public static Paths path = new Paths();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainFrame();
					frame.setVisible(true);
					frame.setResizable(false);
					loadLoadingFrame();
					preLoad();
					if (MongoDBUtils.existsSuperAdmin()) {
						loadLoginFrame();
					} else {
						loadFirtsFrame();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void preLoad() {
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
					MongoDBUtils.startDownloadMongoDB();
					MongoDBUtils.installMongoDExe();
				}
				System.out.println("Detected: " + System.getProperty("os.arch"));
				MongoDBUtils.startMongoDExe();
				boolean check = false;
				while (!check) {
					check = MongoDBUtils.connectDatabase();
				}
			} catch (Exception e) {
				System.out.println("Failed loading mongod.exe!");
				//e.printStackTrace();
			}
		}
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 187);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				exit();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void exit() {
		try {
			System.out.println("Shutting down MongoDB server... See you later!");
			Runtime.getRuntime().exec("taskkill /F /IM mongod.exe");
		} catch (IOException es) {
			es.printStackTrace();
		}
		System.exit(0);
	}
	
	public static void loadFirtsFrame() {
		FirtsFrame firtsFrame = new FirtsFrame();
		contentPane.removeAll();
		contentPane.add(firtsFrame, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(480, 200);
	}
	
	public static void loadHomeFrame() {
		HomeFrame homeFrame = new HomeFrame();
		contentPane.removeAll();
		contentPane.add(homeFrame, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(190, 370);
	}

	public static void loadLoginFrame() {
		LoginFrame loginFrame = new LoginFrame();
		contentPane.removeAll();
		contentPane.add(loginFrame, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(320, 285);
	}
	
	public static void loadLoadingFrame() {
		LoadingFrame loadingFrame = new LoadingFrame();
		contentPane.removeAll();
		contentPane.add(loadingFrame, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 150);
	}

}
