package com.aulaspring.projetoapirestful.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.projetoapirestful.domain.User;
import com.aulaspring.projetoapirestful.repositories.UserRepository;

@Service
public class UserService {

	//Para instânciar um objeto automaticamente utilizamos a notation @Autowired
	//Mecanismo de injeção de dependência automático do Spring
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
