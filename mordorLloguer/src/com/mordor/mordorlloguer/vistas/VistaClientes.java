package com.mordor.mordorlloguer.vistas;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.sql.DataSource;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.alee.laf.table.editors.WebDateEditor;
import com.mordor.mordorLloguer.model.AlmacenDatosDB;
import com.mordor.mordorLloguer.model.Cliente;
import com.mordor.mordorLloguer.model.MyCustomerTableModel;
import com.mordor.mordorLloguer.model.MyOracleDataBase;
import com.mordor.mordorLloguer.model.MyTableModel;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VistaClientes extends JInternalFrame implements TableModelListener {
	private JButton btnImpresora;
	private JTextField textFieldDNI;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JComboBox comboBox;
	private JTable table;
	private JButton btnAdd;
	private JButton btnDelete;
	private MyTableModel mtm;
	private AlmacenDatosDB modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaClientes frame = new VistaClientes();
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
	public VistaClientes() {

		setClosable(true);
		setBounds(100, 100, 827, 394);

		JLabel lblCustomers = new JLabel("Customers");

		JLabel lblDni = new JLabel("DNI");

		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);

		JLabel lblName = new JLabel("Name");

		textFieldName = new JTextField();
		textFieldName.setColumns(10);

		JLabel lblSurname = new JLabel("Surname");

		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);

		JLabel lblDrivingLicense = new JLabel("driving license");

		comboBox = new JComboBox();

		btnImpresora = new JButton(".");

		JScrollPane scrollPane = new JScrollPane();

		btnDelete = new JButton("Delete");

		btnAdd = new JButton("Add");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCustomers)
							.addGap(322))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDni)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblName)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblSurname)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblDrivingLicense)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnImpresora)))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete)
							.addGap(166))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCustomers)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(textFieldDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSurname)
						.addComponent(textFieldSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDrivingLicense)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnImpresora))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnAdd))
					.addContainerGap(30, Short.MAX_VALUE))
		);

		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);



	}



	public JButton getBtnImpresora() {
		return btnImpresora;
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

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public JTable getTable() {
		return table;
	}
	

}
