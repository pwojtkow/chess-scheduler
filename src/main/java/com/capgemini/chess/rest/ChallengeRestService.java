package com.capgemini.chess.rest;

import static com.capgemini.chess.ApplicationProperties.CHALLENGE_HAS_BEEN_DELETED_MESSAGE;
import static com.capgemini.chess.ApplicationProperties.CHALLENGE_HAS_BEEN_SENT_MESSAGE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.chess.exceptions.ChallengeNotFoundException;
import com.capgemini.chess.exceptions.ChallengeWithIdExistException;
import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.to.ChallengeTo;
/**
 * Rest service to change challenges states
 * @author PWOJTKOW
 */
@Controller
@ResponseBody
public class ChallengeRestService {

	@Autowired
	ChallengeService challengeService;
	
	@ExceptionHandler(ChallengeWithIdExistException.class)
	private ResponseEntity<String> handleChallengeWithIdExistException() {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
	}
	
	@ExceptionHandler(ChallengeNotFoundException.class)
	private ResponseEntity<String> handleChallengeNotFoundException() {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	/**
	 * Method add new challenge to database
	 * @param challengeId - id mapped to challenge
	 * @param senderId - id mapped to challenge sender
	 * @param recipientId - id mapped to challenge recipient
	 * @return - message confirm that challenge has been sent and http status "OK"
	 */
	@RequestMapping(value = "/rest/challenge/add", method = RequestMethod.PUT, produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> addNewChallenge(@RequestParam("challenge_id") Long challengeId,
			@RequestParam("sender_id") Long senderId, @RequestParam("recipient_id") Long recipientId) {
		challengeService.sendChallange(challengeId, senderId, recipientId);
		return new ResponseEntity<String>(CHALLENGE_HAS_BEEN_SENT_MESSAGE, HttpStatus.OK);
	}
	
	/**
	 * Method delete challenge from database
	 * @param challengeId - id mapped to challenge to delete
	 * @return - message confirm that challenge has been deleted and http status "OK"
	 */
	@RequestMapping(value = "/rest/challenge/delete", method = RequestMethod.DELETE, produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> deleteChallenge(@RequestParam("challenge_id") Long challengeId) {
		challengeService.deleteChallenge(challengeId);
		return new ResponseEntity<String>(CHALLENGE_HAS_BEEN_DELETED_MESSAGE, HttpStatus.OK);
	}
	
	/**
	 * Method return all challenges from database as JSON value
	 * @return - all challenges from database as JSON value
	 */
	@RequestMapping(value = "/rest/challenge/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ChallengeTo>> getAllChallenges() {
		List<ChallengeTo> challengesList = challengeService.getAllChallenges();
		return new ResponseEntity<List<ChallengeTo>>(challengesList, HttpStatus.OK);
	}
}
