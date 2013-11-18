import javax.jws.Oneway;
import javax.swing.JFrame;

import org.omg.CORBA.Environment;

import com.gestioempleats.components.FirstFrame;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Start extends JFrame {

	public static String pathToExe = null;

	public Start() {
		FirstFrame firstFrame = new FirstFrame();
		getContentPane().add(firstFrame, BorderLayout.NORTH);
	}

	public static void main(String[] args) {

		// System.out.println(System.getenv("SystemDrive"));
		if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
			pathToExe = System.getenv("SystemDrive") + File.separator
					+ "mongoDB" + File.separator + "bin" + "\\mongod.exe";
			File checkPathToExe = new File(pathToExe);
			try {
				if (checkPathToExe.exists()) {
					MongoDBUtils.startMongoDExe();
				} else {
					MongoDBUtils.installMongoDExe();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}