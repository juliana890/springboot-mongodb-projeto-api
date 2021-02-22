package com.aulaspring.projetoapirestful.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.aulaspring.projetoapirestful.domain.Post;
import com.aulaspring.projetoapirestful.domain.User;
import com.aulaspring.projetoapirestful.dto.AuthorDTO;
import com.aulaspring.projetoapirestful.repositories.PostRepository;
import com.aulaspring.projetoapirestful.repositories.UserRepository;

//Essa classe será nossa base de dados de instanciação para realizar os testes
@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//Limpado nossas coleções no db
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); //Salvamos os usuários primeiro para que seja possível associa-los ao post
		
		//Nessa aplicação os Posts que irão conter os Users
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2)); //Adicionando os posts da User Maria
		userRepository.save(maria);
		
		
	}

}
