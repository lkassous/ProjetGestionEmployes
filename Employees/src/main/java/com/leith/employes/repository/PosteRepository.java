package com.leith.employes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.leith.employes.models.Poste;
@RepositoryRestResource(path = "rest")
public interface PosteRepository extends JpaRepository<Poste, Long> {

}
