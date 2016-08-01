package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.exceptions.ChallengesOutOfLimitException;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.service.ChallengeService;

@Service
public class ChallengeServiceImpl implements ChallengeService {
	
	@Autowired
	ChallengeDao challengeDao;

	@Override
	public void sendChallange(long userId) throws ChallengesOutOfLimitException, UserNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptChallange(long challengeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void declineChallange(long challengeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancleSendChallenge(long id_challenge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateChallengeList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int howManyActiveChallenges(long userId) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	
}
