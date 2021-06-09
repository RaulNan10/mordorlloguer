package com.mordor.mordorLloguer.model;

import java.util.ArrayList;
import java.util.List;

public class MyVanTableModel extends MyVehicleTableModel<Furgoneta> {

	public MyVanTableModel(List<String>header,ArrayList<Furgoneta> data) {
		super(header,data);

	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 7:
			return data.get(row).getMma();
	
		default:
			return super.getValueAt(row, col);

		}

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

}