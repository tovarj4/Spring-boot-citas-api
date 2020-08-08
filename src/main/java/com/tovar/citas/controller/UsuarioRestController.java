package com.tovar.citas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tovar.citas.model.Usuario;
import com.tovar.citas.service.api.UsuarioServiceAPI;

@RestController
@RequestMapping(value = "/api/v1/usuario/")
@CrossOrigin("*")
public class UsuarioRestController {
	@Autowired
	private UsuarioServiceAPI usuarioServiceAPI;
	
	@GetMapping(value = "/all")
	public List<Usuario> getAll(){
		return usuarioServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Usuario find(@PathVariable int id) {
		return usuarioServiceAPI.get(id);
		
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
		Usuario obj = usuarioServiceAPI.save(usuario);
		return new ResponseEntity<Usuario>(obj,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable int id) {
		Usuario usuario = usuarioServiceAPI.get(id);
		if (usuario != null) {
			usuarioServiceAPI.delete(id);
		}else {
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PostMapping(value = "/update/{id}")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable int id){
		
		Usuario obj = usuarioServiceAPI.get(id);
		if (obj == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		}
		
		obj.setNombre(usuario.getNombre());
		obj.setApellidoPaterno(usuario.getApellidoPaterno());
		obj.setApellidoMaterno(usuario.getApellidoMaterno());
		obj.setEmail(usuario.getEmail());
		obj.setFechaNacimiento(usuario.getFechaNacimiento());
		obj.setTelefono(usuario.getTelefono());
		obj.setTipoUsuario(usuario.getTipoUsuario());
		obj.setDomicilio(usuario.getDomicilio());
		
		usuarioServiceAPI.save(obj);
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}
}
