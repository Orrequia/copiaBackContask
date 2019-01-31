package com.fot.backcontask.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import com.fot.backcontask.dto.user.ConnectedDTO;
import com.fot.backcontask.exception.InvalidRequestException;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor(onConstructor_={@Autowired})
class LoginController {

	private static final Integer LONGTEXTBASIC = 5;

	@Qualifier("authenticationManagerBean")
	private final AuthenticationManager authenticationManager;
	
	@PostMapping("/logout")
	public void logout(Authentication auth) {
		if(auth != null) {
			RequestContextHolder.resetRequestAttributes();
		}
	}

	@PostMapping("/login")
	public ConnectedDTO login(@RequestHeader(value = "Authorization") String auth) throws UnsupportedEncodingException, InvalidRequestException {

	    if (auth.startsWith("Basic")) {
	        String credentials = new String(Base64.getDecoder().decode(auth.substring(LONGTEXTBASIC).trim()), StandardCharsets.UTF_8);
	        final String[] values = credentials.split(":",2);

	        if(values.length == 2) {
	        	final Authentication token = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(values[0], values[1]));

	        	return ConnectedDTO.builder()
	    				.username(values[0])
	    				.grantedAuthorities(token.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
	    				.build();
	        } else {
	        	throw new InvalidRequestException("Petición de autorización incorrecto");
	        }
	    }
	    else {
	    	throw new InvalidRequestException("Se debe incluir la autenticación básica en la petición.");
	    }
	}

	@GetMapping("/connection") 
	public ResponseEntity<ConnectedDTO> connected(Authentication auth) {
		
		final Boolean isConected = Optional.ofNullable(auth).map(Authentication::getPrincipal).isPresent();
		final HttpStatus statusConnection = isConected ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

		return new ResponseEntity<>(statusConnection);
	}
}
