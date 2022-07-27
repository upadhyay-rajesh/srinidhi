package com.facebook.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;


public class RegisterServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("nm");
		String password=request.getParameter("pwd");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		
		//always we must transfer data to other layer using DTO(data transfer object) design pattern
		//object of which class ?
		//object of entity class
		
		FacebookUser fb=new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		FacebookServiceInterface fs=new FacebookService();
		int i=fs.createProfileService(fb);
		
		
		
		
		//String aa[]=request.getParameterValues("hob");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		out.println("<html><body>");
			if(i>0) {
				out.println("Profile created Successfully <a href=login.html>Click here</a> to login");
			}
			else {
				out.println("could not create profile");
			}
		out.println("</body></html>");
		
	}
	
	
}
