package com.mordor.mordorlloguer.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class VistaPreferencias extends JInternalFrame {
	private JTextField textFieldDriverClass;
	private JTextField textFieldURL;
	private JTextField textFieldUser;
	private JTextField textFieldPassword;
	private JButton btnCancel;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPreferencias frame = new VistaPreferencias();
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
	public VistaPreferencias() {
		setBounds(100, 100, 450, 300);
		
		JLabel lblDriverClass = new JLabel("Driver Class");
		
		textFieldDriverClass = new JTextField();
		textFieldDriverClass.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		
		textFieldURL = new JTextField();
		textFieldURL.setColumns(10);
		
		JLabel lblUser = new JLabel("User");
		
		textFieldUser = new JTextField();
		textFieldUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		
		btnSave = new JButton("Save");
		
		btnCancel = new JButton("Cancel");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDriverClass)
								.addComponent(lblUrl)
								.addComponent(lblUser)
								.addComponent(lblPassword))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldURL, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
								.addComponent(textFieldDriverClass, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
								.addComponent(textFieldUser, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
								.addComponent(textFieldPassword, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnCancel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSave)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDriverClass)
						.addComponent(textFieldDriverClass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUrl)
						.addComponent(textFieldURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUser)
						.addComponent(textFieldUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnCancel))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}

	public JTextField getTextFieldDriverClass() {
		return textFieldDriverClass;
	}

	public void setTextFieldDriverClass(JTextField textFieldDriverClass) {
		this.textFieldDriverClass = textFieldDriverClass;
	}

	public JTextField getTextFieldURL() {
		return textFieldURL;
	}

	public void setTextFieldURL(JTextField textFieldURL) {
		this.textFieldURL = textFieldURL;
	}

	public JTextField getTextFieldUser() {
		return textFieldUser;
	}

	public void setTextFieldUser(JTextField textFieldUser) {
		this.textFieldUser = textFieldUser;
	}

	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}

	public void setTextFieldPassword(JTextField textFieldPassword) {
		this.textFieldPassword = textFieldPassword;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnSave() {
		return btnSave;
	}
	
	
	
	
}
