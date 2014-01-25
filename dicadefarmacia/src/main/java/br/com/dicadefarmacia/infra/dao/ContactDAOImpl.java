package br.com.dicadefarmacia.infra.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.dicadefarmacia.domain.Usuario;

@Repository
public class ContactDAOImpl implements ContactDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addContact(Usuario contact) {
        sessionFactory.getCurrentSession().save(contact);
    }
 
    @SuppressWarnings("unchecked")
	public List<Usuario> listContact() {
        return sessionFactory.getCurrentSession().createQuery("from Usuario").list();
    }
 
    public void removeContact(Long id) {
        Usuario contact = (Usuario) sessionFactory.getCurrentSession().load(Usuario.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
    }

}
