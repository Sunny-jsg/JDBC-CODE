package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/* with the above  code in single shot be can update all the employee salary 
 * because business logic will execute at database.
 */
public class OverComeHikeProblem {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";
	private static final String SELECT_SQL = " SELECT * FROM EMPLOYEE ";
	private static final String UPDATE_SQL = " UPDATE EMPLOYEE SET EMP_SALARY = EMP_SALARY +( EMP_SALARY * ? ) /100 ";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER HIKE :: ");
		double hike = sc.nextDouble();
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
		ps.setDouble(1, hike);
		int rowsEffect = ps.executeUpdate();
		System.out.println(" UPDATE COMPLETED -----");
		con.close();
	}

}
