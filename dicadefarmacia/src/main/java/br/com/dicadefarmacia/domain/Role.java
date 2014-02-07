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
import javax.persistence.Table;

/**
 * @author rodolfo
 */
@Entity  
@Table(name="ROLES")
@SuppressWarnings("serial")
public class Role implements Serializable {

	@Id
    @Column(name="ID")
    @GeneratedValue
	private Long id;  
      
	@Column(name="ROLE")
    private String role;  
      
    @OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="USER_ROLES",   
        joinColumns = {@JoinColumn(name="ID_ROLE", referencedColumnName="id")},  
        inverseJoinColumns = {@JoinColumn(name="ID_USER", referencedColumnName="id")}  
    )  
    private Set<Usuario> userRoles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Usuario> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<Usuario> userRoles) {
		this.userRoles = userRoles;
	}
    
}
