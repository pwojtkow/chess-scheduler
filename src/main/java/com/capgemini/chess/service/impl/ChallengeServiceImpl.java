package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.service.ChallangeService;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class ChallengeServiceImpl implements ChallangeService {
	
	@Autowired
	ChallengeDao challengeDao;

	@Override
	public void sendChallange(UserProfileTO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptChallange(ChallengeTO challenge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void declineChallange(ChallengeTO challenge) {
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
