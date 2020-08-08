package com.tovar.citas.controller;

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

import com.tovar.citas.model.Domicilio;
import com.tovar.citas.service.api.DomicilioServiceAPI;

@RestController
@RequestMapping(value = "/api/v1/domicilio/")
@CrossOrigin("*")
public class DomicilioRestController {
	
	@Autowired
	DomicilioServiceAPI domiciliosServiceAPI;
	
	@GetMapping(value = "/find/{id}")
	public Domicilio find(@PathVariable int id) {
		return domiciliosServiceAPI.get(id);
	}
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Domicilio> delete(@PathVariable int id) {
		Domicilio domicilio = domiciliosServiceAPI.get(id);
		
		if ( domicilio != null) {
			domiciliosServiceAPI.delete(id);
		}else
		{
			return new ResponseEntity<Domicilio>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Domicilio>(domicilio,HttpStatus.OK);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Domicilio> save(@RequestBody Domicilio domicilio) {
		Domicilio obj = domiciliosServiceAPI.save(domicilio);
		return new ResponseEntity<Domicilio>(obj,HttpStatus.OK);
	}

}
