package com.cognizant.authenticate.service;

import java.util.List;

import com.cognizant.authenticate.entity.Users;

public interface UsersService {
public boolean checkUser(Users user)throws Exception;
public boolean signup(Users user)throws Exception;
public boolean adminRights() throws  Exception;
public boolean checkemail(String s,String k)throws Exception;
public boolean checkAdmin(Users user) throws Exception;
public List<String> getdeactivated() throws Exception;
public boolean activateUser(String uname) throws Exception;
}