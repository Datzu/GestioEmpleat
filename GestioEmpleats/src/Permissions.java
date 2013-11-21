
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
	
	// 0 - ID0
	// 1 - ID1
	// 2 - ID2
	// 3 - ID3
	// 4 - ID4
	// 5 - ID5
	// 6 - ID6
	// 7 - ID7
	// 8 - ID8
	// 9 - ID9
	// 10 - ID10
	// 11 - ID11
	// 12 - ID12
	// 13 - ID13
	
}
