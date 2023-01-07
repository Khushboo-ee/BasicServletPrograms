package com.simpli.servlets.p6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class Addition extends HttpServlet {
	public void service(ServletRequest req,ServletResponse resp) throws ServletException,IOException{
		
		String s1 = req.getParameter("num1");
			int num1 = Integer.parseInt(s1);
		String s2 = req.getParameter("num2");
			int num2 = Integer.parseInt(s2);
		int res = num1+num2;
		
		req.setAttribute("res1", res);
		RequestDispatcher reqd = req.getRequestDispatcher("/mul");
		reqd.forward(req, resp);
	}
	
}
