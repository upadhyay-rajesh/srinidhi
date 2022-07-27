package com.facebook.service;

import com.facebook.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fb);

	boolean checkLogin(FacebookUser fb);

	FacebookUser viewProfileService(FacebookUser fb);

}
