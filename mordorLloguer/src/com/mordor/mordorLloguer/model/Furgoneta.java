package com.mordor.mordorLloguer.model;

import java.sql.Date;

public class Furgoneta extends Vehiculo {

	float mma;

	public Furgoneta(String m, float p, String marca, String desc, String col, float cil, Date fechaAdq, String estado,
			String carnet,float mma) {
		super(m, p, marca, desc, col, cil, fechaAdq, estado, carnet);
		
		this.mma = mma;
	}

	public float getMma() {
		return mma;
	}
	
	
	
	
	


}
