package com.aulaspring.projetoapirestful.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.aulaspring.projetoapirestful.domain.User;
import com.aulaspring.projetoapirestful.repositories.UserRepository;

//Essa classe será nossa base de dados de instanciação para realizar os testes
@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		UserRepository.deleteAll(); //Limpado nossa coleção no db
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		UserRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
