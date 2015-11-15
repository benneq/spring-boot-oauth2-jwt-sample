package de.benneq.springbootoauth2jtwsample.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final Map<String, UserDetailsImpl> users = new HashMap<>();
	
	public UserDetailsServiceImpl() {
		UserDetailsImpl user = new UserDetailsImpl(
				"abcd1234",
				"admin",
				"s3cr3t",
				true,
				true,
				true,
				true,
				Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))
		);
		users.put(user.getUsername(), user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl user = users.get(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Username not found.");
		}
		
		return user;
	}
	
}