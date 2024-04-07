package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDataInTwoTable {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";

	private static final String EMP_INSERT = "INSERT INTO EMP VALUES(?,?,?)";
	private static final String EMP_ADDR_INSERT = "INSERT INTO EMP_ADDRESS VALUES(?,?,?,?)";

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		// By Default conn - autoCommit mode is true

		con.setAutoCommit(false);

		try {
			PreparedStatement pstmt = con.prepareStatement(EMP_INSERT);
			pstmt.setInt(1, 106);
			pstmt.setString(2, "TIWARI");
			pstmt.setDouble(3, 20000.00);

			pstmt.executeUpdate();

			pstmt = con.prepareStatement(EMP_ADDR_INSERT);
			pstmt.setString(1, "MOTIHARI");
			pstmt.setString(2, "BIHAR");
			pstmt.setString(3, "India");
			pstmt.setInt(4, 106);

			pstmt.executeUpdate();

			con.commit();

			System.out.println("Records Inserted...");

		} catch (Exception e) {
			System.out.println("Transcation Rolled Back....");
			con.rollback();
		}
		con.close();
	}

}
