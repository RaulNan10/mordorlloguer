package com.mordor.mordorlloguer.vistas;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mordor.mordorLloguer.model.MyBusTableModel;
import com.mordor.mordorLloguer.model.MyCarTableModel;
import com.mordor.mordorLloguer.model.MyTruckTableModel;
import com.mordor.mordorLloguer.model.MyVanTableModel;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JPVehicle extends JPanel {

	private JTextField textFieldRegistration;
	private JTextField textFieldModel;
	private JTable table;
	private MyCarTableModel carModel;
	private MyVanTableModel vanModel;
	private MyTruckTableModel truckModel;
	private MyBusTableModel busModel;
	private DefaultComboBoxModel<String> dcmEngine;
	private DefaultComboBoxModel<String> dcmLicense;
	private JComboBox comboBoxEngine;
	private JComboBox comboBoxLicense;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public JPVehicle() throws ParseException {
		setBounds(100, 100, 845, 519);
		JLabel lblRegistration = new JLabel("Registration:");

		dcmEngine = new DefaultComboBoxModel<String>();
		dcmLicense = new DefaultComboBoxModel<String>();

		textFieldRegistration = new JTextField();
		textFieldRegistration.setColumns(10);

		JLabel lblModel = new JLabel("Model:");

		textFieldModel = new JTextField();
		textFieldModel.setColumns(10);

		JLabel lblEngine = new JLabel("Engine");

		comboBoxEngine = new JComboBox();

		JLabel lblLicense = new JLabel("License");

		comboBoxLicense = new JComboBox();

		JScrollPane scrollPane = new JScrollPane();

		btnAdd = new JButton("Add");

		btnDelete = new JButton("Delete");

		btnEdit = new JButton("Edit");

		btnCancel = new JButton("Cancel");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING, false).addComponent(scrollPane, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(lblRegistration)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldRegistration, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblModel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldModel, GroupLayout.PREFERRED_SIZE, 217,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblEngine)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBoxEngine, GroupLayout.PREFERRED_SIZE, 104,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblLicense)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(comboBoxLicense,
										GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(529, Short.MAX_VALUE)
						.addComponent(btnAdd).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnDelete)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEdit)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCancel).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(
						31)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblRegistration)
						.addComponent(textFieldRegistration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModel)
						.addComponent(textFieldModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEngine)
						.addComponent(comboBoxEngine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLicense).addComponent(comboBoxLicense, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnAdd)
						.addComponent(btnDelete).addComponent(btnEdit).addComponent(btnCancel))
				.addContainerGap(20, Short.MAX_VALUE)));

		table = new JTable();
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

		dcmEngine = new DefaultComboBoxModel();
		dcmLicense = new DefaultComboBoxModel();
		dcmEngine.addElement("All");
		dcmEngine.addElement("hibrido enchufable");
		dcmEngine.addElement("electrico");
		dcmEngine.addElement("gasolina");
		dcmEngine.addElement("diesel");
		dcmLicense.addElement("All");
		dcmLicense.addElement("B");
		dcmLicense.addElement("C");
		dcmLicense.addElement("D");
		dcmLicense.addElement("E");
		comboBoxEngine.setModel(dcmEngine);
		comboBoxLicense.setModel(dcmLicense);

	}

	public JTextField getTextFieldRegistration() {
		return textFieldRegistration;
	}

	public void setTextFieldRegistration(JTextField textFieldRegistration) {
		this.textFieldRegistration = textFieldRegistration;
	}

	public JTextField getTextFieldModel() {
		return textFieldModel;
	}

	public void setTextFieldModel(JTextField textFieldModel) {
		this.textFieldModel = textFieldModel;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public MyCarTableModel getCarModel() {
		return carModel;
	}

	public void setCarModel(MyCarTableModel carModel) {
		this.carModel = carModel;
	}

	public MyVanTableModel getVanModel() {
		return vanModel;
	}

	public void setVanModel(MyVanTableModel vanModel) {
		this.vanModel = vanModel;
	}

	public MyTruckTableModel getTruckModel() {
		return truckModel;
	}

	public void setTruckModel(MyTruckTableModel truckModel) {
		this.truckModel = truckModel;
	}

	public MyBusTableModel getBusModel() {
		return busModel;
	}

	public void setBusModel(MyBusTableModel busModel) {
		this.busModel = busModel;
	}

	public JComboBox getComboBoxEngine() {
		return comboBoxEngine;
	}

	public void setComboBoxEngine(JComboBox comboBoxEngine) {
		this.comboBoxEngine = comboBoxEngine;
	}

	public JComboBox getComboBoxLicense() {
		return comboBoxLicense;
	}

	public void setComboBoxLicense(JComboBox comboBoxLicense) {
		this.comboBoxLicense = comboBoxLicense;
	}

	public DefaultComboBoxModel<String> getDcmEngine() {
		return dcmEngine;
	}

	public void setDcmEngine(DefaultComboBoxModel<String> dcmEngine) {
		this.dcmEngine = dcmEngine;
	}

	public DefaultComboBoxModel<String> getDcmLicense() {
		return dcmLicense;
	}

	public void setDcmLicense(DefaultComboBoxModel<String> dcmLicense) {
		this.dcmLicense = dcmLicense;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

}