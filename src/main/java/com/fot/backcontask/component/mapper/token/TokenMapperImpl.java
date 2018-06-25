package com.fot.backcontask.component.mapper.token;

import org.springframework.stereotype.Component;

import com.fot.backcontask.dto.auth.TokenDTO;

@Component
public class TokenMapperImpl implements TokenMapper {

	@Override
	public TokenDTO map(String token) {
		final TokenDTO res = new TokenDTO();
		res.setAccessToken(token);
		return res;
	}
}
