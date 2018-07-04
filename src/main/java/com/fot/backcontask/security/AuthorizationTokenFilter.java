package com.fot.backcontask.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.service.jwt.JWTService;
import com.fot.backcontask.service.servletrequest.ServletRequestService;

public class AuthorizationTokenFilter extends BasicAuthenticationFilter {
	
	@Autowired
	JWTService jwtService;	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private ServletRequestService requestService;
		
	public AuthorizationTokenFilter(AuthenticationManager authManager) {
		super(authManager);
	}
	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		
////		String username = null;
////		try {
////			final String token = requestService.extractToken(request);
////			//username = jwtService.validateToken(token).getSubject();
////			
////		} catch (InvalidRequestException e) {
////			e.printStackTrace();
////		}
//		
//		UsernamePasswordAuthenticationToken authentication;
//		try {
//			authentication = getAuthentication(request);
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//		} catch (InvalidRequestException e) {
//			e.printStackTrace();
//		}
//					
////		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
////			
////			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
////			
////			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
////			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
////			
////		}
//		
//		chain.doFilter(request, response);
//	}
//	
//	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) throws InvalidRequestException {
//		final String token = requestService.extractToken(request);
//		
//		String user = jwtService.validateToken(token).getSubject();
//		
//		if(user != null) {
//			return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//		}
//		return null;
//	}
}
