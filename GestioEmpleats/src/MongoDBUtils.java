import java.io.File;
import java.io.IOException;

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
	
	public static void saveDataToDB() {
		
	}
	
}
