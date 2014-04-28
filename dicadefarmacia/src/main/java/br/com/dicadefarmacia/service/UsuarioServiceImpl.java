package br.com.dicadefarmacia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Usuario;
import br.com.dicadefarmacia.infra.dao.UsuarioDAO;
import br.com.dicadefarmacia.infra.utils.StringUtils;
import static br.com.dicadefarmacia.infra.constant.Message.Logger.INICIO_METODO;
import static br.com.dicadefarmacia.infra.constant.Message.Logger.FINAL_METODO;;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public void addUsuario(Usuario usuario) {
		LOG.info(INICIO_METODO+usuario);

		usuarioDAO.addUsuario(usuario);
		
		LOG.info(FINAL_METODO+usuario);
	}

	@Override
	public List<Usuario> listUsuario() {
		LOG.info(INICIO_METODO);
		
		final List<Usuario> listUsuario = usuarioDAO.listUsuario();
		
		LOG.info(FINAL_METODO + listUsuario);
		return listUsuario;
	}

	@Override
	public void removeUsuario(Long id) {
		LOG.info(INICIO_METODO+id);
		
		usuarioDAO.removeUsuario(id);
		
		LOG.info(FINAL_METODO+id);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		LOG.info(INICIO_METODO+usuario);

		usuarioDAO.updateUsuario(usuario);

		LOG.info(FINAL_METODO+usuario);
	}

	@Override
	public Boolean usuarioLoginValido(Usuario usuario) {
		LOG.info(INICIO_METODO+usuario);

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
		LOG.info(FINAL_METODO+usuario);

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
		
		LOG.info(INICIO_METODO+usuario);
		if (usuario == null) {
			return true;
		}

		if (StringUtils.isBlank(usuario.getEmail())
				|| StringUtils.isBlank(usuario.getSenha())) {
			return true;
		}
		LOG.info(FINAL_METODO+usuario);

		return false;
	}

}
