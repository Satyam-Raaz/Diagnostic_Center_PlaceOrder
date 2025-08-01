package com.diagnostic.DiagnosticCenter.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserPrincipal implements UserDetails {
	   private User user;

	    public UserPrincipal(User user) {
	        this.user = user;
	    }
		public UserPrincipal() {
			super();
			// TODO Auto-generated constructor stub
		}

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
			return  Collections.singletonList(new SimpleGrantedAuthority("ROLE_" +user.getRole()));
	    }

	    @Override
	    public String getPassword() {
	        return user.getPassword();
	    }

	    @Override
	    public String getUsername() {
	        return user.getUsername();
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

}
