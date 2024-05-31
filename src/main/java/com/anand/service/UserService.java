package com.anand.service;

import com.anand.exceptions.UserException;
import com.anand.model.User;

public interface UserService {
	public User findUserProfileByJwt(String jwt) throws UserException;

}
