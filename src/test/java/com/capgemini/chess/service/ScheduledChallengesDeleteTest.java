package com.capgemini.chess.service;

import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.batch.ScheduledChallengesDelete;
import com.capgemini.chess.dao.ChallengeDao;

/**
 * Scheduled challenges delete test
 * @author PWOJTKOW
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ChessApplication.class)
public class ScheduledChallengesDeleteTest {

	@Autowired
	private ChallengeDao challengeDao;
	@Autowired
	private ScheduledChallengesDelete scheduledDelete;
	
	@Before
	public void setUp() {
		challengeDao = Mockito.mock(ChallengeDao.class);
		Mockito.reset(challengeDao);
	}
	
	@Test
	public void shouldDeleteExpiredChallenges() {
		//given
		//when
		Mockito.doNothing().when(challengeDao).deleteExpiredChallengesFromLocalList();
		scheduledDelete.deleteChallenges();
		//then
		Mockito.verify(challengeDao, times(0)).deleteExpiredChallengesFromLocalList();
	}

}
