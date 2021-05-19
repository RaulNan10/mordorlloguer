package com.mordor.mordorLloguer.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import oracle.jdbc.datasource.impl.OracleDataSource;

public class MyDataSource {

	private static String defaultProperties = "db.properties";
	
			
	public static DataSource getMySQLDataSource() {

		MysqlDataSource ds = null;

		Properties prop = new Properties();
		
		

		try (FileInputStream fis = new FileInputStream(defaultProperties)) {

			prop.load(fis);

			ds = new MysqlDataSource();
			ds.setUrl(prop.getProperty("MYSQL_DB_URL"));
			ds.setUser(prop.getProperty("MYSQL_DB_USERNAME"));
			ds.setPassword(prop.getProperty("MYSQL_DB_PASSWORD"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ds;
	}
	
	

	public static DataSource getOracleDataSource() {

		// Propiedades donde tenemos los datos de acceso a la BD

		Properties props = new Properties();

		// Objeto DataSource que devolveremos

		OracleDataSource oracleDS = null;

		try (FileInputStream fis = new FileInputStream("db.properties");) {

			// Cargamos las propiedades

			props.load(fis);

			// Generamos el DataSource con los datos URL, user y passwd necesarios

			oracleDS = new OracleDataSource();

			oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));

			oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));

			oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));

		} catch (IOException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return oracleDS;

	}

}
