package com.ai.in;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImageInDatabase {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";

	private static final String INSERT_VALUE = "INSERT INTO PERSON VALUES (?,?)";

	public static void main(String[] args) throws Exception, Exception {
		FileInputStream fis = new FileInputStream("D:\\IMG-20240309-WA0009_1.jpg\\");
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		PreparedStatement ps = con.prepareStatement(INSERT_VALUE);
		ps.setString(1, " SUNNY YADAV");
		ps.setBinaryStream(2, fis);
		int count = ps.executeUpdate();
		System.out.println("Rows Effect ::" + count);
		con.close();
	}
}
