package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserProfileTo;

public interface UserService {
	
	/**
	 * @param userId - user id which profile needed to be return
	 * @return Whole user profile
	 */
	public UserProfileTo readUser(long userId);
	
}
