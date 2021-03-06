package com.gestioempleats.utils;

import java.io.File;

public class Paths {

	private String pathToExe;
	private String pathToMongoDB;
	private String pathToDB;
	private String pathToBin;
	
	/**
	 * @author Adrian Garcia
	 * @param pathToExe path que apunta al mongod.exe
	 * @param pathToMongoDB path que apunta a la carpeta que conte mongoDB
	 * @param pathToDB path que apunta a on es la base de dades guardada
	 * @param pathToBin path que apunta a la carpeta bin de mongoDB
	 * Clase que serveis per configurar i guardar el paths del programa
	 */

	public Paths() {

	}

	public String getPathToExe() {
		return pathToExe;
	}

	public void setPathToExe(String path) {
		this.pathToExe = path;
	}

	public String getPathToMongoDB() {
		return pathToMongoDB;
	}

	public void setPathToMongoDB(String path) {
		this.pathToMongoDB = path;
	}

	public String getPathToDB() {
		return pathToDB;
	}

	public void setPathToDB(String path) {
		this.pathToDB = path;
	}
	
	public String getPathToBin() {
		return pathToBin;
	}

	public void setPathToBin(String path) {
		this.pathToBin = path;
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

}
