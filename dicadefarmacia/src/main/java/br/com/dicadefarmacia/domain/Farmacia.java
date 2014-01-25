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
@Table(name="FARMACIA")
public class Farmacia {

	@Id
    @Column(name="ID")
    @GeneratedValue
	private Long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="TELEFONE1")
	private String telefone1;
	
	@Column(name="TELEFONE2")
	private String telefone2;
	
	@Column(name="END_LOGRADOURO")
	private String logradouro;
	
	@Column(name="END_NUMERO")
	private Long numero;
	
	@Column(name="END_COMPLEMENTO")
	private String complemento;
	
	@Column(name="END_BAIRRO")
	private String bairro;
	
	@Column(name="END_CIDADE")
	private String cidade;
	
	@Column(name="END_CEP")
	private String cep;
	
	@Column(name="END_ESTADO")
	private String estado;

	@Column(name="END_PAIS")
	private String pais;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return getNome() + " - " + getLogradouro() + " - " + getBairro();
	}
}
