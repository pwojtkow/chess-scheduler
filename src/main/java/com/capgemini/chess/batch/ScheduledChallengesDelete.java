package com.capgemini.chess.batch;

import static com.capgemini.chess.ApplicationProperties.DELETING_CHALLENGES_SCHEDULE_PERIOD;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledChallengesDelete {

	@Scheduled(cron = DELETING_CHALLENGES_SCHEDULE_PERIOD)
	public void deleteChallenges() {
		System.out.println("dzialam");
	}
}
