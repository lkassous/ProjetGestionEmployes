package com.leith.employes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.leith.employes.models.Poste;
import com.leith.employes.repository.PosteRepository;
@Service
public class PosteServiceImpl implements PosteService {
  @Autowired
  PosteRepository posteRepository;
	@Override
	public List<Poste> getAllPostes() {
		return posteRepository.findAll() ;
	}

	@Override
	public Poste savePoste(Poste poste) {
		
		return posteRepository.save(poste);
	}

	@Override
	public Page<Poste> getAllPostesParPage(int page, int size) {
		return  posteRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public void deletePosteById(Long id) {
          posteRepository.deleteById(id);		
	}

	@Override
	public Poste getPoste(Long id) {
		return posteRepository.findById(id).get();
	}

	@Override
	public Poste updatePoste(Poste p) {
		return posteRepository.save(p);
	}

}
