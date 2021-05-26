package com.mordor.mordorLloguer.model;

import java.util.Comparator;

public class ComparatorEmpleadoDomicilio implements Comparator<Empleado> {

	@Override
	public int compare(Empleado e1, Empleado e2) {
			
		if(e1.getDomicilio() == null) {
			
				return 1;
				
			}else if(e2.getDomicilio() == null) {
				
				return -1;
				
			}else {
				
				return e1.getDomicilio().compareTo(e2.getDomicilio());
			}
		
	}

	
}
