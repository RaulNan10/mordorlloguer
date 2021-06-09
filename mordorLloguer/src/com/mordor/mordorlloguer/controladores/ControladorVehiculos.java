package com.mordor.mordorlloguer.controladores;

import com.mordor.mordorLloguer.model.AlmacenDatosDB;
import com.mordor.mordorlloguer.vistas.VistaVehiculos;

public class ControladorVehiculos {

	private VistaVehiculos vista;
	private AlmacenDatosDB modelo;
	
	public ControladorVehiculos(VistaVehiculos v, AlmacenDatosDB modelo) {
		vista = v;
		this.modelo = modelo;
		
		inicializar();
	}

	private void inicializar() {
		
		vista.setVisible(true);
		
	}
	
}
