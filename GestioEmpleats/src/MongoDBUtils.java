import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


public class MongoDBUtils {
	
	public static void startMongoDExe() {
		
		try {
			ProcessBuilder pb = new ProcessBuilder();
			Process p = Runtime.getRuntime().exec(MainFrame.path.getPathToExe());
			System.out.println("Starting Windows mongoDB server on " + MainFrame.path.getPathToExe());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void installMongoDExe() {
		System.out.println("Starting install of mongoDB on " + MainFrame.path.getPathToMongoDB());
		File makeDirMongoDB = new File(MainFrame.path.getPathToMongoDB());
		makeDirMongoDB.mkdir();
		
	}
	
	public static void saveDataToDB() {
		
	}
	
}
