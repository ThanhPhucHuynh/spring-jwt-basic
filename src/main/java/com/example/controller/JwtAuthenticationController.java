package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.JwtTokenUtil;
import com.example.model.User;
import com.example.model.jwt.JwtRequest;
import com.example.model.jwt.JwtResponse;
import com.example.repository.UserRepository;
import com.example.service.JwtUserDetailsService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JwtAuthenticationController {
	@Autowired
	private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> Register(@RequestBody User u){
		
		try {
//			User s = userDetailsService.save(u);
			return ResponseEntity.status(HttpStatus.OK).body(userDetailsService.save(u));		
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> body = new HashMap<>();
	 		body.put("code", "201");
		 	body.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
		}	
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> Login(@RequestBody JwtRequest authenticationRequest){
		System.out.println(authenticationRequest);
		try {
			 authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

	        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
	        
	        User user = userRepository.findByEmail(authenticationRequest.getEmail());

	        final String token = jwtTokenUtil.generateToken(userDetails,user);
//	        return ResponseEntity.ok(user);
	        return ResponseEntity.ok(new JwtResponse(token, user.getId(), user.getName()));	
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> body = new HashMap<>();
	 		body.put("code", "201");
		 	body.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
		}	
	}
	  private void authenticate(String email, String password) throws Exception {
		  System.out.println(email +" - "+ password);
	        try {
	        	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
	        } catch (DisabledException e) {
	            throw new Exception("USER_DISABLED", e);
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS" + e.getMessage());
	        }
	    }
}
