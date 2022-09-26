package com.cognizant.authenticate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.authenticate.config.ServiceFactory;
import com.cognizant.authenticate.service.UsersService;

@WebServlet("/forgotpwd")
public class ForgotPassWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private UsersService uServ;
	
	public void init(ServletConfig config) throws ServletException{
		try {
			uServ = ServiceFactory.getUserService();
		}catch(Exception ex) {}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String newpwd=request.getParameter("newpassword");
		try {
			if(uServ.checkemail(email,newpwd)) {
				out.println("<p style=text-align:center;color:red;font-size:20px>Password changed Successffully</p>");
				out.println("<a href=newlogin.html><p style=text-align:center;color:red;font-size:20px>BACK TO LOGIN PAGE</p></a>");
				
			}
			else {
				out.println("<p style=text-align:center;color:red;font-size:20px>this email is not registerd with us -----try again</p>");
				out.println("<a href=newlogin.html><p style=text-align:center;color:red;font-size:20px>BACK TO LOGIN PAGE</p></a>");
				RequestDispatcher rd= request.getRequestDispatcher("forgotpassword");
				rd.include(request,response);
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
