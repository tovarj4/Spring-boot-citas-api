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

import com.tovar.citas.model.TipoUsuario;
import com.tovar.citas.service.api.TipoUsuarioServiceAPI;

@RestController
@RequestMapping(value = "/api/v1/tipo-usuario/")
@CrossOrigin("*")
public class TipuUsuarioRestController {

	@Autowired
	private TipoUsuarioServiceAPI tipoUsuarioServiceAPI;
	
	@GetMapping(value = "/all")
	public List<TipoUsuario> getAll(){
		return tipoUsuarioServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public TipoUsuario find(@PathVariable int id) {
		return tipoUsuarioServiceAPI.get(id);
		
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<TipoUsuario> save(@RequestBody TipoUsuario TipoUsuario){
		TipoUsuario obj = tipoUsuarioServiceAPI.save(TipoUsuario);
		return new ResponseEntity<TipoUsuario>(obj,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<TipoUsuario> delete(@PathVariable int id) {
		TipoUsuario tipoUsuario = tipoUsuarioServiceAPI.get(id);
		if (tipoUsuario != null) {
			tipoUsuarioServiceAPI.delete(id);
		}else {
			return new ResponseEntity<TipoUsuario>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<TipoUsuario>(tipoUsuario, HttpStatus.OK);
	}
	
	@PostMapping(value = "/update/{id}")
	public ResponseEntity<TipoUsuario> update(@RequestBody TipoUsuario TipoUsuario, @PathVariable int id){
		
		TipoUsuario edo = tipoUsuarioServiceAPI.get(id);
		if (edo == null) {
			return new ResponseEntity<TipoUsuario>(HttpStatus.NO_CONTENT);
		}
		edo.setTipoUsuario(TipoUsuario.getTipoUsuario());
		tipoUsuarioServiceAPI.save(edo);
		return new ResponseEntity<TipoUsuario>(edo, HttpStatus.OK);
	}
}
