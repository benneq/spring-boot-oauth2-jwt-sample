package de.benneq.springbootoauth2jtwsample.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetailsImpl extends User {
	private static final long serialVersionUID = 1L;
	
	
	
	private final String id;
	public String getId() { return id; }

	public UserDetailsImpl(String id, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.id = id;
	}
	
}