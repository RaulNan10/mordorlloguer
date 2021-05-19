package com.mordor.mordorlloguer.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;

public class VistaLogin extends JInternalFrame {
	private JTextField txtFieldUsuario;
	private JLabel lblUser;
	private JLabel lblContrasea;
	private JButton btnLogin;
	private JPasswordField passwordField;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLogin frame = new VistaLogin();
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
	public VistaLogin() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblMemberLogin = new JLabel("Member Login");
		lblMemberLogin.setFont(new Font("Dialog", Font.BOLD, 17));
		
		txtFieldUsuario = new JTextField();
		txtFieldUsuario.setColumns(10);
		
		lblUser = new JLabel("User");
		
		lblContrasea = new JLabel("Password");
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		progressBar = new JProgressBar();
		progressBar.setVisible(false);
		progressBar.setIndeterminate(true);
		
		passwordField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblMemberLogin)
							.addGap(132))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnLogin)
							.addContainerGap(355, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblUser)
							.addContainerGap(395, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(txtFieldUsuario, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblContrasea)
							.addContainerGap(358, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(14, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblMemberLogin)
					.addGap(24)
					.addComponent(lblUser)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblContrasea)
					.addGap(18)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogin)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	
	

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getTxtFieldUsuario() {
		return txtFieldUsuario;
	}

	

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}
}
