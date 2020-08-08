package com.tovar.citas.service.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tovar.citas.model.CodigoPostal;

@Service
public interface CodigoPostalRepository extends JpaRepository<CodigoPostal, Integer> {
	List<CodigoPostal> findByCodigoPostal(int codigoPostal);
}	// List<Movie> findByTitle(String title, Sort sort);
