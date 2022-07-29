package com.facebook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;

public class ViewAllProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacebookServiceInterface fs=new FacebookService();
		List<FacebookUser> ll=fs.viewAllProfileService();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(ll.size()>0) {
				out.println(ll.size()+" record found in database<br><br>");
				
				for(FacebookUser fu:ll) {
					out.println("************************<br><br>");
					out.println("Name is "+fu.getName());
					out.println("<br>Password is "+fu.getPassword());
					out.println("<br>Email is "+fu.getEmail());
					out.println("<br>Address is "+fu.getAddress());
				}
			}
			else {
				out.println("no record are available in database");
			}
		out.println("</body></html>");
	}

}














