package br.com.dicadefarmacia.infra.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Usuario;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	private Session openSession() {  
        return sessionFactory.getCurrentSession();  
    }
	
	@Override
	public void addUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> listUsuario() {
		return sessionFactory.getCurrentSession().createQuery("from Usuario").list();
	}

	@Override
	public void removeUsuario(Long id) {
		Usuario contact = (Usuario) sessionFactory.getCurrentSession().load(Usuario.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Usuario getUsuarioByEmail(String email) {
		List<Usuario> userList = new ArrayList<>();  
        Query query = openSession().createQuery("from Usuario u where u.email = :email");  
        query.setParameter("email", email);  
        userList = query.list();  
        if (userList.size() > 0) { 
            return userList.get(0);  
        }
        
        return null;
		
	}
}
