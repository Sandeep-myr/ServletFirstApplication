package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registration() {
        super();

    }

    public Connection conn=null;
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","spring","spring100");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void destroy() {
	if(conn!=null) {
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname= request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email= request.getParameter("email");
		String mob = request.getParameter("mob");
		String address = request.getParameter("address");
	 try {
		PreparedStatement pstmt = conn.prepareStatement("insert into namo2 values(?,?,?,?,?)");
	    pstmt.setString(1, fname);
	    pstmt.setString(2, lname);
	    pstmt.setString(3, email);
	    pstmt.setLong(4, Long.parseLong(mob));
	    pstmt.setString(5, address);
	    pstmt.executeUpdate();
	    RequestDispatcher rd = request.getRequestDispatcher("/success.html");
	    rd.forward(request, response);
	 } catch (SQLException e) {
		
		e.printStackTrace();
	}
	 
		
	}

}
