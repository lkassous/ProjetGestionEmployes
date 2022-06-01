package com.leith.employes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leith.employes.models.Role;
import com.leith.employes.repository.RoleRepository;



@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findByRole(String role) {
		// TODO Auto-generated method stub
		return roleRepository.findByRole(role);
	}



}