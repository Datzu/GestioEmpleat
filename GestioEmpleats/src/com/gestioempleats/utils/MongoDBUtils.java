package com.gestioempleats.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Set;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import org.apache.commons.io.FileUtils;

import com.gestioempleats.employeetypes.Admin;
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
	private static String fileExt = ".zip";

	public static MongoClient mongoClient;
	public static DB db;

	public static void startMongoDExe() {
		try {
			System.out.println("Starting Windows mongoDB server on "
					+ MainFrame.path.getPathToExe() + "...");
			Runtime.getRuntime().exec(MainFrame.path.getPathToExe());
			System.out.println("mongod.exe started sucefully!");
		} catch (IOException e) {
			System.out.println("Failed loading mongod.exe!");
			System.exit(0);
		}
	}

	public static void installMongoDExe() {
		System.out.println("Starting install of mongoDB on "
				+ MainFrame.path.getPathToMongoDB() + "...");
		ZipFile zipFile;
		File destDir = new File(MainFrame.path.getPathToMongoDB()
				+ File.separator);
		try {
			System.out.println(System.getProperty("os.arch"));
			zipFile = new ZipFile(MainFrame.path.getPathToMongoDB()
					+ File.separator + "mongoDB" + fileExt);
			zipFile.extractAll(MainFrame.path.getPathToMongoDB());

			if (System.getProperty("os.arch").contains("86")
					|| System.getProperty("os.arch").contains("i386")) {
				File srcDir = new File(MainFrame.path.getPathToMongoDB()
						+ File.separator + name86MongoDB);
				try {
					FileUtils.copyDirectory(srcDir, destDir);
					Paths.rmdir(srcDir);
				} catch (IOException e) {
					System.out.println("Downloading file failed.");
					System.exit(0);
				}
			} else if (System.getProperty("os.arch").contains("64")) {
				File srcDir = new File(MainFrame.path.getPathToMongoDB()
						+ File.separator + name64MongoDB);
				try {
					FileUtils.copyDirectory(srcDir, destDir);
					Paths.rmdir(srcDir);
				} catch (IOException e) {
					System.out.println("Downloading file failed.");
					System.exit(0);
				}
			} else {
				System.out.println("Unknow architecture.");
				System.exit(0);
			}
		} catch (ZipException e) {
			System.out.println("Failed getting system architecture.");
			System.exit(0);
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
								+ MongoDBUtils.fileExt), new File(
						MainFrame.path.getPathToMongoDB() + File.separator
								+ "mongoDB" + fileExt));
			} else if (System.getProperty("os.arch").contains("64")) {
				FileUtils.copyURLToFile(new URL(
						"http://fastdl.mongodb.org/win32/"
								+ MongoDBUtils.name64MongoDB
								+ MongoDBUtils.fileExt), new File(
						MainFrame.path.getPathToMongoDB() + File.separator
								+ "mongoDB" + fileExt));
			} else {
				System.out.println("Unknow architecture.");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Failed trying to download MongoDB.");
			System.exit(0);
		}
	}

	public static void saveDataToDB() {

	}

	public static boolean connectDatabase() {
		System.out.println("Connecting to MongoDB...");
		try {
			mongoClient = new MongoClient("localhost");
			db = mongoClient.getDB("db");
			System.out.println("Connected to MongoDB sucefully!");
			return true;
		} catch (Exception e) {
			System.out.println("Failed connecting to MongoDB!");
			return false;
			// e.printStackTrace();
		}
	}

	public static boolean existsSuperAdmin() {
		// System.out.println(myDoc); // debug mode
		DBCollection coll;
		try {
			coll = db.getCollection("adminUser");
		} catch (Exception e) {
			return false;
		}
		try {
			DBObject myDoc = coll.findOne();
			String existsObject = myDoc.toString();
			if (existsObject.contains("_id")) {
				System.out.println("SuperAdmin found!");
				return true;
			}
		} catch (Exception e) {
			return false;
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
