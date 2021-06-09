package com.mordor.mordorLloguer.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class MyVehicleTableModel<T extends Vehiculo> extends MyTableModel<T> {

	public MyVehicleTableModel(List<String> header, ArrayList<T> data) {
		super(header, data);
		
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 1:
			return data.get(row).getMatricula();
		default:
			return null;
		}
	}
}