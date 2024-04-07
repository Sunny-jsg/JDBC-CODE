package com.ashok.it;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadtheData {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getDBConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(" SELECT * FROM EMP ");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "--" + rs.getString(2) + "--" + rs.getDouble(3));
		}
		con.close();

	}
}
