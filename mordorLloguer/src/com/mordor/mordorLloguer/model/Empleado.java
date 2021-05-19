package com.mordor.mordorLloguer.model;

import java.sql.Date;

public class Empleado {

	private int idEmpleado;
	private String DNI;
	private String nombre;
	private  String apellidos;
	private  String cp;
	private  String email;
	private  Date fecha;
	private  String cargo;
	private  String domicilio;
	private  String password;
	
	public Empleado(int idEmpleado, String dNI, String nombre, String apellidos, String cp, String email, Date fecha,
			String cargo, String domicilio, String password) {
		super();
		this.idEmpleado = idEmpleado;
		DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cp = cp;
		this.email = email;
		this.fecha = fecha;
		this.cargo = cargo;
		this.domicilio = domicilio;
		this.password = password;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", cp=" + cp + ", email=" + email + ", fecha=" + fecha + ", cargo=" + cargo + ", domicilio="
				+ domicilio + ", password=" + password + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Empleado) {
			Empleado e = (Empleado) obj;
			if(this.getDNI().compareTo(e.getDNI())==0)
				return true;
			else 
				return false;
		}else
			return false;
		
	}
	
	
	
	
	
	
	
}
