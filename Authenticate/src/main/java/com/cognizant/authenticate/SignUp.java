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
import com.cognizant.authenticate.entity.Users;
import com.cognizant.authenticate.service.UsersService;

impo

@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsersService uServ;
	
	public void init(ServletConfig config) throws ServletException{
		try {
			uServ = ServiceFactory.getUserService();
		}catch(Exception ex) {
			}
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name;
		String username;
		String password;
		String  email;
		String confirmPassword;
		Users user = new Users();
		name=request.getParameter("name");
		username=request.getParameter("username");
		password=request.getParameter("password");
		email=request.getParameter("email");
		confirmPassword=request.getParameter("confirm_password");
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		response.setContentType("text/html");
		
		PrintWriter out= response.getWriter();
		if(password.equals(confirmPassword)) {
			try {
				if( uServ.signup(user)) {
					out.println("<p style=text-align:center;color:red;font-size:20px>you have successfully signed up</p>");
					out.println("<a href=newlogin.html><p style=text-align:center;color:red;font-size:20px>BACK TO LOGIN PAGE</p></a>");
					
				}
				else {
					out.println("<p style=text-align:center;color:red;font-size:20px>----THIS EMAIL OR USERNAME IS ALREADY WITH US ---</p>");
					out.println("<a href=newlogin.html><p style=text-align:center;color:red;font-size:20px>BACK TO LOGIN PAGE</p></a>");
					RequestDispatcher rd = request.getRequestDispatcher("signup.html");
					rd.include(request, response);
				}
				
			   
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			out.println("<p style=text-align:center;color:red;font-size:20px>passwords did not match try again</p>");
			out.println("<a href=newlogin.html><p style=text-align:center;color:red;font-size:20px>BACK TO LOGIN PAGE</p></a>");
			RequestDispatcher rd = request.getRequestDispatcher("signup.html");
			rd.include(request, response);
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
