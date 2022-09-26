package com.cognizant.authenticate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>Cognizant</title></head>");
		out.println("<body style=text-align:center;background-color:lightgreen>");
		out.println("<img src=images/cts.png>");
		out.println("<h2>Digital Solutions to Advnace Your Business</h2>");
		out.println("<hr>");
		
		out.println("<p style=text-align:left;font-size:18>Hello, " + request.getParameter("txt_uid")+"</p>");
		out.println("<hr>");
		out.println("</body>");
		out.println("</html>");
		out.println("<a href=newlogin.html><p style=text-align:right;color:red;font-size:20px>LOG OUT</p></a>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
