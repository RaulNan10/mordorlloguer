package com.mordor.mordorLloguer.model;

import java.sql.Date;

public class Car extends Vehiculo {

	int plazas;
	int puertas;
	

	
	public Car(String m, float p, String marca, String desc, String col, float cil, Date fechaAdq, String estado,
			String carnet, int plazas, int puertas) {
		super(m, p, marca, desc, col, cil, fechaAdq, estado, carnet);
		
		this.plazas = plazas;
		this.puertas = puertas;
		
	}



	public String getMatricula() {
		return matricula;
	}



	public int getPlazas() {
		return plazas;
	}



	public int getPuertas() {
		return puertas;
	}
	
	

}
