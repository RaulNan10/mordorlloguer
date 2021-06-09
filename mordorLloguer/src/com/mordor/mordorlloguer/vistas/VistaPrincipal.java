package com.mordor.mordorlloguer.vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;

public class VistaPrincipal extends JFrame {

	private VistaPrincipal vista;
	private JPanel contentPane;
	private JButton btnLogin;
	private JButton btnLogout;
	private JButton btnEmpleado;
	private JDesktopPane desktopPane;
	private VistaLogin vistaLogin;
	private JMenuItem mntmPreferences;
	private JButton btnClientes;
	private JButton buttonVehicle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 537);
		
		vistaLogin = new VistaLogin();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnEdit.add(mntmAbout);
		
		mntmPreferences = new JMenuItem("Preferences");
		mnEdit.add(mntmPreferences);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		
		desktopPane = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
		);
		
		btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/com/mordor/mordorlloguer/assets/login.png")));
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		toolBar.add(btnLogin);
		
		btnLogout = new JButton("");
		btnLogout.setEnabled(false);
		btnLogout.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/com/mordor/mordorlloguer/assets/logout.png")));
		
		
		
		
		btnLogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		toolBar.add(btnLogout);
		
		//Separador del boton logout y user
		toolBar.addSeparator(new Dimension(10,10));
		
		btnEmpleado = new JButton("");
		btnEmpleado.setEnabled(false);
		btnEmpleado.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/com/mordor/mordorlloguer/assets/user.png")));
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		
		
		toolBar.add(btnEmpleado);
		
		btnClientes = new JButton("");
		btnClientes.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/com/mordor/mordorlloguer/assets/cliente.png")));
		toolBar.add(btnClientes);
		
		buttonVehicle = new JButton("");
		buttonVehicle.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/com/mordor/mordorlloguer/assets/vehicle.png")));
		toolBar.add(buttonVehicle);
		contentPane.setLayout(gl_contentPane);
	}

	public VistaPrincipal getVista() {
		return vista;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnEmpleado() {
		return btnEmpleado;
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public VistaLogin getVistaLogin() {
		return vistaLogin;
	}

	public JMenuItem getMntmPreferences() {
		return mntmPreferences;
	}

	public JButton getBtnClientes() {
		return btnClientes;
	}

	public JButton getButtonVehicle() {
		return buttonVehicle;
	}
	
}
