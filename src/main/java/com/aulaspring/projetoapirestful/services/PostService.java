package com.aulaspring.projetoapirestful.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.projetoapirestful.domain.Post;
import com.aulaspring.projetoapirestful.repositories.PostRepository;
import com.aulaspring.projetoapirestful.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	//Para instânciar um objeto automaticamente utilizamos a notation @Autowired
	//Mecanismo de injeção de dependência automático do Spring
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
//	public List<Post> findByTitle(String text){
//		return repo.findByTitleContainingIgnoreCase(text);
//	}
	
}
