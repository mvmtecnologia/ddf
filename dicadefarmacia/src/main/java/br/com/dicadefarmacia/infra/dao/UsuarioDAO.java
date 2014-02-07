package br.com.dicadefarmacia.infra.dao;

import java.util.List;

import br.com.dicadefarmacia.domain.Usuario;

public interface UsuarioDAO {

	public void addUsuario(Usuario usuario);
    public List<Usuario> listUsuario();
    public void removeUsuario(Long id);
    public void updateUsuario(Usuario usuario);
    public Usuario getUsuarioByEmail(String email);
}
