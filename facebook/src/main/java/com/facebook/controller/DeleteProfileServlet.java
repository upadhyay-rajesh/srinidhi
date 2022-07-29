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


public class DeleteProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		String email=s.getAttribute("userid").toString();
		
		FacebookUser fb=new FacebookUser();
		fb.setEmail(email);
		
		FacebookServiceInterface fs=new FacebookService();
		int i=fs.deleteProfileService(fb);
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
				out.println(" record deleted ");
				
				
			}
			else {
				out.println("could not delete record");
			}
		out.println("</body></html>");
	}

}
