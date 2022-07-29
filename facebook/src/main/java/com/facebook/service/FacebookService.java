package com.facebook.service;

import java.util.List;

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

	@Override
	public List<FacebookUser> viewAllProfileService() {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.viewAllProfileDAO();
	}

	@Override
	public int deleteProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.deleteProfileDAO(fb);
	}

	@Override
	public int editProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.editProfileDAO(fb);
	}

}
