package com.cognizant.authenticate.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionFactory{
	
private static Connection db_con = null;
	
	public static Connection getDBConnection() throws Exception{
		if(db_con == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("com/cognizant/authenticate/config/db_configs");
			
			String dc = bundle.getString("jdbc.driver-class");
			String url = bundle.getString("jdbc.url");
			String uname = bundle.getString("jdbc.username");
			String pass = bundle.getString("jdbc.password");
			
			Class.forName(dc);
			db_con = DriverManager.getConnection(url, uname, pass);
		}
		return db_con;
	}
}
