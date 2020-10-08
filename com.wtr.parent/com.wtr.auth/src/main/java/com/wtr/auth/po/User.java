package com.wtr.auth.po;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User extends com.wtr.cultivate.entity.master.user.User implements UserDetails {
	private static final long serialVersionUID = -1841832825603313290L;

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}


}
