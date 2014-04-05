package br.com.dicadefarmacia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Usuario;
import br.com.dicadefarmacia.infra.dao.UsuarioDAO;
import br.com.dicadefarmacia.infra.utils.StringUtils;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
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

	@Override
	public Boolean usuarioLoginValido(Usuario usuario) {

		if(usuarioNuloOuVazio(usuario)){
			return false;
		}
		
		Usuario usuarioSalvo = usuarioDAO.getUsuarioPorEmail(usuario.getEmail()
				.trim());

		if(usuarioNuloOuVazio(usuarioSalvo)){
			return false;
		}

		if (!usuario.getEmail().equalsIgnoreCase(usuarioSalvo.getEmail())) {
			return false;
		} else {
			if (usuario.getSenha().equals(usuarioSalvo.getSenha())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Verifica se o usuário é nulo ou se as variaveis
	 * email e senha são nulas ou vazias.
	 * 
	 * @param usuario
	 * @return <code>true</code> se usuário <code>null</code> ou vazio. <code>false</code> caso contrário.
	 */
	private Boolean usuarioNuloOuVazio(Usuario usuario) {
		if (usuario == null) {
			return true;
		}

		if (StringUtils.isBlank(usuario.getEmail())
				|| StringUtils.isBlank(usuario.getSenha())) {
			return true;
		}
		
		return false;
	}

}
