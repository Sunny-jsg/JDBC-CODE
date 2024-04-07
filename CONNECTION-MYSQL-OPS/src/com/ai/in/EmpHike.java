package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/* In the above program we implemented the logic of java side to increase the salary of the employee for every employee 
   one update query will execute query to update salary with hike. if we have one lakh record in the table then one lakh time 
    update query will execute .if we have one crore then one crore time update query will execute .which will decrease performance of the application.  */

public class EmpHike {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";
	private static final String SELECT_SQL = " SELECT * FROM EMPLOYEE ";
	private static final String UPDATE_SQL = " UPDATE EMPLOYEE SET EMP_SALARY = ? WHERE EMP_ID =? ";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER THE HIKE ");
		double hike = sc.nextDouble();
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_SQL);
		PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
		while (rs.next()) {
			int emp_id = rs.getInt("EMP_ID");
			double existingsal = rs.getDouble("EMP_SALARY");
			double new_sal = existingsal + (existingsal * hike) / 100;
			ps.setDouble(1, new_sal);
			ps.setInt(2, emp_id);
			ps.executeUpdate();
		}
		System.out.println("UPDATE COMPLETED ------");
		con.close();
	}

}
