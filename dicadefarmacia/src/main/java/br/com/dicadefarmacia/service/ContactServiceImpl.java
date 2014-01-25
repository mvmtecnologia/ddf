package br.com.dicadefarmacia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Usuario;
import br.com.dicadefarmacia.infra.dao.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService {
 
    @Autowired
    private ContactDAO contactDAO;
     
    @Transactional
    public void addContact(Usuario contact) {
        contactDAO.addContact(contact);
    }
 
    @Transactional
    public List<Usuario> listContact() {
 
        return contactDAO.listContact();
    }
 
    @Transactional
    public void removeContact(Long id) {
        contactDAO.removeContact(id);
    }

}
