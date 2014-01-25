package br.com.dicadefarmacia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author viniciussoliva
 */
@Entity
@Table(name = "REMEDIO")
public class Remedio {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;

	@Column(name = "PRINCIPIO_ATIVO")
	private String principioAtivo;

	@Column(name = "NOME_COMPLETO")
	private String nomeCompleto;

	@Column(name = "NOME_FABRICANTE")
	private String nomeFabricante;

	@Column(name = "FOTO")
	private String foto;

	@Column(name = "PRECO")
	private Double preco;

	@Column(name = "GENERICO")
	private Boolean generico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeFabricante() {
		return nomeFabricante;
	}

	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Boolean getGenerico() {
		return generico;
	}

	public void setGenerico(Boolean generico) {
		this.generico = generico;
	}

}
