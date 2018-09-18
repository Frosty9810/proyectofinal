package com.compra.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.compra.control.compras;
import com.compra.entity.Compra;

import control.Conexión;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.compraFantasma;


public class CompraView {
	private Scanner scanner;
	private Conexión conexión;
	private compras compras;
	public CompraView(compras compras,Conexión conexion,Scanner scanner) {
		this.compras=compras;
		this.conexión = conexion;
		this.scanner = scanner;
	}
public void addCompra() throws compraFantasma {
	
	Compra compra = compraRegistro.ingresar(scanner);
	String sql = "Insert into Compra (codigoProveedor) " + "values(?)";
	try {
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, compra.getCodigoProveedor());
		conexión.modificacion();
	} catch (SQLException e) {
		System.out.println(e.getSQLState());
	}
	
}

public void listCompra()throws SQLException  {
		Compra compra;
		String sql = "select * from Compra ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			compra = new Compra(resultSet.getInt("codigoCompra"), resultSet.getInt("codigoProveedor"));
			System.out.println(compra);
		}
	}

public void deleteCompra() throws SQLException{
	int codCompra = InputTypes.readInt("Ingrese el codigo de la compra", scanner);
	
		String sql = "delete " + "from Compra " + "where código = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCompra);
		conexión.modificacion();
	}
public void update() throws compraFantasma, SQLException {
	ResultSet resultSet;
	Compra compra;
	int codigoProveedor;
	

	int codCompra = InputTypes.readInt("Código de la compra: ", scanner);
	String sql = "select * from Compra where código = ?";
	conexión.consulta(sql);
	conexión.getSentencia().setInt(1, codCompra);
	resultSet = conexión.resultado();
	if (resultSet.next()) {
		codigoProveedor = resultSet.getInt("codigoProveedor");
		
		compra = new Compra(codCompra,codigoProveedor);
	} else {
		throw new compraFantasma();
	}

	System.out.println(compra);
	compraMenu.menúModificar(scanner, compra);

	sql = "update compra set codigoProveedor = ? where código = ?";

	conexión.consulta(sql);
	conexión.getSentencia().setInt(1, compra.getCodigoProveedor());
	conexión.modificacion();
}

	
}


