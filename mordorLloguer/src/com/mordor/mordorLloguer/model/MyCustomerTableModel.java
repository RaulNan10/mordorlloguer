package com.mordor.mordorLloguer.model;

import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class MyCustomerTableModel extends MyTableModel<Cliente> {

	public MyCustomerTableModel(List<String> header,List<Cliente> data) {
		super(header, data);
	}

	@Override
	public Object getValueAt(int row, int col) {

		switch (col) {
		case 0:
			return data.get(row).getDni();

		case 1:
			return data.get(row).getNombre();

		case 2:
			return data.get(row).getApellidos();

		case 3:
			return data.get(row).getDomicilio();

		case 4:
			return data.get(row).getCp();

		case 5:
			return data.get(row).getEmail();

		case 6:
			return data.get(row).getFechaNac();

		case 7:
			return data.get(row).getCarnet();

		default:
			return null;
		}

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		AlmacenDatosDB modelo = new MyOracleDataBase();
		switch (columnIndex) {

		case 1:
			data.get(rowIndex).setNombre(aValue.toString());
			break;
		case 2:
			data.get(rowIndex).setApellidos(aValue.toString());
			break;
		case 3:
			data.get(rowIndex).setDomicilio(aValue.toString());
			break;
		case 4:
			data.get(rowIndex).setCp(aValue.toString());
			break;
		case 5:
			data.get(rowIndex).setEmail(aValue.toString());
			break;
		case 6:
			data.get(rowIndex).setFechaNac(new Date(((java.util.Date) aValue).getTime()));
			break;
		case 7:
			data.get(rowIndex).setCarnet(aValue.toString());
			break;
		}
		try {
			if (modelo.insertaCliente(data.get(rowIndex))) {
				JOptionPane.showMessageDialog(null, "Cliente actualizado");
			} else {
				JOptionPane.showMessageDialog(null, "No se ha podido actualizar el cliente", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (HeadlessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public void remove(String dni) {
		boolean encontrado = false;

		java.util.Iterator<Cliente> it = data.iterator();

		Cliente e;
		int pos = 0;

		while (!encontrado && it.hasNext()) {
			e = it.next();
			if (e.getDni().compareTo(dni) == 0) {
				encontrado = true;
				it.remove();
			} else {
				pos++;
			}

		}
		if (encontrado)
			fireTableRowsDeleted(pos, pos);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 6:
			return Date.class;
		default:
			return String.class;
		}
	}
}