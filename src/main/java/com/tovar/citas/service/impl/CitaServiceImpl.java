package com.tovar.citas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.tovar.citas.commons.GenericServiceImpl;
import com.tovar.citas.dao.api.CitaDaoAPI;
import com.tovar.citas.model.Cita;
import com.tovar.citas.service.api.CitaServiceAPI;

@Service
public class CitaServiceImpl extends GenericServiceImpl<Cita, Integer> implements CitaServiceAPI {

	@Autowired
	CitaDaoAPI citaDaoAPI;

	@Override
	public CrudRepository<Cita, Integer> getDao() {
		return citaDaoAPI;
	}

}
