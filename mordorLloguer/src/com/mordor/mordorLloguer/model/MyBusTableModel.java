package com.mordor.mordorLloguer.model;

import java.util.ArrayList;
import java.util.List;

public class MyBusTableModel extends MyVehicleTableModel<Minibus> {

	public MyBusTableModel(List<String>header,ArrayList<Minibus> data) {
		super(header,data);

	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 7:
			return data.get(row).getNumplazas();
		case 8:
			return data.get(row).getMedida();
		default:
			return super.getValueAt(row, col);

		}

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

}