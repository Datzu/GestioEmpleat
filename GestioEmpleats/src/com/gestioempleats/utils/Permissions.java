package com.gestioempleats.utils;

public final class Permissions {
	
	private final static int[][] permissionArray = new int[5][];
	
	/**
	 * @author Gerard, Adrian Garcia
	 * Clase que serveix de suport i configuracio de els permisos que utilitza el programa per consultar si es pot fer servir una cosa o no
	 */
	
	public final static void createPermissionArray() {
		// permissions array sets
		final int administratorArray[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		final int programmerArray[] =	 {0,1,0,0,1,0,0,1,1,0,1,0,1,1,1,1};
		final int secretaryArray[] =	 {1,0,1,1,0,0,1,0,1,1,0,0,1,1,1,1};
		final int internArray[] =		 {0,1,0,0,0,0,0,0,1,0,0,0,1,1,1,1};
		final int commercialArray[] =	 {0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,1};
		permissionArray[0] = administratorArray;
		permissionArray[1] = programmerArray;
		permissionArray[2] = secretaryArray;
		permissionArray[3] = internArray;
		permissionArray[4] = commercialArray;
	}

	public final static int hasPermission(int level, int permissionID) {
		return permissionArray[level][permissionID];
	}
	
	public final static void setPermission(int level, int permissionID, int perm) {
		permissionArray[level][permissionID] = perm;
	}
	
	public static void showPermissions() {
		for (int i=0; i<permissionArray.length; i++) {
			for (int j=0; j<permissionArray[i].length; j++) {
				System.out.print(permissionArray[i][j]);
			}
			System.out.println();
		}
	}
	
	// 0 - mostart empleat
	// 1 - mostart tasca
	// 2 - mostrar incidencia
	// 3 - modificar empleat
	// 4 - modificar tasca
	// 5 - modificar indicencia
	// 6 - nou empleat
	// 7 - nova tasca
	// 8 - nova incidencia
	// 9 - borrar empleat
	// 10 - borrar tasca
	// 11 - borrar incidencia
	// 12 - mostrar mateix empleat
	// 13 - entrar a settings
	// 14 - modificar perfil d'un mateix
	// 15 - sortir del programa
	
}
