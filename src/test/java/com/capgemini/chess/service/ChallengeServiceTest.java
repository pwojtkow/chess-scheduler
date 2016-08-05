package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.dao.ChallengeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ChessApplication.class)
public class ChallengeServiceTest {
	
	@Autowired
	private ChallengeService challengeService;
	
	@Autowired
	private ChallengeDao challengeDao;
	
	@Test
	public void shouldAddNewChallenge() {
		//given
		long senderId = 1L;
		long recipientId = 2L;
		long challengeId = 1L;
		int challengesQuantityInDatabase = challengeDao.getAllChallenges().size();
		//when
		challengeService.sendChallange(challengeId, senderId, recipientId);
		//then
		assertEquals(challengesQuantityInDatabase + 1, challengeDao.getAllChallenges().size());
	}

}
