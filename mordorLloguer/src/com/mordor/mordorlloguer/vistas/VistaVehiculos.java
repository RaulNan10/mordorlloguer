package com.mordor.mordorlloguer.vistas;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;

public class VistaVehiculos extends JInternalFrame {

	private JPVehicle carPane;
	private JPVehicle busPane;
	private JPVehicle vanPane;
	private JPVehicle truckPane;
	private JTabbedPane tabbedPane;

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public VistaVehiculos() throws ParseException {
		setClosable(true);
		setBounds(100, 100, 857, 601);
		try {
			setClosed(true);
		} catch (PropertyVetoException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carPane = new JPVehicle();
		vanPane = new JPVehicle();
		truckPane = new JPVehicle();
		busPane = new JPVehicle();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Car", carPane);
		tabbedPane.addTab("Van", vanPane);
		tabbedPane.addTab("Truck", truckPane);
		tabbedPane.addTab("Bus", busPane);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE).addContainerGap()));
		getContentPane().setLayout(groupLayout);

	}

	public JPVehicle getCarPane() {
		return carPane;
	}

	public void setCarPane(JPVehicle carPane) {
		this.carPane = carPane;
	}

	public JPVehicle getBusPane() {
		return busPane;
	}

	public void setBusPane(JPVehicle busPane) {
		this.busPane = busPane;
	}

	public JPVehicle getVanPane() {
		return vanPane;
	}

	public void setVanPane(JPVehicle vanPane) {
		this.vanPane = vanPane;
	}

	public JPVehicle getTruckPane() {
		return truckPane;
	}

	public void setTruckPane(JPVehicle truckPane) {
		this.truckPane = truckPane;
	}

}