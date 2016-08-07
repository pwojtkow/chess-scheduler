package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.enums.ChallengeStatus;
import com.capgemini.chess.service.mapper.ChallengeMapper;
import com.capgemini.chess.service.to.ChallengeTo;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	ChallengeDao challengeDao;

	@Override
	public void sendChallange(Long id, Long senderId, Long recipientId) {
		ChallengeEntity challengeEntity = new ChallengeEntity(id,senderId,recipientId);
		challengeDao.addNewChallenge(challengeEntity);
	}

	@Override
	public void acceptChallange(Long challengeId) {
		challengeDao.changeChallengeState(challengeId, ChallengeStatus.ACCEPT);
	}

	@Override
	public void rejectChallange(Long challengeId) {
		challengeDao.changeChallengeState(challengeId, ChallengeStatus.REJECT);
	}

	@Override
	public void cancleSendChallenge(Long challengeId) {
		challengeDao.changeChallengeState(challengeId, ChallengeStatus.CANCELLED);
	}

	@Override
	public void updateChallengeList() {
		// TODO Auto-generated method stub
	}

	@Override
	public int howManyActiveChallenges(Long userId) {
		List<ChallengeEntity> challengeList = challengeDao.getAllChallenges();
		int counter = 0;
		for (ChallengeEntity challenge : challengeList) {
			if (challenge.getUserSenderId() == userId) {
				counter++;
			}
		}
		return counter;
	}

	@Override
	public List<ChallengeTo> getAllChallenges() {
		return ChallengeMapper.map2TOs(challengeDao.getAllChallenges());
	}

	@Override
	public void deleteChallenge(Long challengeId) {
		challengeDao.deleteChallenge(challengeId);
	}
	
	@Override
	public ChallengeTo getChallengeById(Long challengeId) {
		return ChallengeMapper.map(challengeDao.getChallengeById(challengeId));
	}
	
}
