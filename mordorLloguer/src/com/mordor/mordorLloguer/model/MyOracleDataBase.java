package com.mordor.mordorLloguer.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import com.mordor.mordorlloguer.controladores.ControladorPrincipal;

public class MyOracleDataBase implements AlmacenDatosDB {

	public ArrayList<Empleado> getCustomEmpleados(String where) {

		DataSource ds = MyDataSource.getOracleDataSource();

		String query = "SELECT * FROM EMPLEADO";

		if (where != null) {
			query += " WHERE " + where;
		}

		ArrayList<Empleado> empleados = new ArrayList<Empleado>();

		try (Connection con = ds.getConnection();

				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(query)) {

			Empleado empleado;

			while (rs.next()) {

				empleado = new Empleado(rs.getString("DNI"), rs.getString("NOMBRE"), rs.getString("APELLIDOS"),
						rs.getString("CP"), rs.getString("EMAIL"), rs.getDate("FECHANAC"), rs.getString("CARGO"),
						rs.getString("DOMICILIO"), rs.getString("PASSWORD"));

				empleados.add(empleado);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return empleados;

	}

	@Override
	public ArrayList<Empleado> getEmpleados() {

		return getCustomEmpleados(null);
	}

	@Override
	public ArrayList<Empleado> getEmpleadosPorCP(String cp) {

		return getCustomEmpleados("CP=" + cp);
	}

	@Override
	public ArrayList<Empleado> getEmpleadosPorCargo(String cargo) {

		return getCustomEmpleados("CARGO='" + cargo + "'");
	}

	@Override
	public Empleado getEmpleadoPorDNI(String dni) {

		ArrayList<Empleado> empleados = getCustomEmpleados("DNI='" + dni + "'");

		if (empleados.size() == 0)
			return null;
		else
			return empleados.get(0);
	}

	@Override
	public boolean insertaEmpleado(Empleado empleado) {

		DataSource ds = MyDataSource.getOracleDataSource();

		boolean b = false;

		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {
			String query = "INSERT INTO EMPLEADO(dni,nombre,apellidos"
					+ ((empleado.getDomicilio() != null) ? ",domicilio" : "")
					+ ((empleado.getCp() != null) ? ",cp" : "") + ",email,fechaNac,cargo,password) values('"
					+ empleado.getDNI() + "','" + empleado.getNombre() + "','" + empleado.getApellidos() + "',"
					+ ((empleado.getDomicilio() != null) ? "'" + empleado.getDomicilio() + "'," : "")
					+ ((empleado.getCp() != null) ? "'" + empleado.getCp() + "'," : "") + "'" + empleado.getEmail()
					+ "'," + "TO_DATE('" + empleado.getFecha() + "','yyyy-mm-dd'),'" + empleado.getCargo() + "',"
					+ "ENCRYPT_PASWD.encrypt_val('" + empleado.getPassword() + "'))";
			;
			int i = stmt.executeUpdate(query);
			if (i != 0) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public boolean deleteEmpleado(String dni) {

		boolean b = false;

		DataSource ds = MyDataSource.getOracleDataSource();

		String query = "delete from EMPLEADO where dni= ?";

		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(query);) {

			stmt.setString(1, dni);

			if (stmt.executeUpdate() == 1)
				b = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public boolean authenticate(String dni, String password) {

		DataSource ds = MyDataSource.getOracleDataSource();

		boolean valido = false;
		String query = "SELECT COUNT(*) FROM EMPLEADO " + "WHERE DNI=? AND password=ENCRYPT_PASWD.encrypt_val(?)";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(query);) {

			pstmt.setString(1, dni);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			rs.next();
			if (rs.getInt(1) > 0)
				valido = true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return valido;
	}

	@Override
	public boolean updateEmpleado(Empleado empleado) {

		boolean actualizado = false;

		DataSource ds = MyDataSource.getOracleDataSource();

		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {

			String query = "UPDATE EMPLEADO SET nombre='" + empleado.getNombre() + "', " + "apellidos='"
					+ empleado.getApellidos() + "',"
					+ ((empleado.getDomicilio() != null) ? "domicilio='" + empleado.getDomicilio() + "'," : "")
					+ ((empleado.getCp() != null) ? "CP='" + empleado.getCp() + "'," : "") + "email='"
					+ empleado.getEmail() + "'," + "fechaNac=TO_DATE('" + empleado.getFecha() + "','yyyy-mm-dd')" + ","
					+ "cargo='" + empleado.getCargo() + "' " + "WHERE DNI='" + empleado.getDNI() + "'";

			System.out.println(query);

			if (stmt.executeUpdate(query) == 1)
				actualizado = true;

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return actualizado;
	}

	@Override
	public boolean insertaCliente(Cliente customer) throws SQLException {

		System.out.println(customer);

		boolean added = false;

		DataSource ds = MyDataSource.getOracleDataSource();

		String query = "{ call GESTIONALQUILER.grabarCliente(?,?,?,?,?,?,?,?,?)}";

		try (Connection con = ds.getConnection();

				CallableStatement cstmt = con.prepareCall(query);) {

			int pos = 0;

			cstmt.setString(++pos, customer.getDni());

			cstmt.setString(++pos, customer.getNombre());

			cstmt.setString(++pos, customer.getApellidos());

			cstmt.setString(++pos, customer.getEmail());

			cstmt.setDate(++pos, customer.getFechaNac());

			cstmt.setString(++pos, String.valueOf(customer.getCarnet()));

			cstmt.setString(++pos, customer.getDomicilio());

			cstmt.setString(++pos, customer.getCp());

			cstmt.setBytes(++pos, customer.getFoto());

			added = (cstmt.executeUpdate() == 1) ? true : false;

		}

		return added;

	}
	@Override
	public boolean deleteCliente(String dni) {

		DataSource ds = MyDataSource.getOracleDataSource();

		Boolean borrado = false;

		String query = "{call GESTIONALQUILER.bajaCliente(?)}";

		try (Connection con = ds.getConnection(); CallableStatement cstmt = con.prepareCall(query);) {

			borrado = cstmt.executeUpdate()==1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borrado;

	}

	@Override
	public ArrayList<Cliente> getClientes() {

		DataSource ds = MyDataSource.getOracleDataSource();

		String query = "SELECT * FROM CLIENTE";

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			Cliente cliente;
			while (rs.next()) {
				cliente = new Cliente(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("domicilio"), rs.getString("cp"), rs.getString("email"), rs.getDate("fechanac"),
						rs.getString("carnet"), rs.getBytes("foto"));

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientes;
	}

}
