package br.com.dicadefarmacia.service;

import java.util.List;

import br.com.dicadefarmacia.domain.Usuario;

public interface ContactService {

	public void addContact(Usuario contact);
    public List<Usuario> listContact();
    public void removeContact(Long id);
    
}
