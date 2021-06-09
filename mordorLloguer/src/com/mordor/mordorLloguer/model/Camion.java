package com.mordor.mordorLloguer.model;

import java.sql.Date;

public class Camion extends Vehiculo {

	String matricula;
	int numruedas;
	float mma;

	public Camion(String m, float p, String marca, String desc, String col, float cil, Date fechaAdq, String estado,
			String carnet, int numruedas, float mma) {
		super(m, p, marca, desc, col, cil, fechaAdq, estado, carnet);

		matricula = m;
		this.numruedas = numruedas;
		this.mma = mma;

	}

}
