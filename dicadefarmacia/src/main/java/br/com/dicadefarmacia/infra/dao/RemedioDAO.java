package br.com.dicadefarmacia.infra.dao;

import java.util.List;

import br.com.dicadefarmacia.domain.Remedio;
import br.com.dicadefarmacia.dto.RemedioFarmaciaDTO;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
public interface RemedioDAO {

	public void addRemedio(Remedio remedio);

	public List<Remedio> listRemedio();

	public void removeRemedio(Long id);

	public void updateRemedio(Remedio remedio);
	
	public List<RemedioFarmaciaDTO> getRemedio(String nomeRemedio);
	
	public List<RemedioFarmaciaDTO> getRemedio(String nomeRemedio, String[] forma, String[] dosagem, String[] laboratorio, Double vlrMin, Double vlrMax);
}
