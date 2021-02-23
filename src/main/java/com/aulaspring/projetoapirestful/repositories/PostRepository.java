package com.aulaspring.projetoapirestful.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.aulaspring.projetoapirestful.domain.Post;

//Criamos um repository para nosso banco mongoDB, todas as operações já estão incluídas
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//Método personalizado
	//trocamos pattern por ?0 significa que iremos obter o primeiro parâmetro obtido no método
	//$options: 'i' ignora maiúsculas e minúsculas
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	//Para nossa busca ignorar maiúsculas e minúsculas acrescentamos o IgnoreCase
	List<Post> findByTitleContainingIgnoreCase(String text);

}
