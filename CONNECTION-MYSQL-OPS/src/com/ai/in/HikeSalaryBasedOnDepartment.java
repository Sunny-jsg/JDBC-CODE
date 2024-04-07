package com.ai.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class HikeSalaryBasedOnDepartment {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "sunny";

	private static final String DB_PWD = "PHW#84#jeor";
	private static final String SELECT_SQL = " SELECT * FROM EMPLOYEE ";
	private static final String UPDATE_SQL = " UPDATE EMPLOYEE SET EMP_SALARY = EMP_SALARY +( EMP_SALARY * ? ) /100  WHERE EMP_DEPT = ? ";
/* if we have 500 dept in the company then our java program should communicate with database 500 times to execute 500 query 
 * it is not at all recommended becaUSE it will decrease perform of the application .
 * note:: if we have so many database call from java then network traffic will increase between java and database .which will reduce performance of the application.
 * to avoid this problem we need to write the business logic  at the database by using procedure.
 * procedure means a database which will have set of sql statement to performance one or more operation.
 * from the java application we will call the procedure then procedure will execute the database will complete the operation.=
 * 
 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER EMP HIKE FOR HR DEPT ::");
		double hrdepthike = sc.nextDouble();
		System.out.println("ENTER EMP HIKE FOR SALES DEPT ::");
		double salesdepthike = sc.nextDouble();
		System.out.println("ENTER EMP HIKE FOR ADMIN DEPT ::");
		double admindepthike = sc.nextDouble();
		System.out.println("ENTER EMP HIKE FOR SECURITY DEPT ::");
		double securitydepthike = sc.nextDouble();
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
		ps.setDouble(1, hrdepthike );
		ps.setString(2, "HR");
		ps.executeUpdate();
		ps.setDouble(1, salesdepthike );
		ps.setString(2, "SALES");
		ps.executeUpdate();
		ps.setDouble(1, admindepthike );
		ps.setString(2, "ADMIN");
		ps.executeUpdate();
		ps.setDouble(1, salesdepthike );
		ps.setString(2, "SECURITY");
		ps.executeUpdate();
		System.out.println("completed update -------");
		con.close();
		
	}

}
