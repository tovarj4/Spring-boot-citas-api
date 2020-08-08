package com.tovar.citas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.tovar.citas.commons.GenericServiceImpl;
import com.tovar.citas.dao.api.UsuarioDaoAPI;
import com.tovar.citas.model.Usuario;
import com.tovar.citas.service.api.UsuarioServiceAPI;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioServiceAPI {
	
	@Autowired
	UsuarioDaoAPI usuarioDaoApi;

	@Override
	public CrudRepository<Usuario, Integer> getDao() {
		return usuarioDaoApi;
	}
}
