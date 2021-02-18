package com.aulaspring.projetoapirestful.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.projetoapirestful.domain.User;
import com.aulaspring.projetoapirestful.dto.UserDTO;
import com.aulaspring.projetoapirestful.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//Notation para indicar que nosso método é do tipo GET, também podemos utilizar o @RequestMapping(method = RequestMethod.GET)
	//Retornamos o método ResponseEntity pq ele vem com todo uma estrutura de objeto para http
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		
		//Convertemos cada objeto original da nossa lista para um objeto do tipo UserDTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}

}
