package com.mordor.mordorlloguer.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import com.alee.laf.table.WebTable;
import com.mordor.mordorLloguer.model.AlmacenDatosDB;
import com.mordor.mordorLloguer.model.MyOracleDataBase;
import com.mordor.mordorlloguer.vistas.FrameEmpleados;
import com.mordor.mordorlloguer.vistas.FrameEmpleados.MyEmployeeTableModel;

public class ControladorEmpleados implements ActionListener {

	private FrameEmpleados vista;

	public ControladorEmpleados(FrameEmpleados vista) {
		super();
		this.vista = vista;

		inicializar();
	}

	private void inicializar() {

		vista.getBtnOrdena().addActionListener(this);
		vista.getBtnAdd().addActionListener(this);
		vista.getBtnDelete().addActionListener(this);
		vista.getMntmAddRow_1().addActionListener(this);
		vista.getMntmDeleteRow_1().addActionListener(this);
		vista.getBtnClose().addActionListener(this);

		vista.getBtnOrdena().setActionCommand("Ordenar");
		vista.getBtnAdd().setActionCommand("Add");
		vista.getBtnDelete().setActionCommand("Delete");
		vista.getMntmAddRow_1().setActionCommand("Add");
		vista.getMntmDeleteRow_1().setActionCommand("Delete");
		vista.getBtnClose().setActionCommand("Close");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String comando = arg0.getActionCommand();

		if (comando.equals("Ordenar")) {
			ordenar(vista.getComboBoxCampo().getSelectedIndex(), vista.getComboBoxOrden().getSelectedIndex());
		} else if (comando.equals("Add")) {
			add();
		} else if (comando.equals("Edit")) {
			
			if(vista.getTable().getSelectedRowCount()==1){
				edit(vista.getTable().getSelectedRow());
			} else
				JOptionPane.showMessageDialog(vista, "Selecciona un solo empleado", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (comando.equals("Delete")) {
			delete(vista.getTable().getSelectedRows());
		} else if(comando.equals("Close")) {
			close();
		}

	}

	private void close() {
		vista.dispose();
	}

	private void delete(int[] rows) {

		WebTable tabla = vista.getTable();

		AlmacenDatosDB modelo = new MyOracleDataBase();

		SwingWorker<Boolean, Void> task = new SwingWorker<Boolean, Void>() {

			String dni;

			Boolean b = false;
			
			int contador = 0;

			@Override
			protected Boolean doInBackground() throws Exception {

				for (int i : rows) {

					if (b != false || i != 0) {

						dni = (String.valueOf(tabla.getValueAt(i - contador, 0)));

						modelo.deleteEmpleado(dni);

						MyEmployeeTableModel mtm = (MyEmployeeTableModel) vista.getTable().getModel();

						if (b == true) {

							mtm.remove(dni);
							contador++;
						}
					} else {

					}
				}

				return b;
			}

			protected void done() {
				try {
					if (get() == false) {
						JOptionPane.showMessageDialog(vista, "Error eliminando empleados", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						JOptionPane.showMessageDialog(vista, "Empleados eliminados correctamente", "Hecho",
								JOptionPane.INFORMATION_MESSAGE);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};
		task.execute();

	}

	private void edit(int row) {
		
		AlmacenDatosDB modelo = new MyOracleDataBase();
		SwingWorker<Boolean,Void> task = new SwingWorker<Boolean,Void>(){

			@Override
			protected Boolean doInBackground() throws Exception {
				
				Boolean b = false;
				
				MyEmployeeTableModel mtm =  (MyEmployeeTableModel) vista.getTable().getModel();
				
				b = modelo.updateEmpleado(mtm.get(row));
				
				if(b) {
					mtm.fireTableDataChanged();
				}
				
				return b;
			}
			
			protected void done() {
				try {
					if (get() == false) {
						JOptionPane.showMessageDialog(vista, "Error actualizando empleado", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						JOptionPane.showMessageDialog(vista, "Empleados actualizado correctamente", "Hecho",
								JOptionPane.INFORMATION_MESSAGE);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};

	}

	private void add() {
		// TODO Auto-generated method stub

	}

	private void ordenar(int campo, int asc) {
		if (asc == 0) {

			if (campo == 0) {
				vista.getMtm().setComparator((p1, p2) -> p1.getDNI().compareTo(p2.getDNI()));
				vista.getTable().setModel(vista.getMtm());
			} else if (campo == 1) {
				vista.getMtm().setComparator((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
				vista.getTable().setModel(vista.getMtm());
			} else if (campo == 2) {
				vista.getMtm().setComparator((p1, p2) -> p1.getApellidos().compareTo(p2.getApellidos()));
			} else if (campo == 3) {
				vista.getMtm().setComparator((p1, p2) -> p1.getEmail().compareTo(p2.getEmail()));
			} else if (campo == 4) {
				vista.getMtm().setComparator((p1, p2) -> p1.getDomicilio().compareTo(p2.getDomicilio()));
			} else if (campo == 5) {
				vista.getMtm().setComparator((p1, p2) -> p1.getCp().compareTo(p2.getCp()));
			} else if (campo == 6) {
				vista.getMtm().setComparator((p1, p2) -> p1.getFecha().compareTo(p2.getFecha()));
			} else if (campo == 7) {
				vista.getMtm().setComparator((p1, p2) -> p1.getCargo().compareTo(p2.getCargo()));
			}
		} else {
			if (campo == 0) {
				vista.getMtm().setComparator((p2, p1) -> p1.getDNI().compareTo(p2.getDNI()));
				vista.getTable().setModel(vista.getMtm());
			} else if (campo == 1) {
				vista.getMtm().setComparator((p2, p1) -> p1.getNombre().compareTo(p2.getNombre()));
				vista.getTable().setModel(vista.getMtm());
			} else if (campo == 2) {
				vista.getMtm().setComparator((p2, p1) -> p1.getApellidos().compareTo(p2.getApellidos()));
			} else if (campo == 3) {
				vista.getMtm().setComparator((p2, p1) -> p1.getEmail().compareTo(p2.getEmail()));
			} else if (campo == 4) {
				vista.getMtm().setComparator((p2, p1) -> p1.getDomicilio().compareTo(p2.getDomicilio()));
			} else if (campo == 5) {
				vista.getMtm().setComparator((p2, p1) -> p1.getCp().compareTo(p2.getCp()));
			} else if (campo == 6) {
				vista.getMtm().setComparator((p2, p1) -> p1.getFecha().compareTo(p2.getFecha()));
			} else if (campo == 7) {
				vista.getMtm().setComparator((p2, p1) -> p1.getCargo().compareTo(p2.getCargo()));
			}

		}

	}

}
