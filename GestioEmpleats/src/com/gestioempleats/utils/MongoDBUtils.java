package com.gestioempleats.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Set;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import org.apache.commons.io.FileUtils;

import com.gestioempleats.start.MainFrame;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBUtils {

	private static String name86MongoDB = "mongodb-win32-i386-2.4.8";
	private static String name64MongoDB = "mongodb-win32-x86_64-2008plus-2.4.8";
	private static String fileRoot = ".zip";

	public static MongoClient mongoClient;
	public static DB db;

	public static void startMongoDExe() {

		try {
			System.out.println("Starting Windows mongoDB server on "
					+ MainFrame.path.getPathToExe());
			Runtime.getRuntime().exec(MainFrame.path.getPathToExe());
			System.out.println("mongod.exe started sucefully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void installMongoDExe() {
		System.out.println("Starting install of mongoDB on "
				+ MainFrame.path.getPathToMongoDB());
		ZipFile zipFile;
		File destDir = new File(MainFrame.path.getPathToMongoDB()
				+ File.separator);
		try {
			zipFile = new ZipFile(MainFrame.path.getPathToMongoDB()
					+ File.separator + "mongoDB" + fileRoot);
			zipFile.extractAll(MainFrame.path.getPathToMongoDB());
			if (System.getProperty("os.arch").contains("86")
					|| System.getProperty("os.arch").contains("i386")) {
				File srcDir = new File(MainFrame.path.getPathToMongoDB()
						+ File.separator + name86MongoDB);
				try {
					FileUtils.copyDirectory(srcDir, destDir);
					MongoDBUtils.rmdir(srcDir);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (System.getProperty("os.arch").contains("64")) {
				File srcDir = new File(MainFrame.path.getPathToMongoDB()
						+ File.separator + name64MongoDB);
				try {
					FileUtils.copyDirectory(srcDir, destDir);
					MongoDBUtils.rmdir(srcDir);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Unknow architecture.");
			}
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}

	public static void startDownloadMongoDB() {
		System.out.println("Starting download of mongoDB...");
		System.setProperty("http.agent",
				"Mozilla/5.0 (X11; Linux i686; rv:21.0) Gecko/20100101 Firefox/21.0");
		try {
			if (System.getProperty("os.arch").contains("86")
					|| System.getProperty("os.arch").contains("i386")) {
				FileUtils.copyURLToFile(new URL(
						"http://fastdl.mongodb.org/win32/"
								+ MongoDBUtils.name86MongoDB
								+ MongoDBUtils.fileRoot), new File(
						MainFrame.path.getPathToMongoDB() + File.separator
								+ "mongoDB" + fileRoot));
			} else if (System.getProperty("os.arch").contains("64")) {
				FileUtils.copyURLToFile(new URL(
						"http://fastdl.mongodb.org/win32/"
								+ MongoDBUtils.name64MongoDB
								+ MongoDBUtils.fileRoot), new File(
						MainFrame.path.getPathToMongoDB() + File.separator
								+ "mongoDB" + fileRoot));
			} else {
				System.out.println("Unknow architecture.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveDataToDB() {

	}

	public static void rmdir(final File folder) {
		if (folder.isDirectory()) {
			File[] list = folder.listFiles();
			if (list != null) {
				for (int i = 0; i < list.length; i++) {
					File tmpF = list[i];
					if (tmpF.isDirectory()) {
						rmdir(tmpF);
					}
					tmpF.delete();
				}
			}
			if (!folder.delete()) {
				System.out.println("can't delete folder : " + folder);
			}
		}
	}

	public static void connectDatabase() {
		try {
			System.out.println("Connecting to MongoDB...");
			mongoClient = new MongoClient("localhost");
			db = mongoClient.getDB("db");
			System.out.println("Connected to MongoDB sucefully!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static boolean existsEmployee(String name) {
		DBCollection coll = db.getCollection("adminUser");
		DBObject myDoc = coll.findOne();
		// System.out.println(myDoc);
		try {
			String existsObject = myDoc.toString();
			if (existsObject.contains("_id")) {
				// System.out.println("Trobat");
				return true;
			} else {
				// System.out.println("NO Trobat");
				return false;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public static void showTables() {
		Set<String> tables = MongoDBUtils.db.getCollectionNames();

		for (String coll : tables) {
			System.out.println(coll);
		}
	}

}
