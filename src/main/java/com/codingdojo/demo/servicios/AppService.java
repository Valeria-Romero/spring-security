package com.codingdojo.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.demo.modelos.User;
import com.codingdojo.demo.repositorios.RepositorioRoles;
import com.codingdojo.demo.repositorios.RepositorioUsuarios;

@Service
public class AppService {
	
	@Autowired
	private RepositorioUsuarios repo_usuarios;
	
	@Autowired
	private RepositorioRoles repo_roles;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	Regresa un usuario en base a su username
	public User findByUsername(String username) {
		return repo_usuarios.findByUsername(username);
	}
	
	public void saveWithAdminRole(User user) {
//		user.getPassword nos va obtener la contraseña sin encriptar, lo que usuario escribe en el form
//		bCrypPasswordEncoder.encode() se va a encargar de encriptar esa contraseña
//		setPassword() nos guarda en el objeto de usuario la contraseña encriptada como su nuevo password
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(repo_roles.findByName("ROLE_ADMIN"));
		repo_usuarios.save(user);
	}
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(repo_roles.findByName("ROLE_USER"));
		repo_usuarios.save(user);
	}
}
