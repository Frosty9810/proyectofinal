package com.compra.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.compra.control.compras;
import com.compra.entity.Compra;

import control.Conexi�n;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.compraFantasma;


public class CompraView {
	private Scanner scanner;
	private Conexi�n conexi�n;
	private compras compras;
	public CompraView(compras compras,Conexi�n conexion,Scanner scanner) {
		this.compras=compras;
		this.conexi�n = conexion;
		this.scanner = scanner;
	}
public void addCompra() throws compraFantasma {
	
	Compra compra = compraRegistro.ingresar(scanner);
	String sql = "Insert into Compra (codigoProveedor) " + "values(?)";
	try {
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, compra.getCodigoProveedor());
		conexi�n.modificacion();
	} catch (SQLException e) {
		System.out.println(e.getSQLState());
	}
	
}

public void listCompra()throws SQLException  {
		Compra compra;
		String sql = "select * from Compra ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			compra = new Compra(resultSet.getInt("codigoCompra"), resultSet.getInt("codigoProveedor"));
			System.out.println(compra);
		}
	}

public void deleteCompra() throws SQLException{
	int codCompra = InputTypes.readInt("Ingrese el codigo de la compra", scanner);
	
		String sql = "delete " + "from Compra " + "where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codCompra);
		conexi�n.modificacion();
	}
public void update() throws compraFantasma, SQLException {
	ResultSet resultSet;
	Compra compra;
	int codigoProveedor;
	

	int codCompra = InputTypes.readInt("C�digo de la compra: ", scanner);
	String sql = "select * from Compra where c�digo = ?";
	conexi�n.consulta(sql);
	conexi�n.getSentencia().setInt(1, codCompra);
	resultSet = conexi�n.resultado();
	if (resultSet.next()) {
		codigoProveedor = resultSet.getInt("codigoProveedor");
		
		compra = new Compra(codCompra,codigoProveedor);
	} else {
		throw new compraFantasma();
	}

	System.out.println(compra);
	compraMenu.men�Modificar(scanner, compra);

	sql = "update compra set codigoProveedor = ? where c�digo = ?";

	conexi�n.consulta(sql);
	conexi�n.getSentencia().setInt(1, compra.getCodigoProveedor());
	conexi�n.modificacion();
}

	
}


