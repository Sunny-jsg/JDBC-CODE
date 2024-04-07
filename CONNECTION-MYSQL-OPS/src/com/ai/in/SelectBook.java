package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectBook {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "sunny";
	private static final String DB_PWD = "PHW#84#jeor";
	private static final String SELECT_SQL = "SELECT *FROM BOOKS WHERE ID=101";

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(SELECT_SQL);
		if (rs.next()) {
			int book_id = rs.getInt("id");
			String Book_name = rs.getString("name");
			double book_price = rs.getDouble("price");
			System.out.println(book_id);
			System.out.println(Book_name);
			System.out.println(book_price);
		}else {
			System.out.println("No Record Found");
		}
		con.close();
	}

}
