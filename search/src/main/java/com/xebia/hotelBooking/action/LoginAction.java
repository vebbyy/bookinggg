package com.xebia.hotelBooking.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.security.Credentials;

import com.xebia.hotelBooking.service.LoginService;

@Name("loginAction")
public class LoginAction {

	@In
	private Credentials credentials;

	@In
	private LoginService loginService;

	@In
	private FacesMessages facesMessages;
	
	

	public boolean verifyLogin() {

		
		if (loginService.getUserForLoginVerification(credentials.getUsername(),
				credentials.getPassword()) == null) {
			facesMessages.addToControl("userName","Username or Password incorrect");
			
			return false;
		} else {
			return true;
		}

	}

}
