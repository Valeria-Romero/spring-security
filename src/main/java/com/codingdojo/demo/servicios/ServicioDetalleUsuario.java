package com.codingdojo.demo.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codingdojo.demo.modelos.Role;
import com.codingdojo.demo.modelos.User;
import com.codingdojo.demo.repositorios.RepositorioUsuarios;

@Service
public class ServicioDetalleUsuario implements UserDetailsService {
	
	@Autowired
	private RepositorioUsuarios repo_usuarios;
	
//	Obtener datos del usuario
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = repo_usuarios.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	}
	
//	Revisar los permisos del usuario
	private List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
	}
}
