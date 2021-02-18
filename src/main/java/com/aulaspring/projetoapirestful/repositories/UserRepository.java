package com.aulaspring.projetoapirestful.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aulaspring.projetoapirestful.domain.User;

//Criamos um repository para nosso banco mongoDB, todas as operações já estão incluídas
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
