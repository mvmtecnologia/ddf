package br.com.dicadefarmacia.infra.dao;

import java.util.List;

import br.com.dicadefarmacia.domain.Usuario;

public interface ContactDAO {
	
	public void addContact(Usuario contact);
    public List<Usuario> listContact();
    public void removeContact(Long id);

}
