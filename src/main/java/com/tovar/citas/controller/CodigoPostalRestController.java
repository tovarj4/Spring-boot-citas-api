package com.tovar.citas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tovar.citas.model.CodigoPostal;
import com.tovar.citas.service.api.CodigoPostalRepository;
import com.tovar.citas.service.api.CodigoPostalServiceAPI;

@RestController
@RequestMapping(value="/api/v1/codigos-postales/")
public class CodigoPostalRestController {
	@Autowired
	private CodigoPostalServiceAPI codigoPostalServiceAPI;
	@Autowired
	private CodigoPostalRepository codigoPostalRepository;
	
	@GetMapping(value = "/all")
	public List<CodigoPostal> getAll(){
		return codigoPostalServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{codigoPostal}")
	public List<CodigoPostal> findCp(@PathVariable int codigoPostal) {
		return codigoPostalRepository.findByCodigoPostal(codigoPostal);
		//return codigoPostalServiceAPI.getAll().stream().filter(cp -> cp.getCodigoPostal() == codigoPostal).collect(Collectors.toList());
		
	}
	

}
