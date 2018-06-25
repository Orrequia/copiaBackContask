package com.fot.backcontask.component.mapper.token;

import com.fot.backcontask.dto.auth.TokenDTO;

public interface TokenMapper {

	TokenDTO map(String token);
}
