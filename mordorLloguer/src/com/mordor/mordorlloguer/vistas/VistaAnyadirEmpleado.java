package com.mordor.mordorlloguer.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class VistaAnyadirEmpleado extends JInternalFrame {
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldDireccion;
	private JTextField textFieldCP;
	private JTextField textFieldEmail;
	private JTextField textFieldNacimiento;
	private JTextField textFieldCargo;
	private JTextField textFieldContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAnyadirEmpleado frame = new VistaAnyadirEmpleado();
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
	public VistaAnyadirEmpleado() {
		setBounds(100, 100, 342, 409);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		
		JLabel lblDni = new JLabel("DNI");
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		
		JLabel lblCp = new JLabel("CP");
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		
		textFieldNacimiento = new JTextField();
		textFieldNacimiento.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo");
		
		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblEmpleado)
							.addGap(126))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblContrasea)
								.addComponent(lblNacimiento)
								.addComponent(lblCargo)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblDireccion)
									.addComponent(lblApellidos))
								.addComponent(lblCp)
								.addComponent(lblNewLabel)
								.addComponent(lblNombre)
								.addComponent(lblDni))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldDNI, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(textFieldDireccion, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(textFieldApellidos, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(textFieldCP, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(textFieldEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(textFieldCargo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(textFieldContraseña, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(textFieldNacimiento, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEmpleado)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDni))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCp)
						.addComponent(textFieldCP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNacimiento)
						.addComponent(textFieldNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCargo)
						.addComponent(textFieldCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(textFieldContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
