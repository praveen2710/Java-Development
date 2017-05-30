package com.bebetteratjava.javaadvanced.singletondp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {

	public static void main (String arg []) {
		
		long timeBefore = 0;
		long timeAfter = 0;
		
		DbSingleton instance = DbSingleton.getInstance();
		
		timeBefore = System.currentTimeMillis();
		Connection conn = instance.getConnection();
		timeAfter = System.currentTimeMillis();

		System.out.println(timeAfter - timeBefore);

		try(Statement sta = conn.createStatement();) {

			int count = sta
					.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20),"
							+ " City VARCHAR(20))");
			System.out.println("Table created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//This shows the improvement in performance by using singleton pattern
		timeBefore = System.currentTimeMillis();
		conn = instance.getConnection();
		timeAfter = System.currentTimeMillis();
		
		System.out.println(timeAfter - timeBefore);
		
	}
	
}
