package com.mordor.mordorLloguer.model;

import java.util.ArrayList;
import java.util.List;

public class MyCarTableModel extends MyVehicleTableModel<Car> {

	
	
	public MyCarTableModel(List<String>header,ArrayList<Car> data) {
		super(header,data);
		// TODO Auto-generated constructor stub
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 7:
			return data.get(row).getPlazas();
		case 8:
			return data.get(row).getPuertas();
		default:
			return super.getValueAt(row, col);
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

}