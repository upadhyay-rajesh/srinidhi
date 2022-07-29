package com.facebook.service;

import java.util.List;

import com.facebook.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fb);

	boolean checkLogin(FacebookUser fb);

	FacebookUser viewProfileService(FacebookUser fb);

	List<FacebookUser> viewAllProfileService();

	int deleteProfileService(FacebookUser fb);

	int editProfileService(FacebookUser fb);

}
