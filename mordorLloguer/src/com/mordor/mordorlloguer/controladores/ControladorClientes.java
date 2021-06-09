package com.mordor.mordorlloguer.controladores;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.alee.laf.table.WebTable;
import com.alee.laf.table.editors.WebDateEditor;
import com.mordor.mordorLloguer.model.AlmacenDatosDB;
import com.mordor.mordorLloguer.model.Cliente;
import com.mordor.mordorLloguer.model.MyCustomerTableModel;
import com.mordor.mordorLloguer.model.MyEmployeeTableModel;
import com.mordor.mordorLloguer.model.MyOracleDataBase;
import com.mordor.mordorlloguer.vistas.VistaAnyadirCliente;
import com.mordor.mordorlloguer.vistas.VistaClientes;

public class ControladorClientes implements ActionListener, TableModelListener, DocumentListener {

	private VistaClientes vista;

	private VistaAnyadirCliente vistaAnyade;

	private File filePhoto;

	private AlmacenDatosDB modelo;

	public ControladorClientes(VistaClientes vista, AlmacenDatosDB modelo) {

		this.vista = vista;
		this.modelo = modelo;

		vista = new VistaClientes();

		vistaAnyade = new VistaAnyadirCliente();

		inicializar();
	}

	private void inicializar() {

		vista.getBtnAdd().addActionListener(this);
		vista.getBtnDelete().addActionListener(this);
		vista.getBtnImpresora().addActionListener(this);
		vista.getTextFieldName().addActionListener(this);
		vista.getTextFieldSurname().addActionListener(this);
		vista.getComboBox().addActionListener(this);
		vistaAnyade.getBtnAdd().addActionListener(this);
		vistaAnyade.getBtnFoto().addActionListener(this);
		vista.getComboBox().addActionListener(this);

		vista.getComboBox().addItem("A");
		vista.getComboBox().addItem("B");
		vista.getComboBox().addItem("C");
		vista.getComboBox().addItem("D");
		vista.getComboBox().addItem("E");
		vista.getComboBox().addItem("All");
		vista.getComboBox().setSelectedItem("All");

		vista.getTextFieldDNI().getDocument().addDocumentListener(this);
		vista.getTextFieldName().getDocument().addDocumentListener(this);
		vista.getTextFieldSurname().getDocument().addDocumentListener(this);

		vista.getBtnAdd().setActionCommand("Añadir Cliente");
		vista.getBtnDelete().setActionCommand("Delete");
		vista.getBtnImpresora().setActionCommand("Impresora");
		vistaAnyade.getBtnAdd().setActionCommand("Add");
		vistaAnyade.getBtnFoto().setActionCommand("Foto");
		vista.getComboBox().setActionCommand("COMBO");

		ArrayList<Cliente> clientes = modelo.getClientes();
		
		List<String> header = new ArrayList<String>();
		header.add("DNI");
		header.add("Nombre");
		header.add("Apellidos");
		header.add("Domicilio");
		header.add("CP");
		header.add("email");
		header.add("fechaNac");
		header.add("Carnet");
		MyCustomerTableModel mtm = new MyCustomerTableModel(header,clientes);

		mtm.addTableModelListener(this);

		SwingWorker<Boolean, Void> task = new SwingWorker<Boolean, Void>() {

			@Override
			protected Boolean doInBackground() throws Exception {

				vista.getTable().setModel(mtm);

				vista.getTable().setDefaultEditor(Date.class, new WebDateEditor());

				for (Cliente c : clientes) {
					mtm.add(c);
				}

				return null;
			}

		};

		task.execute();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JTable tabla = vista.getTable();

		String comando = arg0.getActionCommand();

		if (comando.equals("Añadir Cliente")) {

			abrirVistaAnyadir();

		} else if (comando.equals("Cancelar")) {

			cancel();

		} else if (comando.equals("Delete")) {

			delete(tabla.getSelectedRows());

		} else if (comando.equals("Edit")) {

			edit();

		} else if (comando.equals("Impresora")) {

		} else if (comando.equals("Add")) {
			anyadirCliente();
		} else if (comando.equals("Foto")) {
			try {
				addPhoto();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (comando.equals("COMBO")) {
			filtroCBox();
		}

	}

	private void filtroCBox() {

		ArrayList<Cliente> clientes = modelo.getClientes();
		MyCustomerTableModel mtm = (MyCustomerTableModel) vista.getTable().getModel();

		List<Cliente> temp = clientes.stream()
				.filter((a) -> a.getDni().toUpperCase().contains(vista.getTextFieldDNI().getText().toUpperCase()))
				.filter((a) -> a.getApellidos().toUpperCase()
						.contains(vista.getTextFieldSurname().getText().toUpperCase()))
				.filter((a) -> a.getNombre().toUpperCase().contains(vista.getTextFieldName().getText().toUpperCase()))
				.filter((a) -> a.getCarnet().toUpperCase().equals(vista.getComboBox().getSelectedItem())
						|| vista.getComboBox().getSelectedItem().equals("All"))
				.collect(Collectors.toList());
		mtm.setNewData(temp);

	}

	private void anyadirCliente() {

		String dni = vistaAnyade.getTextFieldDNI().getText();
		String nombre = vistaAnyade.getTextFieldName().getText();
		String apellidos = vistaAnyade.getTextFieldSurname().getText();
		String domicilio = vistaAnyade.getTextFieldAddress().getText();
		String cp = vistaAnyade.getTextFieldCP().getText();
		String email = vistaAnyade.getTextFieldEmail().getText();
		byte[] foto = vistaAnyade.getImage();
		String carnet = "";

		if (vistaAnyade.getTextFieldFecha().getDate() == null || dni == "" || nombre == "" || apellidos == ""
				|| email == "") {
			JOptionPane.showMessageDialog(vistaAnyade, "Los campos que tienen un asterisco son obligatorios", "Erorr",
					JOptionPane.ERROR_MESSAGE);
		}

		else {

			Date fecha = new Date(vistaAnyade.getTextFieldFecha().getDate().getTime());

			JComboBox combo = vistaAnyade.getComboBox();

			if (combo.getSelectedIndex() == 0) {
				carnet += "A";
			} else if (combo.getSelectedIndex() == 1) {
				carnet += "B";
			} else if (combo.getSelectedIndex() == 2) {
				carnet += "C";
			} else if (combo.getSelectedIndex() == 3) {
				carnet += "D";
			} else if (combo.getSelectedIndex() == 4) {
				carnet += "E";
			}
			Cliente cliente = new Cliente(dni, nombre, apellidos, domicilio, cp, email, fecha, carnet, foto);

			SwingWorker<Boolean, Void> task = new SwingWorker<Boolean, Void>() {

				boolean insertado = false;

				@Override
				protected Boolean doInBackground() throws Exception {

					insertado = modelo.insertaCliente(cliente);

					MyCustomerTableModel tabla = (MyCustomerTableModel) vista.getTable().getModel();

					tabla.setNewData(modelo.getClientes());

					vista.getTable().setModel(tabla);

					return insertado;
				}

				protected void done() {

					try {
						if (get() == true) {
							JOptionPane.showMessageDialog(vistaAnyade, "Confirmado", "Cliente anyadido correctamente",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(vistaAnyade, "Error", "No se ha podido anyadir el cliente",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
	}

	private void addPhoto() throws IOException {

		JFileChooser c = new JFileChooser();

		int rVal = c.showOpenDialog(vistaAnyade);

		if (rVal == JFileChooser.APPROVE_OPTION
				&& (c.getSelectedFile().getName().endsWith(".png") || c.getSelectedFile().getName().endsWith(".jpg"))) {

			InputStream inte = new FileInputStream(c.getSelectedFile()); // Creación del flujo

			byte[] imgFoto = new byte[(int) c.getSelectedFile().length()]; // Creación del vector

			filePhoto = c.getSelectedFile();

			inte.read(imgFoto);

			vistaAnyade.setImage(imgFoto);
		}
		if (rVal == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(vistaAnyade, "Has apretado cancelar", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void edit() {
		// TODO Auto-generated method stub

	}

	private void delete(int[] rows) {

		JTable tabla = vista.getTable();

		AlmacenDatosDB modelo = new MyOracleDataBase();

		SwingWorker<Boolean, Void> task = new SwingWorker<Boolean, Void>() {

			String dni;

			Boolean eliminado = false;

			int contador = 0;

			@Override
			protected Boolean doInBackground() throws Exception {

				for (int i : rows) {

					dni = (String.valueOf(tabla.getValueAt(i - contador, 0)));

					eliminado = modelo.deleteCliente(dni);

					MyCustomerTableModel mtm = (MyCustomerTableModel) vista.getTable().getModel();

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

						JOptionPane.showMessageDialog(vista, "Error eliminando cliente(s)", "Error",
								JOptionPane.ERROR_MESSAGE);

					} else

						JOptionPane.showMessageDialog(vista, "Cliente(s) eliminados correctamente", "Hecho",
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

	private void cancel() {
		// TODO Auto-generated method stub

	}

	private void abrirVistaAnyadir() {

		ControladorPrincipal.addJInternalFrame(vistaAnyade);

	}

	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		ArrayList<Cliente> clientes = modelo.getClientes();
		MyCustomerTableModel mtm = (MyCustomerTableModel) vista.getTable().getModel();

		List<Cliente> temp = clientes.stream()
				.filter((a) -> a.getDni().toUpperCase().contains(vista.getTextFieldDNI().getText().toUpperCase()))
				.filter((a) -> a.getApellidos().toUpperCase()
						.contains(vista.getTextFieldSurname().getText().toUpperCase()))
				.filter((a) -> a.getNombre().toUpperCase().contains(vista.getTextFieldName().getText().toUpperCase()))
				.filter((a) -> a.getCarnet().toUpperCase().equals(vista.getComboBox().getSelectedItem())
						|| vista.getComboBox().getSelectedItem().equals("All"))
				.collect(Collectors.toList());
		mtm.setNewData(temp);

	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		ArrayList<Cliente> clientes = modelo.getClientes();
		MyCustomerTableModel mtm = (MyCustomerTableModel) vista.getTable().getModel();

		List<Cliente> temp = clientes.stream()
				.filter((a) -> a.getDni().toUpperCase().contains(vista.getTextFieldDNI().getText().toUpperCase()))
				.filter((a) -> a.getApellidos().toUpperCase()
						.contains(vista.getTextFieldSurname().getText().toUpperCase()))
				.filter((a) -> a.getNombre().toUpperCase().contains(vista.getTextFieldName().getText().toUpperCase()))
				.filter((a) -> a.getCarnet().toUpperCase().equals(vista.getComboBox().getSelectedItem())
						|| vista.getComboBox().getSelectedItem().equals("All"))
				.collect(Collectors.toList());
		mtm.setNewData(temp);

	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		ArrayList<Cliente> clientes = modelo.getClientes();
		MyCustomerTableModel mtm = (MyCustomerTableModel) vista.getTable().getModel();

		List<Cliente> temp = clientes.stream()
				.filter((a) -> a.getDni().toUpperCase().contains(vista.getTextFieldDNI().getText().toUpperCase()))
				.filter((a) -> a.getApellidos().toUpperCase()
						.contains(vista.getTextFieldSurname().getText().toUpperCase()))
				.filter((a) -> a.getNombre().toUpperCase().contains(vista.getTextFieldName().getText().toUpperCase()))
				.filter((a) -> a.getCarnet().toUpperCase().equals(vista.getComboBox().getSelectedItem())
						|| vista.getComboBox().getSelectedItem().equals("All"))
				.collect(Collectors.toList());
		mtm.setNewData(temp);

	}

}
