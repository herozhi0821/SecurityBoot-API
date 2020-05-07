package net.cnki.common;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUser {
	
	public String getActiveUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
}
