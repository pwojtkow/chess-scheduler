package com.capgemini.chess.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.to.UserProfileTo;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserProfileTo readUser(long id) {

		return new UserProfileTo();
	}
}
