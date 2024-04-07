package com.ai.in;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProcedureWithInParameter {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";
	private static final String SELECT_QUERY = " call getbooksbyids(?)";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER BOOK_ID ::");
		int Book_id = sc.nextInt();
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		CallableStatement cs = con.prepareCall(SELECT_QUERY);
		cs.setInt(1, Book_id);
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "-" + rs.getString(2) + "-" + rs.getDouble(3));
		}
		con.close();

	}

}
