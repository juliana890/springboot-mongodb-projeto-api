package com.aulaspring.projetoapirestful.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//Fazemos o Serializable para os dados serem convertidos em bytes e serem possíveis a trafegação em rede
//Para informar que essa classe faz parte de uma coleção no MongoDB utilizamos as seguintes notations
//@Document(collection = "user"), para informar qo nome da coleção no MongoDB, se não ele pega o próprio nome da classe com letra min
@Document(collection = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	
	//Notation de referência para os posts criados pelos usuários
	@DBRef(lazy = true) //garantia de que os posts só serão carregados se forem acessados
	private List<Post> posts = new ArrayList<>();

	public User() {}

	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
