package br.com.dicadefarmacia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Remedio;
import br.com.dicadefarmacia.dto.RemedioFarmaciaDTO;
import br.com.dicadefarmacia.infra.dao.RemedioDAO;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Service
@Transactional
public class RemedioServiceImpl implements RemedioService {

	@Autowired
	private RemedioDAO remedioDAO;

	public void addRemedio(Remedio remedio) {
		remedioDAO.addRemedio(remedio);
	}

	public List<Remedio> listRemedio() {
		return remedioDAO.listRemedio();
	}

	public void removeRemedio(Long id) {
		remedioDAO.removeRemedio(id);
	}

	public void updateRemedio(Remedio remedio) {
		remedioDAO.updateRemedio(remedio);
	}
	
	public List<RemedioFarmaciaDTO> getRemedio(String nomeRemedio) {
		return remedioDAO.getRemedio(nomeRemedio);
	}
}
