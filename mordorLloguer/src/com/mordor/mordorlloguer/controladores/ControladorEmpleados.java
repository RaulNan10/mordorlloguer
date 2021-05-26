package com.mordor.mordorlloguer.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import com.alee.laf.table.WebTable;
import com.mordor.mordorLloguer.model.AlmacenDatosDB;
import com.mordor.mordorLloguer.model.ComparatorEmpleadoCP;
import com.mordor.mordorLloguer.model.ComparatorEmpleadoDomicilio;
import com.mordor.mordorLloguer.model.Empleado;
import com.mordor.mordorLloguer.model.MyOracleDataBase;
import com.mordor.mordorlloguer.vistas.FrameEmpleados;
import com.mordor.mordorlloguer.vistas.FrameEmpleados.MyEmployeeTableModel;
import com.mordor.mordorlloguer.vistas.VistaAnyadirEmpleado;

public class ControladorEmpleados implements ActionListener {

	private FrameEmpleados vista;

	private VistaAnyadirEmpleado vistaAnyade;

	public ControladorEmpleados(FrameEmpleados vista) {
		super();

		this.vista = vista;

		vistaAnyade = new VistaAnyadirEmpleado();

		inicializar();
	}

	private void inicializar() {

		vista.getBtnOrdena().addActionListener(this);
		vista.getBtnAdd().addActionListener(this);
		vista.getBtnDelete().addActionListener(this);
		vista.getMntmAddRow_1().addActionListener(this);
		vista.getMntmDeleteRow_1().addActionListener(this);
		vista.getBtnClose().addActionListener(this);
		vistaAnyade.getBtnAdd().addActionListener(this);

		vista.getBtnOrdena().setActionCommand("Ordenar");
		vista.getBtnAdd().setActionCommand("Add");
		vista.getBtnDelete().setActionCommand("Delete");
		vista.getMntmAddRow_1().setActionCommand("Add");
		vista.getMntmDeleteRow_1().setActionCommand("Delete");
		vista.getBtnClose().setActionCommand("Close");
		vistaAnyade.getBtnAdd().setActionCommand("añadirEmpleado");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String comando = arg0.getActionCommand();

		if (comando.equals("Ordenar")) {

			ordenar(vista.getComboBoxCampo().getSelectedIndex(), vista.getComboBoxOrden().getSelectedIndex());

		} else if (comando.equals("Add")) {

			add();

		} else if (comando.equals("Edit")) {

			if (vista.getTable().getSelectedRowCount() == 1) {

				edit(vista.getTable().getSelectedRow());

			} else

				JOptionPane.showMessageDialog(vista, "Selecciona un solo empleado", "Error", JOptionPane.ERROR_MESSAGE);

		} else if (comando.equals("Delete")) {
				
			delete(vista.getTable().getSelectedRows());

		} else if (comando.equals("Close")) {

			close();

		} else if (comando.equals("añadirEmpleado")) {
			añadirEmpleado();
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

			Boolean eliminado = false;

			int contador = 0;

			@Override
			protected Boolean doInBackground() throws Exception {

				for (int i : rows) {

					dni = (String.valueOf(tabla.getValueAt(i - contador, 0)));

					eliminado = modelo.deleteEmpleado(dni);

					MyEmployeeTableModel mtm = (MyEmployeeTableModel) vista.getTable().getModel();

					if (eliminado == true) {

						mtm.remove(dni);

						contador++;

					}

				}

				return eliminado;
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

					e.printStackTrace();

				} catch (ExecutionException e) {

					e.printStackTrace();

				}
			}

		};
		task.execute();

	}

	private void edit(int row) {

		AlmacenDatosDB modelo = new MyOracleDataBase();

		SwingWorker<Boolean, Void> task = new SwingWorker<Boolean, Void>() {

			@Override
			protected Boolean doInBackground() throws Exception {

				Boolean b = false;

				MyEmployeeTableModel mtm = (MyEmployeeTableModel) vista.getTable().getModel();

				b = modelo.updateEmpleado(mtm.get(row));

				if (b) {

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

					e.printStackTrace();

				} catch (ExecutionException e) {

					e.printStackTrace();

				}
			}

		};

	}

	private void add() {

		ControladorPrincipal.addJInternalFrame(vistaAnyade);

	}

	private void añadirEmpleado() {
		AlmacenDatosDB modelo = new MyOracleDataBase();

		String dNI = vistaAnyade.getTextFieldDNI().getText();
		String nombre = vistaAnyade.getTextFieldNombre().getText();
		String apellidos = vistaAnyade.getTextFieldApellidos().getText();
		String cp = vistaAnyade.getTextFieldCP().getText();
		String email = vistaAnyade.getTextFieldEmail().getText();
		Date fecha = ControladorPrincipal.convert(vistaAnyade.getDatePicker().getDate());
		String cargo = vistaAnyade.getTextFieldCargo().getText();
		String domicilio = vistaAnyade.getTextFieldDireccion().getText();
		String contraseña = "";

		for (char i : vistaAnyade.getPasswordField().getPassword())
			contraseña += i;

		if (dNI == "" || nombre == "" || apellidos == "" || email == "" || fecha == null || cargo == ""
				|| domicilio == "" || contraseña == "")
			JOptionPane.showMessageDialog(vistaAnyade, "Los campos que tienen un asterisco son obligatorios", "Erorr",
					JOptionPane.ERROR_MESSAGE);

		SwingWorker<Boolean, Void> task = new SwingWorker<Boolean, Void>() {

			private Empleado e;

			boolean b;

			@Override
			protected Boolean doInBackground() throws Exception {

				String contra = "";

				for (char i : vistaAnyade.getPasswordField().getPassword())
					contra += i;

				e = new Empleado(dNI, nombre, apellidos, cp, email, fecha, cargo, domicilio, contra);

				boolean b = modelo.insertaEmpleado(e);

				MyEmployeeTableModel tabla = (MyEmployeeTableModel) vista.getTable().getModel();

				tabla.setNewData(modelo.getEmpleados());

				vista.getTable().setModel(tabla);

				return b;
			}

		};

		task.execute();
	}

	private void ordenar(int campo, int asc) {
		if (asc == 0) {

			if (campo == 0) {

				vista.getMtm().setComparator((p1, p2) -> p1.getDNI().compareTo(p2.getDNI()));

			} else if (campo == 1) {

				vista.getMtm().setComparator((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));

			} else if (campo == 2) {

				vista.getMtm().setComparator((p1, p2) -> p1.getApellidos().compareTo(p2.getApellidos()));

			} else if (campo == 3) {

				vista.getMtm().setComparator((p1, p2) -> p1.getEmail().compareTo(p2.getEmail()));

			} else if (campo == 4) {

				vista.getMtm().setComparator(new ComparatorEmpleadoDomicilio());

			} else if (campo == 5) {

				vista.getMtm().setComparator(new ComparatorEmpleadoCP());

			} else if (campo == 6) {

				vista.getMtm().setComparator((p1, p2) -> p1.getFecha().compareTo(p2.getFecha()));

			} else if (campo == 7) {

				vista.getMtm().setComparator((p1, p2) -> p1.getCargo().compareTo(p2.getCargo()));

			}

		} else {

			if (campo == 0) {
				vista.getMtm().setComparator((p2, p1) -> p1.getDNI().compareTo(p2.getDNI()));

			} else if (campo == 1) {

				vista.getMtm().setComparator((p2, p1) -> p1.getNombre().compareTo(p2.getNombre()));

			} else if (campo == 2) {

				vista.getMtm().setComparator((p2, p1) -> p1.getApellidos().compareTo(p2.getApellidos()));

			} else if (campo == 3) {

				vista.getMtm().setComparator((p2, p1) -> p1.getEmail().compareTo(p2.getEmail()));

			} else if (campo == 4) {

				vista.getMtm().setComparator(new ComparatorEmpleadoDomicilio());

			} else if (campo == 5) {

				vista.getMtm().setComparator(new ComparatorEmpleadoCP());

			} else if (campo == 6) {

				vista.getMtm().setComparator((p2, p1) -> p1.getFecha().compareTo(p2.getFecha()));

			} else if (campo == 7) {

				vista.getMtm().setComparator((p2, p1) -> p1.getCargo().compareTo(p2.getCargo()));

			}

		}

	}

}
