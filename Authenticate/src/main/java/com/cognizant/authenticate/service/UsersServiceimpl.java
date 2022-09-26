package com.cognizant.authenticate.service;

import java.util.List;

import com.cognizant.authenticate.Dao.UsersDao;
import com.cognizant.authenticate.Dao.UsersDaoimpl;
import com.cognizant.authenticate.entity.Users;

public class UsersServiceimpl implements UsersService {

	private UsersDao dao;
	public UsersServiceimpl(){
	dao=new UsersDaoimpl();
	}

	

	@Override
	public boolean checkUser(Users user) throws Exception {
		
		return dao.checkUser(user);
	}

	@Override
	public boolean signup(Users user) throws Exception {
		// TODO Auto-generated method stub
		return dao.signUp(user);
	}

	@Override
	public boolean adminRights() throws Exception {
		// TODO Auto-generated method stub
		return dao.adminRights();
	}



	@Override
	public boolean checkemail(String s,String n) throws Exception {
		
		return dao.checkemail(s,n);
	}



	@Override
	public boolean checkAdmin(Users user) throws Exception {
		
		return dao.checkAdmin( user);
	}



	@Override
	public List<String> getdeactivated() throws Exception {
		
		return dao.getdeactivated();
	}



	@Override
	public boolean activateUser(String uname) throws Exception {
		
		return dao.activateUser(uname);
	}

}
