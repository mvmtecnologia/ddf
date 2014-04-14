package br.com.dicadefarmacia.infra.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Remedio;
import br.com.dicadefarmacia.dto.RemedioFarmaciaDTO;
import br.com.dicadefarmacia.infra.utils.BeanToAliasTransformer;
import br.com.dicadefarmacia.infra.utils.StringUtils;

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

//	@Override
//	@SuppressWarnings("unchecked")
//	public List<Remedio> getRemedio(String nomeRemedio) {
//        Query query = openSession().createQuery("from Remedio rem where upper(rem.nomeCompleto) like :nome"); 
//        query.setParameter("nome", "%" + nomeRemedio.toUpperCase() + "%");
//        
//        return query.list();
//	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<RemedioFarmaciaDTO> getRemedio(String nomeRemedio) {
		StringBuilder sb = new StringBuilder();
		sb
			.append(" SELECT ")
			.append("	REM.ID AS idRemedio, ")
			.append("	REM.NOME_COMPLETO AS nomeCompleto, ")
			.append("	REM.NOME_FABRICANTE AS nomeFabricante, ")
			.append("	REM.GENERICO AS generico, ")
			.append("	REM.DOSAGEM AS dosagem, ")
			.append("	REM.FORMA AS forma, ")
			.append("	COALESCE(REM.FOTO, ' ') AS foto, ")
			.append("	REM.PRINCIPIO_ATIVO AS principioAtivo, ")
			.append("	FARM.ID AS idFarmacia, ")
			.append("	FARM.BAIRRO AS bairro, ")
			.append("	FARM.CIDADE AS cidade, ")
			.append("	FARM.ESTADO AS estado, ")
			.append("	FARM.LOGRADOURO AS logradouro, ")
			.append("	FARM.NOME AS nomeFarmacia, ")
			.append("	FARM.TELEFONE1 AS telefone1, ")
			.append("	COALESCE(FARM.TELEFONE2, ' ')  AS telefone2, ")
			.append("	RF.PRECO AS preco, ")
			.append("	COALESCE(RF.PRECO_PROMOCAO, RF.PRECO) AS precoPromocao ")
			.append(" FROM REMEDIO REM ")
			.append("	INNER JOIN REMEDIOFARMACIA RF ON REM.ID = RF.id_remedio ")
			.append("	INNER JOIN FARMACIA FARM ON FARM.ID = RF.ID_FARMACIA ")
			.append(" WHERE ")
			.append("	UPPER(REM.NOME_COMPLETO) LIKE :nome ")
			.append(" ORDER BY ")
			.append("	RF.PRECO ");
		Query query = openSession().createSQLQuery(sb.toString());
		if (StringUtils.isNuloOuBranco(nomeRemedio)) {
			query.setParameter("nome", "%");
		} else {
			query.setParameter("nome", "%" + nomeRemedio.toUpperCase() + "%");
		}
		
		query.setResultTransformer(BeanToAliasTransformer.aliasToBean(RemedioFarmaciaDTO.class));
		
		return query.list();
	}
}
