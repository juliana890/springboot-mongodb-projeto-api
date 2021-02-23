package com.aulaspring.projetoapirestful.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.projetoapirestful.domain.Post;
import com.aulaspring.projetoapirestful.resources.util.URL;
import com.aulaspring.projetoapirestful.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	//http://localhost:8080/posts/titlesearch?text=
	//@RequestParam(value = "text", defaultValue = "") identificamos o parâmetro com o valor text de acordo com a nossa URL, caso o parâmetro não seja informado colocamos string vazia
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){ //Utilizamos o RequestParam pois iremos buscar o title na URL
		//Decodificamos o texto com o nosso método, pois não pode conter caractéres especiais e nem espaços
		text = URL.decodeParam(text);
		
		List<Post> list = service.findByTitle(text);
		
		return ResponseEntity.ok().body(list);
	}

}
