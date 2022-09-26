package com.cognizant.authenticate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ButtonGroup;

import com.cognizant.authenticate.config.ServiceFactory;
import com.cognizant.authenticate.entity.Users;
import com.cognizant.authenticate.service.UsersService;




@WebServlet("/First")
public class FirstPage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private UsersService uServ;
	
	public void init(ServletConfig config) throws ServletException{
		try {
			uServ = ServiceFactory.getUserService();
		}catch(Exception ex) {}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the form data (user details)
		
		String adus=request.getParameter("adus");
		String uid = request.getParameter("txt_uid");
		String pwd = request.getParameter("txt_pwd");
		Users user = new Users();
		user.setUsername(uid);
		user.setPassword(pwd);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(adus.equalsIgnoreCase("admin")) {
			try {
				if(uServ.checkAdmin(user)) {
					List<String> deactive=uServ.getdeactivated();
					request.setAttribute("admins",deactive);
					RequestDispatcher rd= request.getRequestDispatcher("admin.jsp");
					out.println("<a href=admin>Activate Users</a>");
					out.println("<a href=newlogin.html>LOG OUT</a>");
					rd.forward(request, response);
				}
				else {
					out.println("<p style=text-align:right;color:green;font-size:20px>YOU ARE NOT AN ADMIN</p>");
					RequestDispatcher rd = request.getRequestDispatcher("newlogin.html");
					//out.println("YOU ARE NOT AN ADMIN");
					rd.forward(request, response);
					
				}
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		else {
		try {
			boolean userStatus = uServ.checkUser(user);
			if(userStatus) {
				RequestDispatcher rd = request.getRequestDispatcher("welcome");
				rd.forward(request, response);
			}else {
				
				
				out.println("<p style=text-align:center;color:red;font-size:20px>Invalid User Name/ Password</p>");
				
				RequestDispatcher rd = request.getRequestDispatcher("newlogin.html");
				rd.include(request, response);				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
