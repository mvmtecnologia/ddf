package br.com.dicadefarmacia.infra.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.dicadefarmacia.infra.utils.BeanToAliasTransformer;
import br.com.dicadefarmacia.infra.utils.MensagensUtils;
import br.com.dicadefarmacia.infra.utils.QueryUtils;
import br.com.dicadefarmacia.infra.utils.StringUtils;

public class DAO<E> {
	
	private Class<E> classeEntidade;
	private Session session;
	
	public DAO(Class<E> c) {
			this.classeEntidade = c;
			this.session = HibernateDAO.getSession();
	}
	
	public Session getSession() {
		return session;
	}
	
	public void clearSession(){
		
		Transaction tx = session.beginTransaction();
		session.clear();
		session.flush();
		tx.commit();
		
	}
	
	public void clearEm(){
		
		Transaction tx = session.beginTransaction();
		session.clear();
		session.flush();
		tx.commit();
		
	}
	
	public void evict(E e){
		
		Transaction tx = session.beginTransaction();
		session.evict(e);
		tx.commit();
		
	}
	
	public boolean update(E obj) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(E obj) {
		
		Transaction tx = session.beginTransaction();
		try {
			
			session.delete(obj);
			tx.commit();
		}catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			System.out.println(MensagensUtils.DELETE_ERRO);
			e.printStackTrace();
			return false;

		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<E> list() {
		List<E> l = null;
		
		Transaction tx = session.beginTransaction();
		try {
			
			l = session.createQuery("from " + classeEntidade.getSimpleName()).list();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return l;
	}

	public List<E> pesquisaGenerica(String hql, Map<String, Object> atributos,
			Map<String, String> comparadores, boolean useResultTrans) {
		List<E> l = null;
		
		Transaction tx = session.beginTransaction();
		try {			
			org.hibernate.Query query = session.createQuery(hql);

			for (String nomeAtributo : atributos.keySet()) {
				Object valor = atributos.get(nomeAtributo);
				String comp = comparadores.get(StringUtils.removePrefixo(
						nomeAtributo,
						StringUtils.primeiraLetraToLowerCase(classeEntidade
								.getSimpleName()) + "_"));

				if (valor instanceof String) {
					if (comp != null) {
						if (comp == QueryUtils.INICIO_LIKE) {
							query.setString(nomeAtributo, ((String) valor)
									+ "%");
						} else if (comp == QueryUtils.FIM_LIKE) {
							query.setString(nomeAtributo, "%"
									+ ((String) valor));
						} else if (comp == QueryUtils.LIKE) {
							query.setString(nomeAtributo, "%"
									+ ((String) valor) + "%");
						}
					} else {
						query.setString(nomeAtributo, "%" + ((String) valor)
								+ "%");
					}
				} else if (valor instanceof Integer) {
					query.setInteger(nomeAtributo, (Integer) valor);

				} else if (valor instanceof Long) {
					query.setLong(nomeAtributo, (Long) valor);
				} else if (valor instanceof Double) {
					query.setDouble(nomeAtributo, (Double) valor);
				} else if (valor instanceof Float) {
					query.setFloat(nomeAtributo, (Float) valor);
				} else if (valor instanceof BigDecimal) {
					query.setBigDecimal(nomeAtributo, (BigDecimal) valor);
				} else if (valor instanceof BigInteger) {
					query.setBigInteger(nomeAtributo, (BigInteger) valor);
				} else {
					query.setParameter(nomeAtributo, (Integer) valor);
				}

			}
			if (useResultTrans) {
				query.setResultTransformer(BeanToAliasTransformer
						.aliasToBean(classeEntidade));
			}
			l = query.list();
			if (tx.isActive())
				tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return l;
	}

	public boolean insert(E obj) {
		Transaction tx = session.beginTransaction();
		try {
			
			session.save(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public E find(Serializable id) {
		
		Transaction tx = session.beginTransaction();
		E c = null;
		try {
			c = (E) session.createQuery("from "+classeEntidade.getSimpleName()+" obj where obj.id ="+id).uniqueResult();
			tx.commit();
		} catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     e.printStackTrace();
		 }		
		return c;
	}
	
//	@Override
//	protected void finalize() throws Throwable {
//		session.close();
//		System.out.println("Foi fechada a sessão!!! "+classeEntidade.getSimpleName());
//		super.finalize();
//	}
	

//	@SuppressWarnings("unchecked")
//	public List<E> findByExample(Object exampleInstance,
//			String... excludeProperty) {
//		List<E> lista = null;
//		try {
//			if (!em.getTransaction().isActive())
//				em.getTransaction().begin();
//			org.hibernate.Criteria crit = ((org.hibernate.ejb.HibernateEntityManager) em)
//					.getSession().createCriteria(classeEntidade);
//			org.hibernate.criterion.Example example = org.hibernate.criterion.Example
//					.create(exampleInstance);
//			for (String exclude : excludeProperty) {
//				example.excludeProperty(exclude);
//			}
//			crit.add(example);
//			lista = crit.list();
//			if (em.getTransaction().isActive())
//				em.getTransaction().commit();
//		} catch (HibernateException ex) {
//			if (em.getTransaction().isActive()) {
//				em.getTransaction().rollback();
//			}
//			ex.printStackTrace();
//		}
//		return lista;
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<E> findByExamplePartial(Object exampleInstance, String campo,
//			String... excludeProperty) {
//		List<E> lista = null;
//		try {
//			if (!em.getTransaction().isActive())
//				em.getTransaction().begin();
//			org.hibernate.Criteria crit = ((org.hibernate.ejb.HibernateEntityManager) em)
//					.getSession().createCriteria(classeEntidade);
//			org.hibernate.criterion.Example example = org.hibernate.criterion.Example
//					.create(exampleInstance);
//			example.enableLike(org.hibernate.criterion.MatchMode.ANYWHERE);
//			example.ignoreCase();
//			example.excludeZeroes();
//			for (String exclude : excludeProperty) {
//				example.excludeProperty(exclude);
//			}
//			crit.add(example);
//			crit.addOrder(Order.asc(campo));
//			lista = crit.list();
//			if (em.getTransaction().isActive())
//				em.getTransaction().commit();
//		} catch (HibernateException ex) {
//			if (em.getTransaction().isActive()) {
//				em.getTransaction().rollback();
//			}
//			ex.printStackTrace();
//		}
//		return lista;
//	}
}
