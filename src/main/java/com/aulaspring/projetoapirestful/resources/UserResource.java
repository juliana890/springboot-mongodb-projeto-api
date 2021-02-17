package com.aulaspring.projetoapirestful.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.projetoapirestful.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//Notation para indicar que nosso método é do tipo GET, também podemos utilizar o @RequestMapping(method = RequestMethod.GET)
	//Retornamos o método ResponseEntity pq ele vem com todo uma estrutura de objeto para http
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> obj = new ArrayList<>();
		
		User maria = new User("1", "Maria Green", "mariagreen@gmail.com");
		User alex = new User("2", "Alex Black", "alexblack@gmail.com");
		User bob = new User("3", "Bob Brown", "bobbrown@gmail.com");
		
		obj.addAll(Arrays.asList(maria, alex, bob));
		
		return ResponseEntity.ok().body(obj);
	}

}
