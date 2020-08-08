package com.tovar.citas.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.tovar.citas.commons.GenericServiceImpl;
import com.tovar.citas.dao.api.DomicilioDaoAPI;
import com.tovar.citas.model.Domicilio;
import com.tovar.citas.service.api.DomicilioServiceAPI;

@Service
public class DomicilioServiceImpl extends GenericServiceImpl<Domicilio, Integer> implements DomicilioServiceAPI {
	
	@Autowired
	DomicilioDaoAPI domiciliosDaoApi;

	@Override
	public CrudRepository<Domicilio, Integer> getDao() {
		return domiciliosDaoApi;
	}

	
}
