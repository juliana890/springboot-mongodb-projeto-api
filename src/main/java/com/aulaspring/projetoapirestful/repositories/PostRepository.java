package com.aulaspring.projetoapirestful.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aulaspring.projetoapirestful.domain.Post;

//Criamos um repository para nosso banco mongoDB, todas as operações já estão incluídas
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//Para nossa busca ignorar maiúsculas e minúsculas acrescentamos o IgnoreCase
	List<Post> findByTitleContainingIgnoreCase(String text);

}
