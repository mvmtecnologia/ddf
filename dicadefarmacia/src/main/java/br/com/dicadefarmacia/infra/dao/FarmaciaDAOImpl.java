package br.com.dicadefarmacia.infra.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Farmacia;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Repository
@Transactional
public class FarmaciaDAOImpl implements FarmaciaDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	
	public void addFarmacia(Farmacia farmacia) {
		sessionFactory.getCurrentSession().save(farmacia);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Farmacia> listFarmacia() {
		return sessionFactory.getCurrentSession().createQuery("from Farmacia").list();
	}

	@Override
	public void removeFarmacia(Long id) {
		Farmacia farmacia = (Farmacia) sessionFactory.getCurrentSession().load(Farmacia.class, id);
        if (null != farmacia) {
            sessionFactory.getCurrentSession().delete(farmacia);
        }
	}

	@Override
	public Farmacia buscaFarmacia(Long id) {
		System.out.println("Id da Farmacia: " + id);
		Farmacia farmacia = (Farmacia) sessionFactory.getCurrentSession().load(Farmacia.class, id);
		System.out.println(farmacia);
		return farmacia;//(Farmacia) sessionFactory.getCurrentSession().load(Farmacia.class, id);
	}

	@Override
	public void updateFarmacia(Farmacia farmacia) {
		System.out.println(">>>>>>>>>> outra farmacia: " + farmacia);
		sessionFactory.getCurrentSession().update(farmacia);
	}

}
