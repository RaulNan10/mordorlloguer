package com.mordor.mordorLloguer.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class MyTableModel<T> extends AbstractTableModel {

	private String[] HEADER;

	protected List<T> data;

	public MyTableModel(String[] HEADER, List<T> data) {

		this.HEADER = HEADER;

		this.data = data;
	}

	@Override
	public int getColumnCount() {
		return HEADER.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public String getColumnName(int column) {
		return HEADER[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0)
			return false;
		else
			return true;

	}

	public void add(T empleado) {

		data.add(empleado);

		fireTableRowsInserted(data.size() - 1, data.size() - 1);

	}

	public ArrayList<T> get(int[] rows) {
		ArrayList<T> empleados = new ArrayList<T>();

		for (int row : rows)
			empleados.add(get(row));

		return empleados;
	}

	public T get(int row) {
		if (row < 0 || row >= data.size())
			return null;
		else
			return data.get(row);
	}

	public void remove(T employee) {
		int pos = data.indexOf(employee);
		data.remove(employee);
		fireTableRowsDeleted(pos, pos);
	}

	public void setComparator(Comparator<T> comparator) {
		Collections.sort(data, comparator);
		this.fireTableDataChanged();
	}

	public void setNewData(List<T> data) {
		this.data = data;

		this.fireTableDataChanged();
	}

}
