package com.capgemini.chess.service.to;


import com.capgemini.chess.service.enums.MatchStatus;

import lombok.Getter;
import lombok.Setter;
/**
 * Transfer object of match
 * @author PWOJTKOW
 */
@Getter @Setter
public class MatchTo {

	
	private long id;
	private long challenge_id;
	private UserProfileTo whitePlayer;
	private UserProfileTo blackPlayer;
	//private BoardManager boardManager;
	private MatchStatus matchStatus;
}
