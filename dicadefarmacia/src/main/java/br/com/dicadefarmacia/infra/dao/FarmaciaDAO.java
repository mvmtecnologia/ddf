package br.com.dicadefarmacia.infra.dao;

import java.util.List;

import br.com.dicadefarmacia.domain.Farmacia;

public interface FarmaciaDAO {

	public void addFarmacia(Farmacia farmacia);
    public List<Farmacia> listFarmacia();
    public void removeFarmacia(Long id);
    public Farmacia buscaFarmacia(Long id);
    public void updateFarmacia(Farmacia farmacia);
}
