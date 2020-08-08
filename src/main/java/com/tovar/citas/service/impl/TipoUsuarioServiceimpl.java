package com.tovar.citas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.tovar.citas.commons.GenericServiceImpl;
import com.tovar.citas.dao.api.TipoUsuarioDaoAPI;
import com.tovar.citas.model.TipoUsuario;
import com.tovar.citas.service.api.TipoUsuarioServiceAPI;

@Service
public class TipoUsuarioServiceimpl extends GenericServiceImpl<TipoUsuario, Integer> implements TipoUsuarioServiceAPI {
	
	@Autowired
	TipoUsuarioDaoAPI tipoUsuarioDaoApi;

	@Override
	public CrudRepository<TipoUsuario, Integer> getDao() {
		return tipoUsuarioDaoApi;
	}
	
	
}
