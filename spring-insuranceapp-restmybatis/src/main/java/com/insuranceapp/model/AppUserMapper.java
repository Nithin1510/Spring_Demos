package com.insuranceapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper {
	


	// from DB to frontEnd
	// convert AppUser to userDetails
	public UserDetails ConvertToUserDetails(AppUser appUser) {
		String username = appUser.getUsername();
		String password = appUser.getPassword();
		List<GrantedAuthority> authorities = new ArrayList<>();
		// create roles for user
		List<String> roles = Arrays.asList("user", "admin");
		for (String role : roles) {
			// create simpleGranted authority
			SimpleGrantedAuthority simpleAuthority = new SimpleGrantedAuthority(role);
			// add this to the list of GrantedAuthority
			authorities.add(simpleAuthority);
		}
		UserDetails details = new User(username, password, authorities);
		return details;
	}
}
