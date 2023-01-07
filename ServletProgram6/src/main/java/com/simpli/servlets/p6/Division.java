package com.simpli.servlets.p6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class Division extends HttpServlet {
	public void service(ServletRequest req,ServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String s1 = req.getParameter("num1");
			int num1 = Integer.parseInt(s1);
		String s2 = req.getParameter("num2");
			int num2 = Integer.parseInt(s2);
		int res3 = num1/num2;
		int res2 = (int)req.getAttribute("res2");
		int res1 = (int)req.getAttribute("res1");
		
		writer.println("Sum of both the numbers is: "+ res1);
		writer.println("<br>");
		writer.println("Multiplication of both the numbers is: "+ res2);
		writer.println("<br>");
		writer.println("Division of number 1 by number 2 is: "+ res3);
	}
}
