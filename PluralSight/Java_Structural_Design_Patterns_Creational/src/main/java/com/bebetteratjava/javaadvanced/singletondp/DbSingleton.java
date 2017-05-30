package com.bebetteratjava.javaadvanced.singletondp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

	private static DbSingleton instance = null;
	
	private Connection conn = null;
	
	private DbSingleton () {
		//register a driver for database
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DbSingleton getInstance() {
		//This will make sure we don't try to synchronize if instance exists.
		if(instance == null) {
			synchronized(DbSingleton.class) {
				//This one verifies that in the time synchronization was being enforced
				//no thread went ahead and created an instance
				if (instance == null) {
					instance = new DbSingleton();
				}
			}
		}
		
		return instance;
	}

	/**
	 * 	This is not static since this should only be called once we have instance of {@link DbSingleton}
	 */
	public Connection getConnection() {
		if(conn == null) {
			synchronized (DbSingleton.class) {
				if(conn == null) {
					try {
						String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
						
						conn = DriverManager.getConnection(dbUrl);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return conn;
	}
	
}
