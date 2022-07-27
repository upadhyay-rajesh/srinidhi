package com.facebook.service;

import com.facebook.dao.FacebookDAO;
import com.facebook.dao.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {

	public int createProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.createProfileDAO(fb);
	}

	@Override
	public boolean checkLogin(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.loginProfileDAO(fb);
	}

	@Override
	public FacebookUser viewProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.viewProfileDAO(fb);
	}

}
