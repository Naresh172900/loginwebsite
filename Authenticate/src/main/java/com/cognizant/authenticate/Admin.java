package com.cognizant.authenticate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.authenticate.config.ServiceFactory;
import com.cognizant.authenticate.service.UsersService;

@WebServlet("/admin")
public class Admin extends HttpServlet {
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
		String uname;
		uname=request.getParameter("uname");
		List<String> ls=new ArrayList<String>();
		try {
			if(uServ.activateUser(uname))
			{
				out.println("<p style=text-align:center;color:red;font-size:20px>USER ACTIVATION SUCCESSFULL</p>");
				ls=uServ.getdeactivated();
				request.setAttribute("list", ls);
				RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
				
			}
			else {
				out.println("<p style=text-align:center;color:red;font-size:20px>USER ACTIVATION UNSUCCESSFULL</p>");
				ls=uServ.getdeactivated();
				request.setAttribute("list", ls);
				RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
