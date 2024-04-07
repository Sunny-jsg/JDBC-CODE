package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchEmps {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER DEPT:: ");
		String Dept = sc.next();
		System.out.println("ENTER WORKLOCATION");
		String worklocation = sc.next();
		System.out.println("ENTER GENDER");
		String gender = sc.next();
		StringBuilder sql = new StringBuilder(" SELECT * FROM EMPLOYEE WHERE 1=1 ");
		if (Dept != null && !Dept.equals("null")) {
			sql.append(" AND EMP_DEPT =? ");

		}
		if (worklocation != null && !worklocation.equals("null")) {
			sql.append(" AND WORK_LOCATION =? ");
		}
		if (gender != null && !gender.equals("null")) {
			sql.append(" AND EMP_GENDER = ? ");
		}
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		PreparedStatement ps = con.prepareStatement(sql.toString());
		int index = 1;
		if (Dept != null && !Dept.equals("null")) {
			ps.setString(index, Dept);
			index++;
		}
		if (worklocation != null && !worklocation.equals("null")) {
			ps.setString(index, worklocation);
			index++;
		}
		if (gender != null && !gender.equals("null")) {
			ps.setString(index, gender);
		}
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			;
		System.out.println(rs.getInt(1) + "--" + rs.getString(2) + "--" + rs.getInt(3) + "--" + rs.getString(4) + "--"
				+ rs.getString(5) + "--" + rs.getString(6));
		}
		con.close();
	}

}
