package com.capgemini.chess;

/**
 * All properties used inside the application code
 * @author PWOJTKOW
 */
public class ApplicationProperties {

	/**
	 * Number of days after which challenge status is going to set as "CANCELLED"
	 */
	public static final int VALIDATION_PERIOD_NUMER_OF_DAYS = 7;
	
	/**
	 * CRON configuration, declaring how often database should by checked for expired challenges
	 */
	public static final String DELETING_CHALLENGES_SCHEDULE_PERIOD = "0 0 3 * * *"; // every day, on 3:00AM
	
	/**
	 * Message to appear when challenge has been sent
	 */
	public static final String CHALLENGE_HAS_BEEN_SENT_MESSAGE = "Challenge has been sent";
	
	/**
	 * Message to appear when challenge has been deleted
	 */
	public static final String CHALLENGE_HAS_BEEN_DELETED_MESSAGE = "Challenge has been deleted";
}
