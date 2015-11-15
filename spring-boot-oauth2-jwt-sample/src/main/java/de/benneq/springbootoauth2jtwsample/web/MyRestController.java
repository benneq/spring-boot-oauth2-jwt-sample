package de.benneq.springbootoauth2jtwsample.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.benneq.springbootoauth2jtwsample.security.UserDetailsImpl;

@RestController
@RequestMapping("")
public class MyRestController {

	@RequestMapping("/foo")
	public String unsecured(@AuthenticationPrincipal UserDetailsImpl user) {
		return "UNSECURED. User is " + user;
	}
	
	@RequestMapping("/bar")
	@PreAuthorize("hasRole('USER')")
	public String secured1(@AuthenticationPrincipal UserDetailsImpl user) {
		return "SECURED1. User is "+ user +".\nID: " + user.getId() + ", Username: " + user.getUsername();
	}
	
	@RequestMapping("/baz")
	@PreAuthorize("hasRole('ADMIN')")
	public String secured2(@AuthenticationPrincipal UserDetailsImpl user) {
		return "SECURED2. User is "+ user +".\nID: " + user.getId() + ", Username: " + user.getUsername();
	}
	
}