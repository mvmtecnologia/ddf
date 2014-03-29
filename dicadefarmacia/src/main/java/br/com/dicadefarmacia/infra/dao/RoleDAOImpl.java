package br.com.dicadefarmacia.infra.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Role;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Role> listRole() {
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}

	@Override
	public void removeRole(Long id) {
		Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, id);
        if (null != role) {
            sessionFactory.getCurrentSession().delete(role);
        }
	}

	@Override
	public Role buscaRole(Long id) {
		Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, id);
		System.out.println(role);
		return role;
	}

	@Override
	public void updateRole(Role role) {
		sessionFactory.getCurrentSession().update(role);
	}

}
