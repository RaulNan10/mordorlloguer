package com.mordor.mordorLloguer.model;

import java.sql.Date;
import java.util.Arrays;

public class Cliente {
		
		private String dni;
		
		private String nombre;
		
		private String apellidos;
		
		private String domicilio;
		
		private String cp;
		
		private String email;
		
		private Date fechaNac;
		
		private String carnet;
		
		private byte[] foto;

		public Cliente(String dni, String nombre, String apellidos, String domicilio, String cp, String email,
				
				Date fechaNac, String carnet, byte[] foto) {
			
			this.dni = dni;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.domicilio = domicilio;
			this.cp = cp;
			this.email = email;
			this.fechaNac = fechaNac;
			this.carnet = carnet;
			this.foto = foto;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
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

		public String getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
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

		public Date getFechaNac() {
			return fechaNac;
		}

		public void setFechaNac(Date fechaNac) {
			this.fechaNac = fechaNac;
		}

		public String getCarnet() {
			return carnet;
		}

		public void setCarnet(String carnet) {
			this.carnet = carnet;
		}

		public byte[] getFoto() {
			return foto;
		}

		public void setFoto(byte[] foto) {
			this.foto = foto;
		}

		@Override
		public String toString() {
			return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", domicilio="
					+ domicilio + ", cp=" + cp + ", email=" + email + ", fechaNac=" + fechaNac + ", carnet=" + carnet
					+ "]";
		}
		
		

	}


