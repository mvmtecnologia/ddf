package br.com.dicadefarmacia.infra.dao;

import java.util.List;

import br.com.dicadefarmacia.domain.Remedio;

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
}
