package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Welcome extends GenericServlet {
	private static final long serialVersionUID = 1L;

    public Welcome() {
        // TODO Auto-generated constructor stub
    }

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	  System.out.println("fcgbhjnk");
		String id = request.getParameter("studentId");
	  String name = request.getParameter("studentName");
		PrintWriter printWriter = response.getWriter();
	  printWriter.println("<html><body bgcolor=yellow  text=red><center><h1>Hello "+name+"Your Id is "+id+"</h1></center></body></html>");
	}

}
