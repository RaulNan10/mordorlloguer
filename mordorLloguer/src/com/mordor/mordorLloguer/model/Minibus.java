package com.mordor.mordorLloguer.model;

import java.sql.Date;

public class Minibus extends Vehiculo {

	int numplazas;
	float medida;

	public Minibus(String m, float p, String marca, String desc, String col, float cil, Date fechaAdq, String estado,
			String carnet, int numplazas, float medida) {
		super(m, p, marca, desc, col, cil, fechaAdq, estado, carnet);

		this.numplazas = numplazas;
		this.medida = medida;
	}

	public String getMatricula() {
		return matricula;
	}

	public int getNumplazas() {
		return numplazas;
	}

	public float getMedida() {
		return medida;
	}
	
	

}
