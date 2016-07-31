package com.capgemini.chess;

/**
 * @author PWOJTKOW
 * huj ci w dupe
 */
public class ApplicationProperties {

	public static final int VALIDATION_PERIOD_NUMER_OF_DAYS = 7;
	
	/**
	 * CRON configuration, declaring how often database should by checked for expired challenges
	 */
	public static final String DELETING_CHALLENGES_SCHEDULE_PERIOD = "0 0 3 * * *"; // every day, on 3:00AM
}
