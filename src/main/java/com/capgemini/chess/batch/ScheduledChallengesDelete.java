package com.capgemini.chess.batch;

import static com.capgemini.chess.ApplicationProperties.DELETING_CHALLENGES_SCHEDULE_PERIOD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.capgemini.chess.dao.ChallengeDao;

/**
 * Scheduler which role is delete all expired challenges found in the database
 * @author PWOJTKOW
 */
@Component
public class ScheduledChallengesDelete {

	@Autowired
	private ChallengeDao challengeDao;
	
	@Scheduled(cron = DELETING_CHALLENGES_SCHEDULE_PERIOD)
	public void deleteChallenges() {
		challengeDao.deleteExpiredChallengesFromLocalList();
	}
}
