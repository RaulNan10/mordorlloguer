package com.mordor.mordorlloguer.vistas;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JInternalFrame;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.alee.extended.date.WebDateField;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class VistaAnyadirCliente extends JInternalFrame {
	private JTextField textFieldDNI;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JLabel lblAddress;
	private JTextField textFieldAddress;
	private JLabel lblNewLabel;
	private JTextField textFieldEmail;
	private JLabel lblBirthday;
	private JLabel lblDrivingLicense;
	private JTextField textFieldCP;
	private JButton btnFoto;
	private WebDateField datePicker;
	private WebDateField textFieldFecha;
	private JComboBox<String> comboBox;
	private JButton btnAdd;
	private JButton btnCancel;
	private byte[] image = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAnyadirCliente frame = new VistaAnyadirCliente();
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
	public VistaAnyadirCliente() {
		setClosable(true);
		setBounds(100, 100, 530, 409);

		JLabel lblDni = new JLabel("DNI");

		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);

		JLabel lblName = new JLabel("Name");

		textFieldName = new JTextField();
		textFieldName.setColumns(10);

		JLabel lblSurname = new JLabel("Surname");

		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);

		lblAddress = new JLabel("Address");

		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);

		lblNewLabel = new JLabel("email");

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);

		lblBirthday = new JLabel("Birthday");
		datePicker = new WebDateField();

		lblDrivingLicense = new JLabel("Driving license");

		comboBox = new JComboBox<String>();
		comboBox.addItem("A");
		comboBox.addItem("B");
		comboBox.addItem("C");
		comboBox.addItem("D");
		comboBox.addItem("E");

		JLabel lblCp = new JLabel("CP");

		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);

		btnAdd = new JButton("Add");

		btnCancel = new JButton("Cancel");

		btnFoto = new JButton("New button");

		textFieldFecha = new WebDateField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(64, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
								.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblDni)
										.addComponent(lblSurname).addComponent(lblName).addComponent(lblAddress))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldSurname, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblBirthday).addComponent(lblNewLabel))
												.addGap(63)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblDrivingLicense).addComponent(lblCp))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textFieldCP, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)))))
								.addGroup(groupLayout.createSequentialGroup().addComponent(btnAdd).addGap(18)
										.addComponent(btnCancel)))
						.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnFoto, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
								.addGap(113)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(43)
						.addComponent(btnFoto, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addGap(65)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel).addComponent(lblDni))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBirthday).addComponent(lblName)
								.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE).addComponent(lblSurname)
								.addComponent(textFieldSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDrivingLicense).addComponent(
										comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup().addGap(6)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(2)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblCp)))
										.addComponent(textFieldCP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnAdd)
										.addComponent(btnCancel)))
								.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblAddress)))
						.addContainerGap()));
		getContentPane().setLayout(groupLayout);

	}

	public void setImage(byte[] image) {

		this.image = image;

		if (image != null) {

			try {

				BufferedImage ima = null;

				InputStream in = new ByteArrayInputStream(image);

				ima = ImageIO.read(in);

				ImageIcon icono = new ImageIcon(ima);

				Image imageToResize = icono.getImage();

				Image nuevaResized = imageToResize.getScaledInstance(410, 150, java.awt.Image.SCALE_SMOOTH);

				btnFoto.setIcon(new ImageIcon(nuevaResized));

			} catch (IOException e) {

				e.printStackTrace();

			}

		} else {

			btnFoto.setIcon(new ImageIcon(
					VistaAnyadirCliente.class.getResource("/com/mordor/mordorlloguer/recursos/no-foto.png")));

		}

	}

	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public JTextField getTextFieldSurname() {
		return textFieldSurname;
	}

	public JTextField getTextFieldAddress() {
		return textFieldAddress;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JTextField getTextFieldCP() {
		return textFieldCP;
	}

	public WebDateField getDatePicker() {
		return datePicker;
	}

	public WebDateField getTextFieldFecha() {
		return textFieldFecha;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnFoto() {
		return btnFoto;
	}

	public byte[] getImage() {
		return image;
	}
	
	
	
	

}
