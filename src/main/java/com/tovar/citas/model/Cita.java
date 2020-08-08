package com.tovar.citas.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "citas")
public class Cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date fecha;
	private Time horaMinuto;
	private String observacionInicial;
	private String observacionFinal;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	Estado estado;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_citado")
	Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_citador")
	Usuario usuarioc;
	
	public Cita() {}
	
	

	public Cita(int id, Date fecha, Time horaMinuto, String observacionInicial, String observacionFinal, Estado estado,
			Usuario usuario, Usuario usuarioc) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.horaMinuto = horaMinuto;
		this.observacionInicial = observacionInicial;
		this.observacionFinal = observacionFinal;
		this.estado = estado;
		this.usuario = usuario;
		this.usuarioc = usuarioc;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHoraMinuto() {
		return horaMinuto;
	}

	public void setHoraMinuto(Time horaMinuto) {
		this.horaMinuto = horaMinuto;
	}

	public String getObservacionInicial() {
		return observacionInicial;
	}

	public void setObservacionInicial(String observacionInicial) {
		this.observacionInicial = observacionInicial;
	}

	public String getObservacionFinal() {
		return observacionFinal;
	}

	public void setObservacionFinal(String observacionFinal) {
		this.observacionFinal = observacionFinal;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioc() {
		return usuarioc;
	}

	public void setUsuarioc(Usuario usuarioc) {
		this.usuarioc = usuarioc;
	}
	
	
	

}
