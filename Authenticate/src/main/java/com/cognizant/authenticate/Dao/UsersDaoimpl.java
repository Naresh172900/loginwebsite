package com.cognizant.authenticate.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.authenticate.config.ConnectionFactory;
import com.cognizant.authenticate.entity.Users;

public class UsersDaoimpl implements UsersDao {
	private static Connection con=null;
	//private static PreparedStatement pst=null;
	private static Statement st=null;
	String s;
	public UsersDaoimpl() {
		try {
				con=ConnectionFactory.getDBConnection();
		//pst = con.prepareStatement("select * from users where username=? and password=?");
				st=con.createStatement();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}

	@Override
	public boolean checkUser(Users user) throws Exception {
		s="select * from user where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		ResultSet rs=st.executeQuery(s);
		if(rs.next()) {
			System.out.println("retruning true");
			return true;
		}
		System.out.println("returning fslse");
		return false;
	}

	@Override
	public boolean signUp(Users user) throws Exception {
		try {
		s="insert into User(name,username,password,email,active,role)values('"+user.getName()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getActive()+"','"+user.getRole()+"')";
		int x=st.executeUpdate(s);
		if(x!=0) {
			return true;
		}}catch(SQLIntegrityConstraintViolationException ex) {
			return false;
		}
		return false;
	}

	@Override
	public boolean adminRights() throws Exception {
		s="update user set active='y' where active='n'";
		int x=st.executeUpdate(s);
		if(x!=0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkemail(String e,String n) throws Exception {
		s="select * from user where email='"+e+"'";
		ResultSet rs=st.executeQuery(s);
	    if(rs.next()) {
			s="update user set password= '"+n+"' where email= '"+e+"'";
			if(st.executeUpdate(s)==0)
			{
				return false;
			}
			return true;
		}
			return false;
			
		
	}

	

	@Override
	public List<String> getdeactivated() throws Exception {
		s="select * from user where active='n'";
		List<String> ls= new ArrayList<String>();
		ResultSet rs=st.executeQuery(s);
		while(rs.next()) {
			String u= new String();
			u=rs.getString(2);
			ls.add(u);
		}
		return ls;
	}

	
		@Override
		public boolean checkAdmin(Users user) throws Exception {
			s="select * from user where username= '"+user.getUsername()+"' and password='"+user.getPassword()+"'";
			ResultSet rs=st.executeQuery(s);
			if(rs.next()) {
				if(rs.getString(6).equalsIgnoreCase("admin")) {
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean activateUser(String uname) throws Exception {
			s="update user set active='y' where username='"+uname+"'";
			int x=st.executeUpdate(s);
			if(x==0) {
				return false;
			}
			return true;
		}

}
