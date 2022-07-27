package com.facebook.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;



public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("em");      //request.getParameter is used to take data of html element based on name attribute
		String password=request.getParameter("pwd");
		
		//above email and password must go to service in form of object because of DTO design pattern as below
		
		FacebookUser fb=new FacebookUser();
		fb.setEmail(email);
		fb.setPassword(password);
		
		FacebookServiceInterface fs=new FacebookService();
		boolean b=fs.checkLogin(fb);
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(b) {
				//if one servlet want to share information with other servlet then it can using HttpSession as below
				HttpSession s=request.getSession(true);  //creating session
				//s.setMaxInactiveInterval(5);             //here session will be valid for 5 minutes
				s.setAttribute("userid", email);         // sharing information inside session
				
				
				out.println("Welcome "+email);
				out.println("<br><a href=ViewProfileServlet>view profile</a>");
				out.println("<br><a href=DeleteProfileServlet>delete profile</a>");
				out.println("<br><a href=EditProfileServlet>Edit profile</a>");
				out.println("<br><a href=ViewAllProfileServlet>view all profile</a>");
				
			}
			else {
				out.println("Invalid ID and password");
				
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
				rd.include(request, response);;
			}
	}

}















