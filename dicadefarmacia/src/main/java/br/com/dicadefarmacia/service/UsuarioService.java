package br.com.dicadefarmacia.service;

import java.util.List;

import br.com.dicadefarmacia.domain.Usuario;

public interface UsuarioService {

	public void addUsuario(Usuario usuario);
    public List<Usuario> listUsuario();
    public void removeUsuario(Long id);
    public void updateUsuario(Usuario usuario);
}
