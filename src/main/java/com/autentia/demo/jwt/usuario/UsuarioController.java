package com.autentia.demo.jwt.usuario;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

	private UsuarioRepository usuarioRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/users/")
	public void saveUsuario(@RequestBody Usuario user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usuarioRepository.save(user);
	}

	@GetMapping("/users/")
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/users/{username}")
	public Usuario getUsuario(@PathVariable String username) {
		return usuarioRepository.findByUsername(username);
	}
	
	/*Recupera el usuario y que usuario, Sólo nos devolvió un username*/
	@GetMapping("/user/auth")
	public Usuario getAuthUser() {
		/*Para conocer el usuario que está realizando la petición y para no tener que mandarlo desde el body o algo así
		 * el API lo puede buscar de forma automática.
		 * Security recupera el nombre de usuario. Lanza una petición y este devuelve los datos del usuario mediante el token
		 * Todos los tokens son diferentes*
		 * 
		 * Al generar la petición automáticamente devuelve valores del usuario*/
		return usuarioRepository.findByUsername((String) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()));

	}
}
