package com.mordor.mordorlloguer.vistas;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.table.WebTable;
import com.alee.laf.table.editors.WebDateEditor;

import com.mordor.mordorLloguer.model.AlmacenDatosDB;
import com.mordor.mordorLloguer.model.Empleado;
import com.mordor.mordorLloguer.model.MyOracleDataBase;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class FrameEmpleados extends JInternalFrame implements TableModelListener {

	private JPanel contentPane;

	private WebTable table;

	static FrameEmpleados frame;

	private JPopupMenu popupMenu;

	private JMenuItem mntmAddRow;

	private JMenuItem mntmDeleteRow;

	private JComboBox comboBoxCampo;

	private JComboBox comboBoxOrden;
	
	private MyTableModel<Empleado> mtm; 

	private JLabel lblOrden;
	private JButton btnOrdena;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					WebLookAndFeel.install();
					frame = new FrameEmpleados();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameEmpleados() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 633, 431);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		comboBoxCampo = new JComboBox();
		DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<String>();
		dcm.addElement("DNI");
		dcm.addElement("Nombre");
		dcm.addElement("Apellidos");
		dcm.addElement("Email");
		dcm.addElement("Direccion");
		dcm.addElement("CP");
		dcm.addElement("Fecha nacimiento");
		dcm.addElement("Cargo");
		comboBoxCampo.setModel(dcm);

		comboBoxOrden = new JComboBox();

		JLabel lblOrdenarPor = new JLabel("Ordenar por");

		DefaultComboBoxModel<String> dcmOrden = new DefaultComboBoxModel<String>();
		dcmOrden.addElement("Ascendente");
		dcmOrden.addElement("Descendente");
		comboBoxOrden.setModel(dcmOrden);

		lblOrden = new JLabel("Orden");
		
		btnOrdena = new JButton("Ordena");
		
		btnAdd = new JButton("Add");
		
		btnDelete = new JButton("Delete");
		
		btnClose = new JButton("Close");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblOrdenarPor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxCampo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(82)
							.addComponent(lblOrden)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxOrden, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
							.addComponent(btnOrdena)
							.addGap(52))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDelete)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnClose)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxOrden, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOrdenarPor)
						.addComponent(comboBoxCampo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOrden)
						.addComponent(btnOrdena))
					.addGap(41)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClose)
						.addComponent(btnDelete)
						.addComponent(btnAdd)))
		);

		table = new WebTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setVisibleRowCount(5);
		table.optimizeColumnWidths(true);
		table.setOptimizeRowHeight(true);
		table.setEditable(true);
		scrollPane.setViewportView(table);

		popupMenu = new JPopupMenu();

		mntmAddRow = new JMenuItem("Add row");
		popupMenu.add(mntmAddRow);

		mntmDeleteRow = new JMenuItem("Delete row");
		popupMenu.add(mntmDeleteRow);

		contentPane.setLayout(gl_contentPane);

		inicializar();
	}

	public void inicializar() {

		AlmacenDatosDB modelo = new MyOracleDataBase();

		ArrayList<Empleado> empleados = modelo.getEmpleados();

		mtm = new MyEmployeeTableModel(
				new String[] { "DNI", "Nombre", "Apellidos", "Email", "Direccion", "CP", "Nacimiento", "Cargo" },
				empleados);

		table.setModel(mtm);

		table.setDefaultEditor(Date.class, new WebDateEditor());

		// Adding comboBox just to edit the company position in the WebTable

		JComboBox<String> comboBox = new JComboBox<String>();

		comboBox.addItem("mecanico");

		comboBox.addItem("administrativo");

		comboBox.addItem("comercial");

		comboBox.addItem("gerente");

		TableColumn column = table.getColumn("Cargo");

		column.setCellEditor(new DefaultCellEditor(comboBox));

		mtm.addTableModelListener(this);

		mtm.add(empleados.get(empleados.size() - 1));

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON3) {

					int row = table.rowAtPoint(e.getPoint());

					if (row < 0 || row >= table.getRowCount())

						table.clearSelection();

					else if (table.getSelectedRowCount() <= 1) {

						table.setSelectedRow(row);

						popupMenu.show(table, e.getX(), e.getY());

					} else if (table.getSelectedRowCount() > 1) {

						popupMenu.show(table, e.getX(), e.getY());
					}

				}
			}
		});

	}

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
		
		public void setComparator(Comparator <T> comparator) {
			Collections.sort(data, comparator);
			this.fireTableDataChanged();
		}

	}
	
//	public void ordenar

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

	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub

	}

	public JComboBox getComboBoxCampo() {

		return comboBoxCampo;
	}

	public JComboBox getComboBoxOrden() {

		return comboBoxOrden;
	}

	public JButton getBtnOrdena() {
		return btnOrdena;
	}

	public MyTableModel<Empleado> getMtm() {
		return mtm;
	}

	public WebTable getTable() {
		return table;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}


	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JMenuItem getMntmAddRow_1() {
		return mntmAddRow;
	}

	public JMenuItem getMntmDeleteRow_1() {
		return mntmDeleteRow;
	}

	public JButton getBtnClose() {
		return btnClose;
	}
	
	
	
	
	
}
