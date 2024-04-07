package com.ai.in;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class ProcedureWithInOutParameter {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";
	private static final String SELECT_QUERY = " CALL getbookpricebybookname(?, ?)";

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
		System.out.print("Enter Book Price :: ");
		double bookPrice = s.nextDouble();

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		CallableStatement cstmt = con.prepareCall(SELECT_QUERY);
		cstmt.setDouble(1, bookPrice);
		cstmt.registerOutParameter(2, Types.VARCHAR);

		ResultSet rs = cstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		con.close();
	}

}
