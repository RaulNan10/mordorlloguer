package com.mordor.mordorLloguer;

import java.awt.EventQueue;

import com.alee.laf.WebLookAndFeel;
import com.mordor.mordorLloguer.model.AlmacenDatosDB;
import com.mordor.mordorLloguer.model.MyOracleDataBase;
import com.mordor.mordorlloguer.controladores.ControladorPrincipal;
import com.mordor.mordorlloguer.vistas.VistaPrincipal;

public class App {
public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					WebLookAndFeel.install ();
					VistaPrincipal frame = new VistaPrincipal();
					AlmacenDatosDB model = new MyOracleDataBase();
					ControladorPrincipal cp = new ControladorPrincipal(frame,model);
					cp.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}

