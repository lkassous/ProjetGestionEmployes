package com.leith.employes.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.leith.employes.models.Role;
import com.leith.employes.models.User;


public interface UserService {
	List <User> findAll();
	
	User saveUser(User e);
	User updateUser(User e);
	void deleteUser(User e);
	void deleteUserById(Long id);
	User getUser(Long id);
	Page<User> getAllUsersParPage(int page, int size);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}
