package com.capgemini.chess.exceptions;

public class ChallengesOutOfLimitException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ChallengesOutOfLimitException() {
		super();
	}
	
	public ChallengesOutOfLimitException(String message) {
		super(message);
	}
	
}
