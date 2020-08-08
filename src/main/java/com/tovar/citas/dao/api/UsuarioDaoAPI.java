package com.tovar.citas.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.tovar.citas.model.Usuario;

public interface UsuarioDaoAPI extends CrudRepository<Usuario, Integer> {

}
