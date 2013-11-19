import java.io.File;
import java.io.IOException;


public class MongoDBUtils {
	
	public static void startMongoDExe() {
		
		try {
			ProcessBuilder pb = new ProcessBuilder();
			Process p = Runtime.getRuntime().exec(MainFrame.pathToExe.getPathToExe());
			System.out.println("Starting Windows mongoDB server on " + MainFrame.pathToExe.getPathToExe());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void installMongoDExe() {
		
		try {
			System.out.println("Starting install of mongoDB on " + MainFrame.pathToExe.getPathToExe());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
