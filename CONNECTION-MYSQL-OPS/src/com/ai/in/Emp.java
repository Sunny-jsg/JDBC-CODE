package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Emp {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";

	private static final String READ_DATA = "SELECT  * FROM EMP INNER JOIN EMP_ADDRESS\r\n"
			+ "ON EMP.EMP_ID =EMP_ADDRESS.EMP_ID\r\n" + "WHERE EMP_ADDRESS.EMP_ID =?";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ENTER EMP_ID ::");
		int id = sc.nextInt();
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		PreparedStatement ps = con.prepareStatement(READ_DATA);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getDouble(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));

		}
		con.close();
	}

}
