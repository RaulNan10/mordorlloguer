package com.mordor.mordorlloguer.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class VistaVehiculos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVehiculos frame = new VistaVehiculos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaVehiculos() {
		setBounds(100, 100, 450, 300);

	}

}
