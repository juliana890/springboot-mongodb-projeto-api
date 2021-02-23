package com.aulaspring.projetoapirestful.repositories;

import java.util.Date;
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
	
	//Método de busca com vários critérios
	//Buscando um certo texto que esteja entre as datas mencionadas OU pertença ao titúlo, corpo, comentário do post
	//$gte corresponde ao operador lógico >=
	//$lte corresponde ao operador lógico <=
	//title de acordo com o parâmetro de titúlo na nossa classe Post
	//body de acordo com o parâmetro de corpo na nossa classe Post
	//comments.text de acordo com o nosso parâmetro de comentário na nossa classe Post, .text buscando o texto na classe CommentDTO por ser uma lista
	@Query("{ $and: [ {date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
