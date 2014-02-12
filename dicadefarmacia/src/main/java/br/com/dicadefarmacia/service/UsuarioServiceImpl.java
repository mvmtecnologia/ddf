package br.com.dicadefarmacia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Usuario;
import br.com.dicadefarmacia.infra.dao.UsuarioDAO;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
    private UsuarioDAO usuarioDAO;
	
	@Override
	public void addUsuario(Usuario usuario) {
		usuarioDAO.addUsuario(usuario);
	}

	@Override
	public List<Usuario> listUsuario() {
		return usuarioDAO.listUsuario();
	}

	@Override
	public void removeUsuario(Long id) {
		usuarioDAO.removeUsuario(id);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		usuarioDAO.updateUsuario(usuario);
	}

}
