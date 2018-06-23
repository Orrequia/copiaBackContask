package com.fot.backConTask.service.jwt;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.fot.backConTask.component.mapper.token.TokenMapper;
import com.fot.backConTask.dto.LoginDTO;
import com.fot.backConTask.dto.TokenDTO;
import com.fot.backConTask.dto.ValidTokenDTO;
import com.fot.backConTask.exception.InvalidUserException;
import com.fot.backConTask.model.User;
import com.fot.backConTask.service.localdatetime.LocalDateTimeService;
import com.fot.backConTask.service.user.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTServiceImpl implements JWTService {

	private static final ZoneId DEFAULT_ZONEID = ZoneId.systemDefault();
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Integer expiration;
	
	@Autowired
	UserService userService;
	
	@Autowired
	LocalDateTimeService dateService;
	
	@Autowired
	TokenMapper tokenMapper;
	
	@Override
	public TokenDTO loginUser(LoginDTO login) throws InvalidUserException {
		final User user = userService.findUser(login);
		final String token = generateToken(user);
		return tokenMapper.map(token);
	}
	
	private String generateToken(final User u) {
		final LocalDateTime now = dateService.now();
		return Jwts.builder().claim(Claims.SUBJECT, u.getUsername())
							.claim(Claims.ISSUED_AT, toEpoch(now))
							.claim(Claims.EXPIRATION, toEpoch(dateService.plusSeconds(now, expiration)))
							.signWith(SignatureAlgorithm.HS256, secret)
							.compact();
	}
	
	private Long toEpoch(LocalDateTime date) {
		return date.atZone(DEFAULT_ZONEID).toEpochSecond();
	}

	@Override
	public ValidTokenDTO validateToken(String token) {
		final Claims claims = extractClaims(token);
		return new ValidTokenDTO(claims.getSubject());
	}

	private Claims extractClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
}
