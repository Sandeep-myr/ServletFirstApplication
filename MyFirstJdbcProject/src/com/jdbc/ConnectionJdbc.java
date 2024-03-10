package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConnectionJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "spring";
		String password = "spring100";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
//			PreparedStatement pstmt = conn.prepareStatement("insert into namo values(?,?)");
////           ResultSet rs = pstmt.getResultSet();
//			Scanner sc  = new Scanner(System.in);
//			System.out.print("Enter the student id:");
//			int id = sc.nextInt();
//			sc.nextLine();
//			System.out.print("Enter student Name: ");
//			String studentName =sc.nextLine();
//			pstmt.setInt(1, id);
//			pstmt.setString(2, studentName);
//			pstmt.executeUpdate();
//			System.out.println("Data Inserted Dynimacally");
			
		PreparedStatement preparedStatement = conn.prepareStatement("select * from namo");
		ResultSet rs = preparedStatement.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		for(int i=1;i<=columnCount;i++) {
			System.out.print(metaData.getColumnName(i)+"\t");
		}
		System.out.println();
		while(rs.next()) {
			for(int i=1;i<=columnCount;i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
				
		}
		
		
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
