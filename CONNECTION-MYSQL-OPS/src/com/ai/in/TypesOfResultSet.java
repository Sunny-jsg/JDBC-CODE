package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TypesOfResultSet {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "sunny";
	private static final String DB_PWD = "PHW#84#jeor";
	private static final String SELECT_SQL = "SELECT ID,NAME,PRICE FROM BOOKS";

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(SELECT_SQL);
		System.out.println("Query Execution Completed____Data Store In ResultSet");
		while (rs.next()) {
			System.in.read();
			System.in.read();
			 rs.refreshRow();
			                                                                                                                                                                                                                                                                                        
			                     

			System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getDouble(3));
		}
		con.close();
	}

}
