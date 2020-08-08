package com.tovar.citas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "domicilios")
public class Domicilio {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String calle;
	@Column
	private int numero_ext;
	@Column
	private int numero_int;
	
	@ManyToOne
	@JoinColumn(name = "id_codigo_postal")
	CodigoPostal codigoPostal;
	
	public Domicilio() {}
	
	public Domicilio(int id, String calle, int numero_ext, int numero_int) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero_ext = numero_ext;
		this.numero_int = numero_int;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero_ext() {
		return numero_ext;
	}

	public void setNumero_ext(int numero_ext) {
		this.numero_ext = numero_ext;
	}

	public int getNumero_int() {
		return numero_int;
	}

	public void setNumero_int(int numero_int) {
		this.numero_int = numero_int;
	}

	public CodigoPostal getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(CodigoPostal codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	
	
	
	

}
