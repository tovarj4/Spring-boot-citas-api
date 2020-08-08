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

import com.tovar.citas.model.Cita;
import com.tovar.citas.service.api.CitaServiceAPI;


@RestController
@RequestMapping(value = "/api/v1/cita/")
@CrossOrigin("*")
public class CitaRestController {
	
	@Autowired
	CitaServiceAPI citaServiceAPI;
	
	@GetMapping(value = "/all")
	public List<Cita> getAll(){
		return citaServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Cita find(@PathVariable int id) {
		return citaServiceAPI.get(id);
		
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Cita> save(@RequestBody Cita cita){
		Cita obj = citaServiceAPI.save(cita);
		return new ResponseEntity<Cita>(obj,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Cita> delete(@PathVariable int id) {
		Cita obj = citaServiceAPI.get(id);
		if (obj != null) {
			citaServiceAPI.delete(id);
		}else {
			return new ResponseEntity<Cita>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Cita>(obj, HttpStatus.OK);
	}
	
	@PostMapping(value = "/update/{id}")
	public ResponseEntity<Cita> update(@RequestBody Cita cita, @PathVariable int id){
		
		Cita obj = citaServiceAPI.get(id);
		if (obj == null) {
			return new ResponseEntity<Cita>(HttpStatus.NO_CONTENT);
		}
		
		obj.setHoraMinuto(cita.getHoraMinuto());
		obj.setFecha(cita.getFecha());
		obj.setObservacionInicial(cita.getObservacionInicial());
		obj.setObservacionFinal(cita.getObservacionFinal());
		obj.setUsuario(cita.getUsuario());
		obj.setUsuarioc(cita.getUsuarioc());
		
		citaServiceAPI.save(obj);
		return new ResponseEntity<Cita>(obj, HttpStatus.OK);
	}
}
