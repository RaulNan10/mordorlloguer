package com.mordor.mordorLloguer.model;

import java.sql.Date;

public class Truck extends Vehiculo {

	private int numRuedas;
	private int mma;

	public Truck(String m, float p, String marca, String desc, String col, float cil, Date fechaAdq, String estado,
			String carnet,int numRuedas, int mma) {
		super(m, p, marca, desc, col, cil, fechaAdq, estado, carnet);
		this.matricula = super.getMatricula();
		this.numRuedas = numRuedas;
		this.mma = mma;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public int getMma() {
		return mma;
	}

	@Override
	public String toString() {
		return "Truck [matricula=" + matricula + ", numRuedas=" + numRuedas + ", mma=" + mma + "]";
	}

}