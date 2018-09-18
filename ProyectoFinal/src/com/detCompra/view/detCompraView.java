package com.detCompra.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.control.Autos;
import com.detCompra.entity.DetalleDeCompra;

import control.Conexi�n;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.autoFantasma;
import excepcionesInputTypes.compraFantasma;
import excepcionesInputTypes.detCompraFantasma;

import com.compra.control.compras;

public class detCompraView {
	private Scanner scanner;
	private compras compras;
	private Autos autos;
	
	private Conexi�n conexi�n;
	
	public detCompraView(Conexi�n conexion ,Scanner scanner) {
		
		//this.detVentas = detVentas;
		this.conexi�n = conexion;
		this.scanner = scanner;
	}
public void addDetCompra() throws autoFantasma, compraFantasma {
		
		DetalleDeCompra detCompra = detCompraRegistro.ingresar(compras, autos,scanner);
		String sql = "Insert into Auto (fechaCompra, descuetnos, garantia, codigoCompra, codigoAutomovil) " + "values(?,?,?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, detCompra.getFechaCompra());
			conexi�n.getSentencia().setInt(2, detCompra.getDescuentos());
			conexi�n.getSentencia().setInt(3, detCompra.getGarantia());
			conexi�n.getSentencia().setInt(4, detCompra.getCodigoCompra());
			conexi�n.getSentencia().setInt(5, detCompra.getCodigoAutomovil());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
}
	
	public void listDetCompra()throws SQLException  {
			DetalleDeCompra detCompra;
			String sql = "select * from DetalleDeCompra ";
			conexi�n.consulta(sql);
			ResultSet resultSet = conexi�n.resultado();
			while (resultSet.next()) {
				detCompra = new DetalleDeCompra(resultSet.getInt("codigoDetCompra"), resultSet.getInt("fechaCompra"), resultSet.getInt("descuetnos"), resultSet.getInt("garantia"), resultSet.getInt("codigoCompra"), resultSet.getInt("codgoAutomovil"));
				System.out.println(detCompra);
			}
		}
	
	public void deleteDetComrpa() throws SQLException{
		int codDetCompra = InputTypes.readInt("Ingrese el codigo del detalle de compra", scanner);
		
			String sql = "delete " + "from DetalleDeCompra " + "where c�digo = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codDetCompra);
			conexi�n.modificacion();
		}
	//public detVentas getDetVenta() {
	//	return detVentas;
	//}
	

	public void update() throws autoFantasma, SQLException, detCompraFantasma {
		ResultSet resultSet;
		DetalleDeCompra detCompra;
		int fechaCompra;
		int descuentos;
		int garantia;
		int codigoCompra;
		int codigoAutomovil;
		int codDetCompra = InputTypes.readInt("C�digo del detalle de compra: ", scanner);
		String sql = "select * from DetallaDeCompra where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codDetCompra);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			fechaCompra= resultSet.getInt("fechaCompra");
			descuentos= resultSet.getInt("descuentos");
			garantia= resultSet.getInt("garantia");
			codigoCompra= resultSet.getInt("codigoCompra");
			codigoAutomovil= resultSet.getInt("codigoAutomovil");
			detCompra = new DetalleDeCompra(codDetCompra, fechaCompra, descuentos, garantia, codigoCompra, codigoAutomovil);
		} else {
			throw new detCompraFantasma();
		}

		System.out.println(detCompra);
		detCompraMenu.men�Modificar(scanner, detCompra);

		sql = "update detCompra set fechaCompra = ?,descuentos = ?, garantia = ?,codigoCompra = ?, codigoAutomovil = ? where c�digo = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, detCompra.getFechaCompra());
		conexi�n.getSentencia().setInt(2, detCompra.getDescuentos());
		conexi�n.getSentencia().setInt(3, detCompra.getGarantia());
		conexi�n.getSentencia().setInt(4, detCompra.getCodigoCompra());
		conexi�n.getSentencia().setInt(5, detCompra.getCodigoAutomovil());
		conexi�n.modificacion();
	}


}
