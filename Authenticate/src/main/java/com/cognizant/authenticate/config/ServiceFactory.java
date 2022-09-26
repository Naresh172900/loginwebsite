package com.cognizant.authenticate.config;

import com.cognizant.authenticate.service.UsersService;
import com.cognizant.authenticate.service.UsersServiceimpl;

public class ServiceFactory {

	private static UsersService service;
	public static UsersService getUserService() throws Exception{
		if(service == null)
			service = new UsersServiceimpl();
		
		return service;
	}
}
	

