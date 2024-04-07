package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Demo {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";

	private static final String SELECT_SQL = "SELECT * FROM BOOKS";

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(SELECT_SQL);
		ResultSetMetaData metaData = rs.getMetaData();
		System.out.println("Count Column:: " + metaData.getColumnCount());
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			String columnClassName = metaData.getColumnClassName(i);
			System.out.println(columnClassName);
		}
		con.close();

	}
}
