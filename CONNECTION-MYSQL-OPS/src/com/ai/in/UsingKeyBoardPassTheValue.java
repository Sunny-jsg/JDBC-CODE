package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UsingKeyBoardPassTheValue {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";

	private static final String INSERT_SQL = "INSERT INTO 	BOOKS VALUES(?,?,?) ";

	public static void main(String[] args) throws Exception {
		Scanner sc =new Scanner(System.in);
		System.out.println("ENTER THE ID");
		int ID = sc.nextInt();
		System.out.println("ENTER THE NAME");
		String NAME = sc.next();
		System.out.println("ENTER THE PRICE");
		double PRICE = sc.nextDouble();
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		PreparedStatement ps = con.prepareStatement(INSERT_SQL);
		ps.setInt(1, ID);
		ps.setString(2, NAME);
		ps.setDouble(3, PRICE);
		int count = ps.executeUpdate();
		System.out.println("rowsEffect ::"+count);
		con.close();

	}

}
