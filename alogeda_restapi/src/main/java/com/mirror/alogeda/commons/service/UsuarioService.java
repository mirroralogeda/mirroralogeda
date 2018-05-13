package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Usuarios;
import com.mirror.alogeda.commons.repository.UsuariosRepository;

@Service
public class UsuarioService extends CrudService<Usuarios> {
	private UsuariosRepository usrRepository;
	private PasswordEncoder encoder;

	@Autowired
	public UsuarioService(UsuariosRepository usuarioRepository, PasswordEncoder encoder) {
		super(usuarioRepository);
		this.usrRepository = usuarioRepository;
		this.encoder = encoder;
	}

	@Override
	public void save(Usuarios entidade) {
		// Todo: verificar se a senha ja esta codificada
		entidade.setSenha(encoder.encode(entidade.getSenha()));
		usrRepository.save(entidade);
	}

}
