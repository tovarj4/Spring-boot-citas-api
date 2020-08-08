package com.tovar.citas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.tovar.citas.commons.GenericServiceImpl;
import com.tovar.citas.dao.api.CodigoPostalDaoAPI;
import com.tovar.citas.model.CodigoPostal;
import com.tovar.citas.service.api.CodigoPostalServiceAPI;

@Service
public class CodigoPostalServiceImpl extends GenericServiceImpl<CodigoPostal, Integer> implements CodigoPostalServiceAPI {
	
	@Autowired
	CodigoPostalDaoAPI codigoPostalDaoApi;

	@Override
	public CrudRepository<CodigoPostal, Integer> getDao() {
		return codigoPostalDaoApi;
	}

}
