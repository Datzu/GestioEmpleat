import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gestioempleats.components.FirstFrame;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	static Paths path = new Paths();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Permissions.createPermissionArray();
		//System.out.println();
		//System.out.println(System.getenv("SystemDrive"));
		//Permissions.showPermissions();
		if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
			path.setPathToMongoDB(System.getenv("SystemDrive") + File.separator
					+ "mongoDB");
			path.setPathToExe(System.getenv("SystemDrive") + File.separator
					+ "mongoDB" + File.separator + "bin" + "\\mongod.exe");
			path.setPathToMongoDBBin(System.getenv("SystemDrive") + File.separator
					+ "mongoDB" + File.separator + "bin");
			File checkPathToExe = new File(path.getPathToExe());
			try {
				if (checkPathToExe.exists()) {
					MongoDBUtils.startMongoDExe();
				} else {
					MongoDBUtils.startDownloadMongoDB();
					MongoDBUtils.installMongoDExe();
				}

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

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		FirstFrame firstFrame = new FirstFrame();
		contentPane.add(firstFrame, BorderLayout.CENTER);
	}

}
