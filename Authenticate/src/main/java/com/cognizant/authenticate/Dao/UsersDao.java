package com.cognizant.authenticate.Dao;

import java.util.List;

import com.cognizant.authenticate.entity.Users;

public interface UsersDao {
	public boolean checkUser(Users user) throws Exception;
	public boolean signUp(Users user)throws Exception;
	public boolean adminRights() throws Exception;
	public boolean checkemail(String s,String n) throws Exception;
	public boolean checkAdmin(Users user) throws Exception;
	public List<String>getdeactivated()throws Exception;
	public boolean activateUser(String uname) throws Exception;

}
