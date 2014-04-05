package br.com.dicadefarmacia.service;

import java.util.List;

import br.com.dicadefarmacia.domain.Usuario;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
public interface UsuarioService {

	public void addUsuario(Usuario usuario);
    public List<Usuario> listUsuario();
    public void removeUsuario(Long id);
    public void updateUsuario(Usuario usuario);
    public Boolean usuarioLoginValido(Usuario usuario);
}
