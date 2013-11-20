import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class MongoDBUtils {
	
	public static void startMongoDExe() {
		
		try {
			System.out.println("Starting Windows mongoDB server on " + MainFrame.path.getPathToExe());
			ProcessBuilder pb = new ProcessBuilder();
			Process p = Runtime.getRuntime().exec(MainFrame.path.getPathToExe());
			System.out.println("mongod.exe started sucefully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void installMongoDExe() {
		System.out.println("Starting install of mongoDB on " + MainFrame.path.getPathToMongoDB());
		File makeDirMongoDB = new File(MainFrame.path.getPathToMongoDB());
		makeDirMongoDB.mkdir();
		// copy to :systemdrive:\mongodb files from resource mongodb
		
	}
	
	public static void startDownloadMongoDB() {
		System.out.println("Starting download of mongoDB...");
		try {
			if (System.getProperty("os.arch").contains("86") || System.getProperty("os.arch").contains("i386")) {
				System.out.println(new File(MainFrame.path.getPathToMongoDB().toString()));
				FileUtils.copyURLToFile(new URL("http://fastdl.mongodb.org/win32/mongodb-win-i386-2.4.8.zip"), new File(MainFrame.path.getPathToMongoDB()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void saveDataToDB() {
		
	}
	
}
