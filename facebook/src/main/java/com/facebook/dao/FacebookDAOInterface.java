package com.facebook.dao;

import java.util.List;

import com.facebook.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fb);

	boolean loginProfileDAO(FacebookUser fb);

	FacebookUser viewProfileDAO(FacebookUser fb);

	List<FacebookUser> viewAllProfileDAO();

	int deleteProfileDAO(FacebookUser fb);

	int editProfileDAO(FacebookUser fb);

}
