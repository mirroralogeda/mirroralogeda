package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Usuario;
import com.mirror.alogeda.commons.repository.UsuarioRepository;

@Service
public class UsuarioService extends CrudService<Usuario> {
	private UsuarioRepository usrRepository;
	private PasswordEncoder encoder;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
		super(usuarioRepository);
		this.usrRepository = usuarioRepository;
		this.encoder = encoder;
	}

	@Override
	public void save(Usuario entidade) {
		// Todo: verificar se a senha ja esta codificada
		entidade.setSenha(encoder.encode(entidade.getSenha()));
		usrRepository.save(entidade);
	}

}
