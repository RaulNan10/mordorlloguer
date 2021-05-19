package com.mordor.mordorLloguer.model;

import java.util.ArrayList;

public interface AlmacenDatosDB {

	public ArrayList<Empleado> getEmpleados();
	public ArrayList<Empleado> getEmpleadosPorCP(String cp);
	public ArrayList<Empleado> getEmpleadosPorCargo(String cargo);
	public Empleado getEmpleadoPorDNI(String dni);
	public boolean deleteEmpleado(String dni);
	public boolean authenticate (String login, String passwd);
	public boolean updateEmpleado(Empleado empleado);
	public boolean insertaEmpleado(Empleado empleado);
	
	
}
