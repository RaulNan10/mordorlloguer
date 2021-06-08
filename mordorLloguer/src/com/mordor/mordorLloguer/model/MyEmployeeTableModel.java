package com.mordor.mordorLloguer.model;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class MyEmployeeTableModel extends MyTableModel<Empleado> {

	public MyEmployeeTableModel(String[] header, List<Empleado> data) {
		super(header, data);
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

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		if (columnIndex == 0)

			return false;

		else

			return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		AlmacenDatosDB modelo = new MyOracleDataBase();
		
		switch (columnIndex) {

		case 1:

			data.get(rowIndex).setNombre(aValue.toString());
			modelo.updateEmpleado(data.get(rowIndex));

			break;

		case 2:

			java.util.Date fecha = (java.util.Date) aValue;

			data.get(rowIndex).setFecha(new java.sql.Date(fecha.getTime()));
			modelo.updateEmpleado(data.get(rowIndex));

			break;

		case 3:

			data.get(rowIndex).setCargo(aValue.toString());
			modelo.updateEmpleado(data.get(rowIndex));
		case 4:
			
			data.get(rowIndex).setDomicilio(aValue.toString());
			modelo.updateEmpleado(data.get(rowIndex));
		case 5:
			data.get(rowIndex).setCp(aValue.toString());
		case 6:
			java.util.Date date = (java.util.Date) aValue;
			data.get(rowIndex).setFecha(new java.sql.Date(date.getTime()));
			
		case 7:
			data.get(rowIndex).setCargo(aValue.toString());
			break;
		}
		if(modelo.updateEmpleado(data.get(rowIndex))) {
			JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Error actualizando empleado", "Error", JOptionPane.ERROR_MESSAGE);
		}

		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public Object getValueAt(int row, int col) {

		switch (col) {
		case 0:

			return data.get(row).getDNI();

		case 1:

			return data.get(row).getNombre();

		case 6:

			return data.get(row).getFecha();

		case 2:

			return data.get(row).getApellidos();

		case 3:

			return data.get(row).getEmail();

		case 4:
			return data.get(row).getDomicilio();

		case 5:

			return data.get(row).getCp();

		case 7:

			return data.get(row).getCargo();

		}

		return null;
	}

	public void remove(String dni) {

		boolean encontrado = false;

		Iterator<Empleado> it = data.iterator();

		Empleado e;

		int pos = 0;

		while (!encontrado && it.hasNext()) {

			e = it.next();

			if (e.getDNI().compareTo(dni) == 0) {

				encontrado = true;

				it.remove();

			} else {

				pos++;

			}

		}

		if (encontrado)

			fireTableRowsDeleted(pos, pos);
	}

}
