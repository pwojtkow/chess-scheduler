package com.capgemini.chess.exceptions;

public class ChallengesOutOfLimitException extends RuntimeException {

	public ChallengesOutOfLimitException() {
		super();
	}
	
	public ChallengesOutOfLimitException(String message) {
		super(message);
	}
	
}
