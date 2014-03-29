package br.com.dicadefarmacia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dicadefarmacia.domain.Role;
import br.com.dicadefarmacia.infra.dao.RoleDAO;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
    private RoleDAO roleDAO; 
    
	@Override
	public void addRole(Role role) {
		roleDAO.addRole(role);
	}

	@Override
	public List<Role> listRole() {
		return roleDAO.listRole();
	}

	@Override
	public void removeRole(Long id) {
		roleDAO.removeRole(id);
	}

	@Override
	public Role buscaRole(Long id) {
		return roleDAO.buscaRole(id);
	}

	@Override
	public void updateRole(Role role) {
		roleDAO.updateRole(role);
	}

}
