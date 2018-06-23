package com.fot.backcontask.service.localdatetime;

import java.time.LocalDateTime;

public interface LocalDateTimeService {

	LocalDateTime now();
	
	LocalDateTime plusSeconds(LocalDateTime init, Integer seconds);
}
