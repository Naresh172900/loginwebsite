<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.*"%>
 
 <head>
	<meta charset="ISO-8859-1">
	<title>Cognizant Login</title>
	<link rel="stylesheet" href="css/styles1.css"/>
</head>
<body>
<form action="admin" method="post">
<p style=text-align:center;color:white;font-size:20px>
<%
List <String> ls= new ArrayList<String>();

ls=(ArrayList<String>)request.getAttribute("list");

if(ls==null){
	ls=(ArrayList<String>)request.getAttribute("admins");
}
out.println("DEACTVE USERS ARE ::><br/>");
for(String st:ls){
	out.println(st+"<br/>");
}
ls=null;
out.println("enter an username ");
%>
</p>
	<table>
  	
  		<tr>
  		  <td>
  		  	<input type="text" name="uname" size="22" autofocus required placeholder="USER NAME"/>
  		  </td>	
  		</tr>
  		<tr>
  		  <td>
  		  	<a href="newlogin.html">LOG OUT</a>
  		  </td>	
  		</tr>
  		<tr>
  		  <td>
  		  	<input type="submit" value="Activate"/>
  		  </td>	
  		</tr>
  </table>
  </form>
  </body>
