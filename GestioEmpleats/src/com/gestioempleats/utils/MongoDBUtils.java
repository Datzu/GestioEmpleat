package com.gestioempleats.utils;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.util.List;
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
	public static DBCollection coll;

	/**
	 * @author Gerard, Adrian Garcia Clase de utilitats per fer servir amb
	 *         mongoDB
	 */

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
			System.out.println("Failed unziping mongoDB.zip.");
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

	public static void setCollection(String cad) {
		coll = db.getCollection(cad);
	}

	public static boolean connectDatabase() {
		System.out.println("Connecting to MongoDB...");
		try {
			mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDB("db");
			try {
				setCollection("employee");
			} catch (Exception e) {
				System.out.println("Error getting the collection 'employee'.");
				return false;
			}

			System.out.println("Connected to MongoDB sucefully!");
			return true;
		} catch (Exception e) {
			System.out.println("Failed connecting to MongoDB!");
			return false;
		}
	}

	public static boolean existsSuperAdmin() {
		try {
			DBObject user = coll.findOne();
			if (user.containsKey("user")) {
				return true;
			} else {
				System.out.println("Loading first frame...");
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static void showTables() {
		Set<String> tables = MongoDBUtils.db.getCollectionNames();

		for (String coll : tables) {
			System.out.println(coll);
		}
	}

	public static boolean setActualUser(String user, String password) {
		BasicDBObject queryUser = new BasicDBObject();
		queryUser.put("user", user);
		DBCursor cursor = coll.find(queryUser);
		if (cursor.hasNext()) {
			DBObject userObject = cursor.next();
			MainFrame.currentUser.setUser(userObject.get("user").toString());
			MainFrame.currentUser.setPassword(userObject.get("password")
					.toString());
			MainFrame.currentUser.setLevel(Integer.parseInt(userObject.get(
					"level").toString()));
			cursor.close();
			return true;
		} else {
			System.out.println("User not found");
			cursor.close();
			return false;
		}
	}

	public static DBCursor findDBObject(String key, String value) {
		BasicDBObject queryUser = new BasicDBObject();
		switch (key) {
			case "ID":
				key = "_id";
				break;
			case "Usuari":
				key = "user";
				break;
			case "Nom":
				key = "name";
				break;
			case "Data":
				key = "contractDate";
				break;
		}
		queryUser.put(key, value);
		DBCursor cursor = coll.find(queryUser);
		if (cursor.hasNext()) {
			return cursor;
		} else {
			cursor.close();
			return null;
		}
	}

	public static void saveEmployee(String employeeId, String user,
			String password, String name, String lastname1, String lastname2,
			String birthday, String phone, String contractDate, float income,
			int level, int type, String aditional) {
		DBCollection table = MongoDBUtils.db.getCollection("employee");
		BasicDBObject employeeObject = new BasicDBObject();
		employeeObject.put("_id", employeeId);
		employeeObject.put("user", user);
		employeeObject.put("password", Encrypt.encrypt(password));
		employeeObject.put("name", name);
		employeeObject.put("lastname1", lastname1);
		employeeObject.put("lastname2", lastname2);
		employeeObject.put("birthday", birthday);
		employeeObject.put("phone", phone);
		employeeObject.put("contractDate", contractDate);
		employeeObject.put("income", income);
		employeeObject.put("level", level);
		employeeObject.put("aditional", aditional);
		table.insert(employeeObject);
	}

	public static void saveTask(int taskId, String dateCreation,
			String dateEnd, String dateDelivery, String comment,
			String employeeAsigned, int type) {
		DBCollection table = MongoDBUtils.db.getCollection("task");
		BasicDBObject taskObject = new BasicDBObject();
		switch (type) {
			case 0:
				taskObject.put("taskId", taskId);
				taskObject.put("dateCreation", dateCreation);
				taskObject.put("dateEnd", dateEnd);
				taskObject.put("dateDelivery", dateDelivery);
				taskObject.put("comment", comment);
				taskObject.put("employeeAsigned", employeeAsigned);
				break;
			case 1:
				break;
			case 2:
				taskObject.put("taskId", taskId);
				taskObject.put("dateCreation", dateCreation);
				taskObject.put("dateEnd", dateEnd);
				taskObject.put("dateDelivery", dateDelivery);
				taskObject.put("comment", comment);
				taskObject.put("employeeAsigned", employeeAsigned);
				break;
			case 3:
				break;
		}
		table.insert(taskObject);
	}

	public static void saveTrouble(int troubleId, String dateCreation,
			String employee, String comment, int type) {
		DBCollection table = MongoDBUtils.db.getCollection("trouble");
		BasicDBObject troubleObject = new BasicDBObject();
		switch (type) {
			case 0:
				troubleObject.put("taskId", troubleId);
				troubleObject.put("dateCreation", dateCreation);
				troubleObject.put("dateEnd", employee);
				troubleObject.put("dateDelivery", comment);
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
		}
		table.insert(troubleObject);
	}

	public static void updateEmployee(DBObject oldEmployee, DBObject newEmployee) {
		setCollection("employee");
		coll.update(oldEmployee, newEmployee);
	}

}
