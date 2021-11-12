package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.model.jwt.JwtRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<?> test(){
		
		 Map<String, String> body = new HashMap<>();
 		body.put("status", "dasd");
	 	body.put("id", "phuc");
	 	 LOGGER.info("test completed");
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public ResponseEntity<?> a(){
		 LOGGER.info("test completed");
		 Map<String, String> body = new HashMap<>();
 		body.put("status", "dasd");
	 	body.put("id", "phuc");
	 	
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public ResponseEntity<?> Me(){
		Map<String, String> body = new HashMap<>();
 		body.put("status", "dasd");
	 	body.put("id", "phuc");
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
}
