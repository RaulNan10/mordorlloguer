package com.mordor.mordorlloguer.controladores;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutionException;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import com.mordor.mordorLloguer.model.AlmacenDatosDB;
import com.mordor.mordorLloguer.model.MyOracleDataBase;
import com.mordor.mordorlloguer.vistas.FrameEmpleados;
import com.mordor.mordorlloguer.vistas.VistaClientes;
import com.mordor.mordorlloguer.vistas.VistaLogin;
import com.mordor.mordorlloguer.vistas.VistaPreferencias;
import com.mordor.mordorlloguer.vistas.VistaPrincipal;
import com.mordor.mordorlloguer.vistas.VistaVehiculos;

public class ControladorPrincipal implements ActionListener {

	private VistaPrincipal vista;
	private VistaLogin vistaLogin;
	private static JDesktopPane desktopPane;
	private AlmacenDatosDB modelo;
	private VistaPreferencias vistaPreferencias;
	private FrameEmpleados frameEmpleados;
	private ControladorEmpleados cEmpleados;
	private ControladorClientes cClientes;
	private VistaClientes vistaClientes;
	private ControladorVehiculos controladorVehiculos;
	private VistaVehiculos vistaVehiculos;

	public ControladorPrincipal(VistaPrincipal vista, AlmacenDatosDB modelo) {
		super();

		this.vista = vista;

		vistaLogin = new VistaLogin();

		this.modelo = modelo;

		vistaPreferencias = new VistaPreferencias();

		desktopPane = vista.getDesktopPane();

		frameEmpleados = new FrameEmpleados();

		cEmpleados = new ControladorEmpleados(frameEmpleados);

		vistaClientes = new VistaClientes();

		cClientes = new ControladorClientes(vistaClientes, modelo);

		inicializar();

	}

	private void inicializar() {

		vista.getBtnLogin().addActionListener(this);
		vista.getBtnLogout().addActionListener(this);
		vista.getBtnEmpleado().addActionListener(this);
		vistaLogin.getBtnLogin().addActionListener(this);
		vista.getMntmPreferences().addActionListener(this);
		vistaPreferencias.getBtnSave().addActionListener(this);
		vistaPreferencias.getBtnCancel().addActionListener(this);
		vista.getBtnClientes().addActionListener(this);
		vista.getButtonVehicle().addActionListener(this);

		vista.getBtnEmpleado().setActionCommand("empleados");
		vista.getBtnLogin().setActionCommand("login");
		vista.getBtnLogout().setActionCommand("logout");
		vista.getBtnClientes().setActionCommand("clientes");
		vistaLogin.getBtnLogin().setActionCommand("inicioSesion");
		vista.getMntmPreferences().setActionCommand("preferences");
		vistaPreferencias.getBtnSave().setActionCommand("SaveProperties");
		vistaPreferencias.getBtnCancel().setActionCommand("Cancel properties");
		vista.getButtonVehicle().setActionCommand("Abrir vista vehiculos");

	}

	public void go() {
		vista.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String comando = arg0.getActionCommand();

		if (comando.equals("empleados"))

			empleados();

		else if (comando.equals("login")) {

			login();

//		Action action = new Abstraction() {
//			private static final long serialVersionUID = 1L;
//			
//			@Override
//			public void ActionPerformed(Action Event e) {
//				login();
//			}
//		}
		} else if (comando.equals("logout")) {
			logout();
		} else if (comando.equals("inicioSesion")) {
			inicioSesion();
		} else if (comando.equals("preferences")) {
			preferencias();
		} else if (comando.equals("SaveProperties")) {
			saveProperties();
		} else if (comando.equals("Cancel properties")) {
			cancelProperties();
		} else if (comando.equals("clientes")) {
			addJInternalFrame(vistaClientes);
		} else if(comando.equals("Abrir vista vehiculos")) {
			try {
				vistaVehiculos = new VistaVehiculos();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controladorVehiculos = new ControladorVehiculos(vistaVehiculos, modelo);
			addJInternalFrame(vistaVehiculos);

			
		}

	}

	private void cancelProperties() {
		// TODO Auto-generated method stub

	}

	private void saveProperties() {
		// TODO Auto-generated method stub

	}

	private void preferencias() {

		addJInternalFrame(vistaPreferencias);
	}

	private void inicioSesion() {

		SwingWorker<Boolean, Void> task = new SwingWorker<Boolean, Void>() {

			String user = vistaLogin.getTxtFieldUsuario().getText();

			char[] passwordChar = vistaLogin.getPasswordField().getPassword();

			String password = "";

			@Override
			protected Boolean doInBackground() throws Exception {

				for (int i = 0; i < passwordChar.length; i++) {

					password += passwordChar[i];
				}

				Boolean login = modelo.authenticate(user, password);

				vistaLogin.getProgressBar().setVisible(true);

				return login;
			}

			@Override
			protected void done() {

				vistaLogin.getProgressBar().setVisible(false);

				Boolean logueado;

				try {
					logueado = get();

					if (logueado) {

						vistaLogin.dispose();

						vista.getBtnLogout().setEnabled(true);

						vista.getBtnEmpleado().setEnabled(true);

						vista.getBtnLogin().setEnabled(false);

						JOptionPane.showMessageDialog(vista, "Sesion iniciada correctamente", "Tu cuenta",
								JOptionPane.INFORMATION_MESSAGE);
					} else {

						JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos",
								"Error al iniciar sesion", JOptionPane.ERROR_MESSAGE);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}

			}

		};
		task.execute();

	}

	private void logout() {

		vista.getBtnLogout().setEnabled(false);

		vista.getBtnLogin().setEnabled(true);

		vista.getBtnEmpleado().setEnabled(false);

		JOptionPane.showMessageDialog(vista, "Sesion cerrada", "", JOptionPane.INFORMATION_MESSAGE);

	}

	private void login() {

		vista.getDesktopPane().add(vistaLogin);

		vistaLogin.setVisible(true);
	}

	private void empleados() {

		vista.getDesktopPane().add(frameEmpleados);

		frameEmpleados.setVisible(true);

	}

	static void addJInternalFrame(JInternalFrame jif) {

		desktopPane.add(jif);

		centrar(jif);

		jif.setVisible(true);

		try {
			jif.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}

	static boolean isOpen(JInternalFrame jif) {

		boolean existe = false;

		JInternalFrame[] frames = desktopPane.getAllFrames();

		for (JInternalFrame frame : frames)

			if (frame == jif)

				existe = true;

		return existe;

	}

	public static java.sql.Date convert(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}

	static void centrar(JInternalFrame jif) {

		Dimension deskSize = desktopPane.getSize();

		Dimension ifSize = jif.getSize();

		jif.setLocation((deskSize.width - ifSize.width) / 2, (deskSize.height - ifSize.height) / 2);
	}
}
