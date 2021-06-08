package com.mordor.mordorLloguer.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

public class MysqlDataBase implements AlmacenDatosDB {

	private ArrayList<Empleado> getCustomEmpleados(String where) {

		ArrayList<Empleado> empleados = new ArrayList<Empleado>();

		DataSource ds = MyDataSource.getMySQLDataSource();

		String query = "SELECT * FROM EMPLEADO ";

		if (where != null) {

			query += " WHERE " + where;
		}

		System.out.println(query);

		try (Connection con = ds.getConnection();

				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(query)) {

			Empleado empleado;

			while (rs.next()) {

				empleado = new Empleado(rs.getString("DNI"), rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("CP"), rs.getString("email"), rs.getDate("fechanac"),
						rs.getString("cargo"), rs.getString("domicilio"), rs.getString("password"));

				empleados.add(empleado);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		ArrayList<Empleado> a = getCustomEmpleados("DNI='" + dni + "'");

		if (a.size() != 0)

			return a.get(0);

		else

			return null;
	}

	@Override
	public boolean deleteEmpleado(String where) {
		DataSource ds = MyDataSource.getMySQLDataSource();

		String query = "DELETE FROM EMPLEADO";

		boolean bool = true;

		if (where != null) {

			query += " WHERE " + where;
		}

		System.out.println(query);

		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {
			int i = stmt.executeUpdate(query);

			Empleado empleado;

			if (i == 0)

				bool = false;

			else
				bool = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean authenticate(String login, String passwd) {
		DataSource ds = MyDataSource.getMySQLDataSource();

		String queryComprobacion = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI=? AND password=?";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(queryComprobacion);) {
			
			//int pos = 0;
			
			pstmt.setString(1, login);
			pstmt.setString(2, passwd);

			ResultSet rs = pstmt.executeQuery(queryComprobacion);
			
			rs.next();
			
			int i = rs.getInt(1);

			if (i >= 1)
			
				return true;
			
			else
			
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	// No UTILIZAR NUNCA
//	@Override
//	public boolean authenticate(String login, String passwd) {
//		
//		DataSource ds = MyDataSource.getMySQLDataSource();				
//		
//		try(Connection con = ds.getConnection();Statement stmt = con.createStatement();){
//			
//			String queryComprobacion = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI='" +login + "'" + " AND password='" + passwd + "'";
//			
//			ResultSet rs = stmt.executeQuery(queryComprobacion);
//			
//			 rs.next();
//			 int i = rs.getInt(1);
//			
//			 if(i>=1) 
//				 return true;
//			 else
//				 return false;
//			 
//			 
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return false;
//	}

	@Override

	public boolean updateEmpleado(Empleado empleado) {

		boolean actualizado = false;

		DataSource ds = MyDataSource.getMySQLDataSource();

		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {

			String query = "UPDATE EMPLEADO SET nombre=\"" + empleado.getNombre() + "\", " + "apellidos=\""
					+ empleado.getApellidos() + "\","
					+ ((empleado.getDomicilio() != null) ? "domicilio=\"" + empleado.getDomicilio() + "\"," : "")
					+ ((empleado.getCp() != null) ? "CP=\"" + empleado.getCp() + "\"," : "") + "email=\""
					+ empleado.getEmail() + "\"," + "fechaNac=\"" + empleado.getFecha() + "\"," + "cargo=\""
					+ empleado.getCargo() + "\" " + "WHERE DNI=\"" + empleado.getDNI() + "\"";

			if (stmt.executeUpdate(query) == 1)
				actualizado = true;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return actualizado;

	}

	@Override
	public boolean insertaEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertaCliente(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cliente> getClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCliente(String dni) {
		// TODO Auto-generated method stub
		return false;
	}

}
