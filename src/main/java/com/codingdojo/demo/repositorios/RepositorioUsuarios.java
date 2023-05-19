package com.codingdojo.demo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.demo.modelos.User;

@Repository
public interface RepositorioUsuarios extends CrudRepository <User, Long>{
	User findByUsername(String username);
}
