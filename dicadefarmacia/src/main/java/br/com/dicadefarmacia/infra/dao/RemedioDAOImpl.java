package br.com.dicadefarmacia.infra.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Remedio;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Repository
@Transactional
public class RemedioDAOImpl implements RemedioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addRemedio(Remedio remedio) {
		sessionFactory.getCurrentSession().save(remedio);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Remedio> listRemedio() {
		return sessionFactory.getCurrentSession().createQuery("from Remedio")
				.list();
	}

	@Override
	public void removeRemedio(Long id) {
		Remedio remedio = (Remedio) sessionFactory.getCurrentSession().load(
				Remedio.class, id);
		if (null != remedio) {
			sessionFactory.getCurrentSession().delete(remedio);
		}
	}

	@Override
	public void updateRemedio(Remedio remedio) {
		sessionFactory.getCurrentSession().update(remedio);
	}
}
