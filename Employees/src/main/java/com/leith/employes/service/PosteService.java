package com.leith.employes.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.leith.employes.models.Poste;

public interface PosteService {
	List<Poste> getAllPostes();
	Poste savePoste(Poste poste);
	Page<Poste> getAllPostesParPage(int page, int size);
	void deletePosteById(Long id);
	Poste getPoste(Long id);
	Poste updatePoste(Poste p);
}
