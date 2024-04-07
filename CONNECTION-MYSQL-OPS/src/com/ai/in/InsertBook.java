package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertBook {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "sunny";
	private static final String DB_PWD = "PHW#84#jeor";
	private static final String INSERT_SQL = "INSERT INTO BOOK VALUES(103,'C++',1000)";

	public static void main(String[] args) throws Exception {
		// step-1::load Driver;
		Class.forName("com.mysql.cj.jdbc.Driver");
		// step-2::get DB connection;
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		// step-3::create statement
		Statement stmt = con.createStatement();
		// step-4::execute query
		int rowsEffected = stmt.executeUpdate(INSERT_SQL);
		// step-5 process result
		System.out.println("Record Inserted count:: " + rowsEffected);
		// step-6:: close connection
		con.close();

	}

}
