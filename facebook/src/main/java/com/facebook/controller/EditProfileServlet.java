package com.facebook.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;


public class EditProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		String email=s.getAttribute("userid").toString();
		
		FacebookUser fb=new FacebookUser();
		fb.setEmail(email);
		
		FacebookServiceInterface fs=new FacebookService();
		FacebookUser fu=fs.viewProfileService(fb);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(fu!=null) {
				out.println("Edit Profile Page <br>");
				out.println("<form action=http://localhost:8080/facebook/EditRealProfile method=post>");
				out.println("Name: <input type=text name=nm value="+fu.getName()+">");
				out.println("<br>Password: <input type=text name=pwd value="+fu.getPassword()+">");
				out.println("<br>Email: <input type=email name=em value= "+fu.getEmail()+">");
				out.println("<br>Address: <input type=text name=ad  value= "+fu.getAddress()+">");
				out.println("<br><input type=submit value=edit");
				out.println("</form>");
				
			}
			else {
				out.println("profile not found");
			}
	}

}
