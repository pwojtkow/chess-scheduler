package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import java.util.Arrays;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.batch.ScheduledChallengesDelete;
import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.enums.ChallengeStatus;

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
		//when
		scheduledDelete.deleteChallenges();
		//then
		assertEquals(0, challengeDao.getAllChallenges().size());
		Mockito.verify(challengeDao, times(1)).deleteExpiredChallengesFromLocalList();
	}

}
