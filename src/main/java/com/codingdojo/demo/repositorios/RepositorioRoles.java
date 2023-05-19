package com.codingdojo.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.demo.modelos.Role;

@Repository
public interface RepositorioRoles extends CrudRepository <Role, Long> {
	List<Role> findAll();
	List<Role> findByName(String name);
}
