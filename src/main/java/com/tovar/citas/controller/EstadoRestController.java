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

import com.tovar.citas.model.Estado;
import com.tovar.citas.service.api.EstadoServiceAPI;

@RestController
@RequestMapping(value = "/api/v1/estado")
@CrossOrigin("*")
public class EstadoRestController {
	
	@Autowired
	private EstadoServiceAPI estadoServiceApi;
	
	@GetMapping(value = "/all")
	public List<Estado> getAll(){
		return estadoServiceApi.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Estado find(@PathVariable int id) {
		return estadoServiceApi.get(id);
		
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Estado> save(@RequestBody Estado estado){
		Estado obj = estadoServiceApi.save(estado);
		return new ResponseEntity<Estado>(obj,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Estado> delete(@PathVariable int id) {
		Estado estado = estadoServiceApi.get(id);
		if (estado != null) {
			estadoServiceApi.delete(id);
		}else {
			return new ResponseEntity<Estado>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Estado>(estado, HttpStatus.OK);
	}
	
	@PostMapping(value = "/update/{id}")
	public ResponseEntity<Estado> update(@RequestBody Estado estado, @PathVariable int id){
		
		Estado edo = estadoServiceApi.get(id);
		if (edo == null) {
			return new ResponseEntity<Estado>(HttpStatus.NO_CONTENT);
		}
		edo.setEstado(estado.getEstado());
		estadoServiceApi.save(edo);
		return new ResponseEntity<Estado>(edo, HttpStatus.OK);
	}
	 

}
