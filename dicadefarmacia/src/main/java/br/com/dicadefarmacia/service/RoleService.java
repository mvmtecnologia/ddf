package br.com.dicadefarmacia.service;

import java.util.List;

import br.com.dicadefarmacia.domain.Role;

public interface RoleService {

	public void addRole(Role role);
    public List<Role> listRole();
    public void removeRole(Long id);
    public Role buscaRole(Long id);
    public void updateRole(Role role);
}
