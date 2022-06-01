package com.leith.employes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.leith.employes.models.Role;
import com.leith.employes.models.User;
import com.leith.employes.repository.RoleRepository;
import com.leith.employes.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository UserRepository;
	
	@Autowired
	RoleRepository roleRep;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return UserRepository.findAll();
	}

	@Override
	public User saveUser(User e) {
		// TODO Auto-generated method stub
		return UserRepository.save(e);
	}

	@Override
	public User updateUser(User e) {
		// TODO Auto-generated method stub
		return UserRepository.save(e);
	}

	@Override
	public void deleteUser(User e) {
		// TODO Auto-generated method stub
		UserRepository.delete(e);
		
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		UserRepository.deleteById(id);	
		
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return UserRepository.getById(id);
	}

	@Override
	public Page<User> getAllUsersParPage(int page, int size) {
		// TODO Auto-generated method stub
		return UserRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return UserRepository.findByUsername(username);
	}

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addRoleToUser(String username, String rolename) {
		// TODO Auto-generated method stub
		User usr = UserRepository.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		
		usr.getRoles().add(r);
		return usr;
	}

	
}
