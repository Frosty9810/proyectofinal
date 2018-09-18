package com.proveedor.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.detCompra.entity.DetalleDeCompra;
import com.detCompra.view.detCompraMenu;
import com.proveedor.control.ProveedorC;
import com.proveedor.entity.Proveedor;

import control.Conexi�n;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.autoFantasma;
import excepcionesInputTypes.detCompraFantasma;
import excepcionesInputTypes.proveedorFantasma;


public class proveedorView {
	private Scanner scanner;
	private Conexi�n conexi�n;
	
	
	public proveedorView(Scanner scanner,Conexi�n conexion, ProveedorC proveedores) {
		this.conexi�n = conexion;
		
		this.scanner = scanner;
	}
public void addProveedor() {
		
		Proveedor proveedor = proveedorRegistro.ingresar(scanner);
		String sql = "Insert into Auto (nombreProveedor) " + "values(?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setString(1, proveedor.getNombreProveedor());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
}
	
	public void listProveedor()throws SQLException  {
			Proveedor proveedor;
			String sql = "select * from Proveedor ";
			conexi�n.consulta(sql);
			ResultSet resultSet = conexi�n.resultado();
			while (resultSet.next()) {
				proveedor = new Proveedor(resultSet.getInt("codigoProveedor"), resultSet.getString("nombreProveedor"));
				System.out.println(proveedor);
			}
		}
	
	public void deleteProveedor() throws SQLException{
		int codProveedor = InputTypes.readInt("Ingrese el codigo del proveedor", scanner);
		
			String sql = "delete " + "from Proveedor " + "where c�digo = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codProveedor);
			conexi�n.modificacion();
		}
	
	public void update() throws SQLException, proveedorFantasma{
		ResultSet resultSet;
		Proveedor proveedor;
		String nombreProveedor;
		int codProveedor = InputTypes.readInt("C�digo del proveedor: ", scanner);
		String sql = "select * from Proveedor where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codProveedor);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nombreProveedor = resultSet.getString("nombreProvedor");
			proveedor = new Proveedor(codProveedor, nombreProveedor);
		} else {
			throw new proveedorFantasma();
		}

		System.out.println(proveedor);
		proveedorMenu.men�Modificar(scanner, proveedor);

		sql = "update proveedor set nombreProveedor = ? where c�digo = ? ";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setString(1, proveedor.getNombreProveedor());
		conexi�n.modificacion();
	}


	}

