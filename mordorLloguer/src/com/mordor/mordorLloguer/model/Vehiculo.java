package com.mordor.mordorLloguer.model;

import java.sql.Date;

public abstract class Vehiculo {

	String matricula;
	float precio;
	String marca;
	String descripcion;
	String color;
	String motor;
	float cilindrada;
	Date fechaAqd;
	String estado;
	String carnet;

	public Vehiculo(String m, float p, String marca, String desc, String col, float cil, Date fechaAdq, String estado,
			String carnet) {
		matricula = m;
		this.marca = marca;
		descripcion = desc;
		color = col;
		cil = cilindrada;
		fechaAdq = fechaAdq;
		this.estado = estado;
		this.carnet = carnet;
	}

	public String getMatricula() {
		return matricula;
	}

	public float getPrecio() {
		return precio;
	}

	public String getMarca() {
		return marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getColor() {
		return color;
	}

	public String getMotor() {
		return motor;
	}

	public float getCilindrada() {
		return cilindrada;
	}

	public Date getFechaAqd() {
		return fechaAqd;
	}

	public String getEstado() {
		return estado;
	}

	public String getCarnet() {
		return carnet;
	}

	
}
