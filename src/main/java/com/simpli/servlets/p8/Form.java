package com.simpli.servlets.p8;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<h2>Welcome to the university, you have enrolled successfully</h2>");
		String name = req.getParameter("user_name");
		String s1 = req.getParameter("user_age");
		int age = Integer.parseInt(s1);
		String gender = req.getParameter("user_gender");
		String city = req.getParameter("user_city");
		String course = req.getParameter("user_course");
		
		String cond = req.getParameter("condition");
		
		if(cond!=null) {
		if(cond.equals("checked")) {
			writer.println("<h3>Name: " + name +"</h3>");
			writer.println("<h3>Age: " + age +"</h3>");
			writer.println("<h3>Gender: " + gender +"</h3>");
			writer.println("<h3>Current city: " + city +"</h3>");
			writer.println("<h3>Selected course: " + course +"</h3>");
		}
		else if(cond.equals(null)) {
			writer.println("<h3>You have not agreed to the terms and condition</h3>");
		}
		}
		else {
			writer.println("<h3>You have not agreed to the terms and condition</h3>");
		}
	}
}
