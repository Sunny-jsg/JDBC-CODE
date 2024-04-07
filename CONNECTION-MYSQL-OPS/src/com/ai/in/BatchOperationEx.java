package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchOperationEx {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Statement stmt = con.createStatement();
		stmt.addBatch("INSERT INTO BOOKS VALUES (106 ,'AWS', 2400) ");
		stmt.addBatch("INSERT INTO BOOKS VALUES (107 ,'DSA', 2200)");
		stmt.addBatch("INSERT INTO BOOKS VALUES (108 ,'HTML', 3200)");
		stmt.addBatch("INSERT INTO BOOKS VALUES (109 ,'CSS', 2300) ");
		stmt.addBatch("INSERT INTO BOOKS VALUES (110 ,'JS', 1400) ");
		int[] count = stmt.executeBatch();
		System.out.println("RECORD INSERTED" + count.length);
		con.close();
		System.out.println("EXECUTION COMPLETED -----");

	}
}
