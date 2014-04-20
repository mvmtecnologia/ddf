package br.com.dicadefarmacia.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Entity
@SuppressWarnings("serial")
@Table(name = "REMEDIOFARMACIA")
public class RemedioFarmacia implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;
	
	@Column(name = "PRECO", nullable = false)
	private Double preco;
	
	@Column(name = "PRECO_PROMOCAO")
	private Double precoPromocao;
	
	@ManyToOne(targetEntity = Remedio.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_remedio")
	private Remedio remedio;
	
	@ManyToOne(targetEntity = Farmacia.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_farmacia")
	private Farmacia farmacia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPrecoPromocao() {
		return precoPromocao;
	}

	public void setPrecoPromocao(Double precoPromocao) {
		this.precoPromocao = precoPromocao;
	}

	public Remedio getRemedio() {
		return remedio;
	}

	public void setRemedio(Remedio remedio) {
		this.remedio = remedio;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}
	
}
