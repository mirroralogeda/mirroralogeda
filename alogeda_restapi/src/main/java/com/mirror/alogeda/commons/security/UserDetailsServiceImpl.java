package com.mirror.alogeda.commons.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Usuarios;
import com.mirror.alogeda.commons.repository.UsuariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsuariosRepository usrRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Usuarios usr = usrRepository.findByNomeUsuario(username);

		if (usr == null) {
			throw new UsernameNotFoundException(username);
		}

		return new UserPrincipal(usr);
	}

}
