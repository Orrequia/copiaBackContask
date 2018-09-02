package com.fot.backcontask.dto.user;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ConnectedDTO {

	private String username;
	private String idSession;
	private List<String> grantedAuthorities;
}
