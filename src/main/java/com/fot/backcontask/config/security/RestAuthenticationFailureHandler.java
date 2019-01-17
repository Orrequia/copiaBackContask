package com.fot.backcontask.config.security;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
class RestAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

}