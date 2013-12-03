package com.gestioempleats.utils;

public class ActualSession {
	private String user;
	private String password;
	private int level;

	public ActualSession() {
	}
	public ActualSession(String user, String password, int level) {
		this.user = user;
		this.password = password;
		this.level = level;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int hasPermission(int permissionID){
		return Permissions.hasPermission(this.level, permissionID);
	}
	
	public void showActualUser(){
		System.out.println("user" + this.user);
		System.out.println("password" + this.password);
		System.out.println("level" + this.level);
		
	}
}
