package com.mordor.mordorlloguer.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.alee.extended.date.WebDateField;

import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class VistaAnyadirEmpleado extends JInternalFrame {
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldDireccion;
	private JTextField textFieldCP;
	private JTextField textFieldEmail;
	private JTextField textFieldCargo;
	private WebDateField datePicker; 
	private JTextField textFieldFecha;
	private JPasswordField passwordField;
	private JButton btnAdd;

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
		setClosable(true);
		setBounds(100, 100, 342, 409);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		
		JLabel lblDni = new JLabel("DNI*");
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre*");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos*");
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		
		JLabel lblCp = new JLabel("CP");
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email*");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		JLabel lblNacimiento = new JLabel("Nacimiento*");
		datePicker = new WebDateField();
		
		JLabel lblCargo = new JLabel("Cargo*");
		
		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña*");
		
		textFieldFecha = new JTextField();
		
		textFieldFecha.setColumns(10);
		getContentPane().setLayout(new MigLayout("", "[83px][207px,grow][]", "[15px][19px][19px][19px][19px][19px][19px][19px][19px][19px][][][]"));
		getContentPane().add(lblEmpleado, "cell 1 0,alignx left,aligny top");
		getContentPane().add(lblContrasea, "cell 0 9,alignx trailing,aligny center");
		getContentPane().add(lblNacimiento, "cell 0 7,alignx left,aligny center");
		getContentPane().add(lblCargo, "cell 0 8,alignx left,aligny center");
		getContentPane().add(lblDireccion, "cell 0 4,alignx left,aligny center");
		getContentPane().add(lblApellidos, "cell 0 3,alignx left,aligny center");
		getContentPane().add(lblCp, "cell 0 5,alignx left,aligny bottom");
		getContentPane().add(lblNewLabel, "cell 0 6,alignx left,aligny center");
		getContentPane().add(lblNombre, "cell 0 2,alignx left,aligny center");
		getContentPane().add(lblDni, "cell 0 1,alignx left,aligny center");
		getContentPane().add(textFieldDNI, "cell 1 1,growx,aligny top");
		getContentPane().add(textFieldNombre, "cell 1 2,growx,aligny top");
		getContentPane().add(textFieldDireccion, "cell 1 4,growx,aligny top");
		getContentPane().add(textFieldApellidos, "cell 1 3,growx,aligny top");
		getContentPane().add(textFieldCP, "cell 1 5,growx,aligny top");
		getContentPane().add(textFieldEmail, "cell 1 6,growx,aligny top");
		getContentPane().add(textFieldCargo, "cell 1 8,growx,aligny top");
		getContentPane().add(datePicker, "cell 1 7,growx,aligny top");
		
		passwordField = new JPasswordField();
		getContentPane().add(passwordField, "cell 1 9,growx");
		
		btnAdd = new JButton("Add");
		getContentPane().add(btnAdd, "cell 2 12");

	}

	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public JTextField getTextFieldApellidos() {
		return textFieldApellidos;
	}

	public JTextField getTextFieldDireccion() {
		return textFieldDireccion;
	}

	public JTextField getTextFieldCP() {
		return textFieldCP;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JTextField getTextFieldCargo() {
		return textFieldCargo;
	}


	public WebDateField getDatePicker() {
		return datePicker;
	}

	public JTextField getTextFieldFecha() {
		return textFieldFecha;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	
	
	


	
}
