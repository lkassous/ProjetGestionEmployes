package com.leith.employes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leith.employes.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
