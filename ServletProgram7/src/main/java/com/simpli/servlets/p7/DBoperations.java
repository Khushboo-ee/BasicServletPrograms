package com.simpli.servlets.p7;

import java.io.IOException;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBoperations extends HttpServlet{
	
	private String url = "jdbc:mysql://localhost:3306/dboperations";
	private String user ="root";
	private String pwd ="root";
	 Connection con;
	 PreparedStatement pstmt;
	
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		String s1 = req.getParameter("emp_id");
		int emp_id = Integer.parseInt(s1);
		String emp_name = req.getParameter("emp_name");
		String emp_comp = req.getParameter("emp_comp");
		String s2 = req.getParameter("emp_sal");
		int emp_sal = Integer.parseInt(s2);
		String s3 = req.getParameter("emp_exp");
		int emp_exp = Integer.parseInt(s3);
		resp.setContentType("text/html");
		int x;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection(url, user, pwd);
			String sql = "insert into employee values (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp_id);
			pstmt.setString(2, emp_name);
			pstmt.setString(3, emp_comp);
			pstmt.setInt(4, emp_sal);
			pstmt.setInt(5, emp_exp);
			x = pstmt.executeUpdate();
			if (x>0)
			{
				RequestDispatcher reqd1 = req.getRequestDispatcher("/success.html");
				reqd1.include(req, resp);
			}
			else {
				RequestDispatcher reqd2 = req.getRequestDispatcher("/fail.html");
				reqd2.include(req, resp);
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
