package com.tovar.citas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.tovar.citas.commons.GenericServiceImpl;
import com.tovar.citas.dao.api.EstadoDaoAPI;
import com.tovar.citas.model.Estado;
import com.tovar.citas.service.api.EstadoServiceAPI;

@Service
public class EstadoServiceImpl extends GenericServiceImpl<Estado, Integer> implements EstadoServiceAPI  {

	@Autowired
	EstadoDaoAPI EstadoDaoApi;

	@Override
	public CrudRepository<Estado, Integer> getDao() {
		return EstadoDaoApi;
	}
}
