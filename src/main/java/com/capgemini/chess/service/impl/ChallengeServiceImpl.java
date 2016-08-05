package com.capgemini.chess.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.exceptions.ChallengesOutOfLimitException;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.enums.ChallengeStatus;
import com.capgemini.chess.service.mapper.ChallengeMapper;
import com.capgemini.chess.service.to.ChallengeTo;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	ChallengeDao challengeDao;

	@Override
	public void sendChallange(long id, long senderId, long recipientId) throws ChallengesOutOfLimitException, UserNotFoundException {
		ChallengeTo newChallenge = new ChallengeTo(id,senderId,recipientId);
		challengeDao.addNewChallenge(ChallengeMapper.map(newChallenge));
	}

	@Override
	public void acceptChallange(long challengeId) {
		challengeDao.getChallengeById(challengeId).setChallengeStatus(ChallengeStatus.ACCEPT);
	}

	@Override
	public void rejectChallange(long challengeId) {
		challengeDao.getChallengeById(challengeId).setChallengeStatus(ChallengeStatus.REJECT);
	}

	@Override
	public void cancleSendChallenge(long challengeId) {
		challengeDao.getChallengeById(challengeId).setChallengeStatus(ChallengeStatus.CANCELLED);
	}
	
	@Override
	public void updateChallengeList() {
		// TODO Auto-generated method stub
	}

	@Override
	public int howManyActiveChallenges(long userId) {
		List<ChallengeEntity> challengeList = challengeDao.getAllChallenges();
		int counter = 0;
		for(ChallengeEntity challenge : challengeList) {
			if(challenge.getUserSenderId() == userId) {
				counter++;
			}
		}
		return counter;
	}

	@Override
	public List<ChallengeTo> getAllChallenges() {
		return ChallengeMapper.map2TOs(challengeDao.getAllChallenges());
	}

}
