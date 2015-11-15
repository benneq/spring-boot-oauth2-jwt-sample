package de.benneq.springbootoauth2jtwsample.security;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;

@Component
public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

	final String USERID = "user_id";
	
	@Override
	public Map<String, ?> convertUserAuthentication(Authentication authentication) {
		Map<String, Object> response = new LinkedHashMap<String, Object>(super.convertUserAuthentication(authentication));
		if(authentication.getPrincipal() instanceof UserDetailsImpl) {
			response.put(USERID, ((UserDetailsImpl) authentication.getPrincipal()).getId());
		}
		return response;
	}
	@Override
	public Authentication extractAuthentication(Map<String, ?> map) {
		Authentication auth = super.extractAuthentication(map);
		return new UsernamePasswordAuthenticationToken(
				new UserDetailsImpl((String) map.get(USERID), (String) map.get(USERNAME), (String) auth.getCredentials(), true, true, true, true, auth.getAuthorities()),
				auth.getCredentials(),
				auth.getAuthorities()
		);
	}
	
}