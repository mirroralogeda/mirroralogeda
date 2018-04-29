package com.mirror.alogeda.commons.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mirror.alogeda.commons.model.Usuario;

public class UserPrincipal implements UserDetails {
	private static final long serialVersionUID = 7667483012755269183L;
	private Usuario usr;

	public UserPrincipal(Usuario usr) {
		this.usr = usr;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("admin"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return usr.getSenha();
	}

	@Override
	public String getUsername() {
		return usr.getNomeUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !usr.isSenhaInspirada();
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
