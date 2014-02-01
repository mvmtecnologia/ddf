package br.com.dicadefarmacia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Farmacia;
import br.com.dicadefarmacia.infra.dao.FarmaciaDAO;

@Service
@Transactional
public class FarmaciaServiceImpl implements FarmaciaService {

	@Autowired
    private FarmaciaDAO farmaciaDAO;
	
	public void addFarmacia(Farmacia farmacia) {
		farmaciaDAO.addFarmacia(farmacia);
	}

	public List<Farmacia> listFarmacia() {
		return farmaciaDAO.listFarmacia();
	}

	public void removeFarmacia(Long id) {
		farmaciaDAO.removeFarmacia(id);
	}

	public Farmacia buscaFarmacia(Long id) {
		return farmaciaDAO.buscaFarmacia(id);
	}

	public void updateFarmacia(Farmacia farmacia) {
		farmaciaDAO.updateFarmacia(farmacia);
	}

}
