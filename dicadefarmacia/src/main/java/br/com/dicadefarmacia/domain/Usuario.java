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
@Table(name="USUARIO")
public class Usuario {

	@Id
    @Column(name="ID")
    @GeneratedValue
	private Long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="EMAIL")
	private String email;

	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
