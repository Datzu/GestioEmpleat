import java.io.File;
import java.io.IOException;
import java.net.URL;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

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
		ZipFile zipFile;
		try {
			zipFile = new ZipFile(MainFrame.path.getPathToMongoDB()+File.separator+"mongoDB.zip");
			zipFile.extractAll(MainFrame.path.getPathToMongoDB());
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}
	
	public static void startDownloadMongoDB() {
		System.out.println("Starting download of mongoDB...");
		System.setProperty("http.agent", "Mozilla/5.0 (X11; Linux i686; rv:21.0) Gecko/20100101 Firefox/21.0");
		
		try {
			if (System.getProperty("os.arch").contains("86") || System.getProperty("os.arch").contains("i386")) {
				FileUtils.copyURLToFile(new URL("http://fastdl.mongodb.org/win32/mongodb-win32-i386-2.4.8.zip"), new File(MainFrame.path.getPathToMongoDB()+File.separator+"mongoDB.zip"));
			} else if (System.getProperty("os.arch").contains("64")) {
				FileUtils.copyURLToFile(new URL("http://fastdl.mongodb.org/win32/mongodb-win32-x86_64-2008plus-2.4.8.zip"), new File(MainFrame.path.getPathToMongoDB()+File.separator+"mongoDB.zip"));
			} else {
				System.out.println("Unknow architecture.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void saveDataToDB() {
		
	}
	
}
