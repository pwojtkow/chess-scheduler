package com.capgemini.chess.rest;

import static com.capgemini.chess.ApplicationProperties.CHALLENGE_HAS_BEEN_SENT_MESSAGE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.chess.service.ChallengeService;

@Controller
@ResponseBody
public class ChallengeRestService {

	@Autowired
	ChallengeService challengeService;

	/**
	 * Method add new challenge to database
	 * @param challengeId - id mapped to challenge
	 * @param senderId - id mapped to challenge sender
	 * @param recipientId - id mapped to challenge recipient
	 * @return - message confirm that challenge has been sent and http status "OK"
	 */
	@RequestMapping(value = "/rest/challenge/add", method = RequestMethod.PUT, produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> addNewChallenge(@RequestParam("ch_id") long challengeId,
			@RequestParam("s_id") long senderId, @RequestParam("r_id") long recipientId) {
		System.out.println(challengeService.getAllChallenges().size());
		challengeService.sendChallange(challengeId, senderId, recipientId);
		System.out.println(challengeService.getAllChallenges().size());
		return new ResponseEntity<String>(CHALLENGE_HAS_BEEN_SENT_MESSAGE, HttpStatus.OK);
	}

}
