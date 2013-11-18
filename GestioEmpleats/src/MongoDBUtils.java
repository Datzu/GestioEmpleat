import java.io.File;
import java.io.IOException;


public class MongoDBUtils {
	
	public static void startMongoDExe() {
		
		try {
			ProcessBuilder pb = new ProcessBuilder();
			Process p = Runtime.getRuntime().exec(Start.pathToExe);
			System.out.println("Starting Windows mongoDB server on "+Start.pathToExe);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void installMongoDExe() {
		
		try {
			System.out.println("Starting install of mongoDB on " + Start.pathToExe);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
