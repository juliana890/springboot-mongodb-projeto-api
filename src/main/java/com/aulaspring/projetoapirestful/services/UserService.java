package com.aulaspring.projetoapirestful.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.projetoapirestful.domain.User;
import com.aulaspring.projetoapirestful.dto.UserDTO;
import com.aulaspring.projetoapirestful.repositories.UserRepository;
import com.aulaspring.projetoapirestful.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	//Para instânciar um objeto automaticamente utilizamos a notation @Autowired
	//Mecanismo de injeção de dependência automático do Spring
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		//Precisamos instanciar um novo User
		User newObj = repo.findById(obj.getId()).get();
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	//Método que irá instânciar um User a partir do UserDTO
	//Fizemos na classe de serviço devido a facilidade de manutenção pois já temos os parâmetros de conexão com o BD
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}
