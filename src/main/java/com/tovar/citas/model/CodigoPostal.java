package com.tovar.citas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Id;


@Entity (name="codigos_postales")
public class CodigoPostal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name="codigo_postal")
	private int codigoPostal;
	@Column
	private String colonia;
	@Column(name = "tipo_colonia")
	private String tipoColonia;
	@Column
	private String municipio;
	@Column
	private String estado;
	@Column
	private String ciudad;
	
	
	
	
	public CodigoPostal() {}
	
	public CodigoPostal(int id, int codigoPostal, String municipio, String colonia) {
		super();
		this.id = id;
		this.codigoPostal = codigoPostal;
		this.municipio = municipio;
		this.colonia = colonia;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCodigoPostal() {
		return codigoPostal;
	}
	
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public String getColonia() {
		return colonia;
	}
	
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getTipoColonia() {
		return tipoColonia;
	}

	public void setTipoColonia(String tipoColonia) {
		this.tipoColonia = tipoColonia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	
	
	
		
		
}
