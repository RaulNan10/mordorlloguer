package com.mordor.mordorLloguer.model;

import java.util.Comparator;

public class ComparatorEmpleadoCP implements Comparator<Empleado>{

	@Override
	public int compare(Empleado e1, Empleado e2) {
			
		if(e1.getCp() == null) {
			
				return 1;
				
			}else if(e2.getCp() == null) {
				
				return -1;
				
			}else {
				
				return e1.getCp().compareTo(e2.getCp());
			}
		
	}

	
}

