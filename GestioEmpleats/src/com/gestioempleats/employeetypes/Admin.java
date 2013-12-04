package com.gestioempleats.employeetypes;

import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;

import com.gestioempleats.utils.MongoDBUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Admin implements DBObject {
	
	private String user;
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(String user, String password) {
		this.user = user;
		this.password = password;
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
	
	public void set(String[] data) {
		this.user = data[0];
		this.password = data[1];
	}
	
	public void show() {
		System.out.println("Admin info:");
		System.out.println(this.user);
		System.out.println(this.password);
	}
	
	public void saveToMongo() {
		DBCollection table = MongoDBUtils.db.getCollection("employee");
		BasicDBObject adminObject = new BasicDBObject();
		adminObject.put("user", this.user);
		adminObject.put("password", this.password);
		adminObject.put("level", 0);
		table.insert(adminObject);
	}

	@Override
	public boolean containsField(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(BSONObject arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putAll(Map arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object removeField(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map toMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPartialObject() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void markAsPartialObject() {
		// TODO Auto-generated method stub
		
	}

}
