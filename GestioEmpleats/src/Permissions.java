
public final class Permissions {
	
	private final static int[][] permissionArray = new int[5][];
	
	public final static void createPermissionArray() {
		// permissions array sets
		final int administratorArray[] = {1,1,1,1,1,1,1,1,1,1,1,1,1};
		final int programmerArray[] =	 {0,0,0,0,0,0,0,0,0,0,0,0,0};
		final int secretaryArray[] =	 {0,0,0,0,0,0,0,0,0,0,0,0,0};
		final int internArray[] =		 {0,0,0,0,0,0,0,0,0,0,0,0,0};
		final int commercialArray[] =	 {0,0,0,0,0,0,0,0,0,0,0,0,0};
		permissionArray[0] = administratorArray;
		permissionArray[1] = programmerArray;
		permissionArray[2] = secretaryArray;
		permissionArray[3] = internArray;
		permissionArray[4] = commercialArray;
	}

	public final static int hasPermission(int level, int permissionID) {
		return permissionArray[level][permissionID];
	}	
	
	// 0 - 
	// 1 - 
	// 2 - 
	// 3 - 
	// 4 - 
	// 5 - 
	// 6 - 
	// 7 - 
	// 8 - 
	// 9 - 
	// 10 - 
	// 11 - 
	// 12 - 
	// 13 -
	
}
