package com.gestioempleats.start;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gestioempleats.components.EmployeeEdit;
import com.gestioempleats.components.EmployeeNew;
import com.gestioempleats.components.EmployeeShow;
import com.gestioempleats.components.FirstFrame;
import com.gestioempleats.components.HomeFrame;
import com.gestioempleats.components.LoginFrame;
import com.gestioempleats.components.ManageFrame;
import com.gestioempleats.components.SearchFrameAdministrator;
import com.gestioempleats.components.SearchFrameIntern;
import com.gestioempleats.components.SearchFrameProgrammer;
import com.gestioempleats.components.SearchFrameSecretary;
import com.gestioempleats.components.SettingsFrame;
import com.gestioempleats.components.TaskEdit;
import com.gestioempleats.components.TaskNew;
import com.gestioempleats.components.TaskShow;
import com.gestioempleats.components.TroubleEdit;
import com.gestioempleats.components.TroubleNew;
import com.gestioempleats.components.TroubleShow;
import com.gestioempleats.utils.ActualSession;
import com.gestioempleats.utils.MongoDBUtils;
import com.gestioempleats.utils.Paths;
import com.gestioempleats.utils.Permissions;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MainFrame extends JFrame {
	public static JPanel contentPane = new JPanel();
	public static MainFrame frame;

	public static Paths path = new Paths();

	public static ActualSession currentUser = new ActualSession();

	public static DBObject tmp;

	public static JFrame searchFrame = new JFrame();

	/**
	 * @author Gerard, Adrian Garcia
	 * @param args
	 *            Clase que inicialitza tot el programa i el carrega
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainFrame();
					frame.setVisible(true);
					frame.setResizable(false);
					preLoad();
					if (MongoDBUtils.existsSuperAdmin()) {
						loadLoginFrame();
					} else {
						loadFirtsFrame();
					}
				} catch (Exception e) {
					System.out
							.println("Failed loading the program! Please restart your programm.");
					System.exit(0);
				}
			}
		});
	}

	public static void preLoad() {
		Permissions.createPermissionArray();
		if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
			path.setPathToMongoDB(System.getenv("SystemDrive") + File.separator
					+ "mongoDB");
			path.setPathToExe(System.getenv("SystemDrive") + File.separator
					+ "mongoDB" + File.separator + "bin" + "\\mongod.exe");
			path.setPathToDB(System.getenv("SystemDrive") + File.separator
					+ "data" + File.separator + "db");
			path.setPathToBin(System.getenv("SystemDrive") + File.separator
					+ "mongoDB" + File.separator + "bin");
			File checkPathToDB = new File(path.getPathToDB());
			System.out.println("Detected: " + System.getProperty("os.arch"));
			try {
				if (!checkPathToDB.exists()) {
					checkPathToDB.mkdirs();
				}
			} catch (Exception e) {
				System.out
						.println("Failed checking for the path to the mongoDB!");
				System.exit(0);
			}
			File checkPathToExe = new File(path.getPathToExe());
			try {
				if (!checkPathToExe.exists()) {
					File checkPathToMongoDB = new File(path.getPathToMongoDB());
					if (!checkPathToMongoDB.exists()) {
						checkPathToMongoDB.mkdir();
						MongoDBUtils.startDownloadMongoDB();
					}
					File checkPathToBin = new File(path.getPathToBin());
					if (!checkPathToBin.exists()) {
						checkPathToBin.mkdir();
						MongoDBUtils.installMongoDExe();
					}
				}
				MongoDBUtils.startMongoDExe();
				MongoDBUtils.connectDatabase();
			} catch (Exception e) {
				System.out.println("Failed loading mongod.exe!");
				System.exit(0);
			}
		}
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 201);
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainFrame.class
				.getResource("/com/gestioempleats/components/loading.jpg")));
		contentPane.add(label, BorderLayout.CENTER);
		label.setVisible(true);
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
			System.out
					.println("Shutting down MongoDB server... See you later!");
			Runtime.getRuntime().exec("taskkill /F /IM mongod.exe");
		} catch (IOException es) {
			System.out
					.println("Opps, some kind of error happened shutting down the server!");
			System.exit(0);
		}
		System.exit(0);
	}

	public static void loadFirtsFrame() {
		FirstFrame firtsFrame = new FirstFrame();
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
		contentPane.getRootPane().getParent().setSize(190, 400);
	}

	public static void loadLoginFrame() {
		LoginFrame loginFrame = new LoginFrame();
		contentPane.removeAll();
		contentPane.add(loginFrame, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(320, 285);
	}

	public static void loadManageFrame(String newString, String modifyString,
			String deleteString, int n) {
		ManageFrame manageFrame = new ManageFrame(newString, modifyString,
				deleteString, n);
		contentPane.removeAll();
		contentPane.add(manageFrame, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(240, 190);
	}

	public static void loadSettingsFrame() {
		SettingsFrame settingsFrame = new SettingsFrame();
		contentPane.removeAll();
		contentPane.add(settingsFrame, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 500);
	}

	public static void loadSearchFrame() {
		searchFrame = new JFrame();
		searchFrame.setVisible(true);
		searchFrame.setBounds(0, 0, 470, 230);
		searchFrame.setLocationRelativeTo(null);
		searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		switch (currentUser.getLevel()) {
			case 0:
				searchFrame.setContentPane(new SearchFrameAdministrator());
				break;
			case 1:
				searchFrame.setContentPane(new SearchFrameProgrammer());
				break;
			case 2:
				searchFrame.setContentPane(new SearchFrameSecretary());
				break;
			case 3:
				searchFrame.setContentPane(new SearchFrameIntern());
				break;
		}
	}

	public static void closeSearchFrame() {
		searchFrame.setVisible(false);
	}

	public static void loadEmployeeNew() {
		EmployeeNew employeeNew = new EmployeeNew();
		contentPane.removeAll();
		contentPane.add(employeeNew, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 500);
	}

	public static void loadEmployeeEdit() {
		EmployeeEdit employeeEdit = new EmployeeEdit();
		contentPane.removeAll();
		contentPane.add(employeeEdit, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 500);
	}

	public static void loadEmployeeShow() {
		EmployeeShow employeeShow = new EmployeeShow();
		contentPane.removeAll();
		contentPane.add(employeeShow, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 500);
	}

	public static void loadTaskNew() {
		TaskNew taskNew = new TaskNew();
		contentPane.removeAll();
		contentPane.add(taskNew, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 500);
	}

	public static void loadTaskEdit() {
		TaskEdit taskEdit = new TaskEdit();
		contentPane.removeAll();
		contentPane.add(taskEdit, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 500);
	}

	public static void loadTaskShow() {
		TaskShow taskShow = new TaskShow();
		contentPane.removeAll();
		contentPane.add(taskShow, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 500);
	}

	public static void loadTroubleNew() {
		TroubleNew troubleNew = new TroubleNew();
		contentPane.removeAll();
		contentPane.add(troubleNew, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 500);
	}

	public static void loadTroubleEdit() {
		TroubleEdit troubleEdit = new TroubleEdit();
		contentPane.removeAll();
		contentPane.add(troubleEdit, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 500);
	}

	public static void loadTroubleShow() {
		TroubleShow troubleShow = new TroubleShow();
		contentPane.removeAll();
		contentPane.add(troubleShow, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.getRootPane().getParent().setSize(400, 500);
	}

}
