package br.com.dicadefarmacia.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.dicadefarmacia.infra.utils.StringUtils;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Entity
@Table(name="USUARIO")
@SuppressWarnings("serial")
public class Usuario implements Serializable {

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

	@OneToOne(cascade=CascadeType.ALL)  
    @JoinTable(name="USER_ROLES", joinColumns = {@JoinColumn(name="ID_USER", referencedColumnName="id")},  
        inverseJoinColumns = {@JoinColumn(name="ID_ROLE", referencedColumnName="id")}  
    )  
    private Role role;
	
	@Column(name="SENHA")
	private String senha;
	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private Set<Farmacia> farmacias;
	
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Farmacia> getFarmacias() {
		return farmacias;
	}

	public void setFarmacias(Set<Farmacia> farmacias) {
		this.farmacias = farmacias;
	}

	
	@Override
	public String toString() {
		return StringUtils
				 .normalizaToString("id=",this.id,
						 "cpf=",this.cpf,
						 "nome=",this.nome);
	}
}
