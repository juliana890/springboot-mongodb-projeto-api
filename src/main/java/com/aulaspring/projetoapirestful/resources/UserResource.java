package com.aulaspring.projetoapirestful.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.projetoapirestful.domain.User;
import com.aulaspring.projetoapirestful.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//Notation para indicar que nosso método é do tipo GET, também podemos utilizar o @RequestMapping(method = RequestMethod.GET)
	//Retornamos o método ResponseEntity pq ele vem com todo uma estrutura de objeto para http
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> obj = service.findAll();
		
		return ResponseEntity.ok().body(obj);
	}

}
