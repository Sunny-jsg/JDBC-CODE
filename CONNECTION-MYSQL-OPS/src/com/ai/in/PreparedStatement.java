package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;

public class PreparedStatement {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";

	private static final String INSERT_SQL = "INSERT INTO 	BOOKS VALUES(?,?,?) ";

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		java.sql.PreparedStatement ps = con.prepareStatement(INSERT_SQL);
		ps.setInt(1, 104);
		ps.setString(2, "AWS");
		ps.setDouble(3, 550.00);
		int count = ps.executeUpdate();
		System.out.println("Rows Effect ::" + count);
		con.close();

	}

}
