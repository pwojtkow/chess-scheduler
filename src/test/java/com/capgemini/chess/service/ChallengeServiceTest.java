package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.to.ChallengeTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ChessApplication.class)
public class ChallengeServiceTest {
	
	@Autowired
	private ChallengeService challengeService;
	
	@Autowired
	private ChallengeDao challengeDao;
	
//	@Test
//	public void shouldAddNewChallenge() {
//		//given
//		Long senderId = 1L;
//		Long recipientId = 2L;
//		Long challengeId = 1L;
//		int challengesQuantityInDatabase = challengeDao.getAllChallenges().size();
//		//when
//		challengeService.sendChallange(challengeId, senderId, recipientId);
//		//then
//		assertEquals(challengesQuantityInDatabase + 1, challengeDao.getAllChallenges().size());
//	}
	
	@Test
	public void shouldDeleteChallenge() {
		//given
		int challengeListSize; 
		int challengeListSizeAfterDelete;
		Long challengeToDeleteId = 1L;
		//when
		challengeService.sendChallange(challengeToDeleteId, 1L, 2L);
		challengeListSize = challengeDao.getAllChallenges().size();
		challengeService.deleteChallenge(challengeToDeleteId);
		challengeListSizeAfterDelete = challengeDao.getAllChallenges().size();
		//then
		assertEquals(challengeListSize, challengeListSizeAfterDelete);
	}

	

}
