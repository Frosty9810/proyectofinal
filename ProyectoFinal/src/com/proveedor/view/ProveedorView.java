package com.proveedor.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.detCompra.entity.DetalleDeCompra;
import com.detCompra.view.detCompraMenu;
import com.proveedor.control.ProveedorC;
import com.proveedor.entity.Proveedor;

import control.Conexión;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.autoFantasma;
import excepcionesInputTypes.detCompraFantasma;
import excepcionesInputTypes.proveedorFantasma;


public class proveedorView {
	private Scanner scanner;
	private Conexión conexión;
	
	
	public proveedorView(Scanner scanner,Conexión conexion, ProveedorC proveedores) {
		this.conexión = conexion;
		
		this.scanner = scanner;
	}
public void addProveedor() {
		
		Proveedor proveedor = proveedorRegistro.ingresar(scanner);
		String sql = "Insert into Auto (nombreProveedor) " + "values(?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setString(1, proveedor.getNombreProveedor());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
}
	
	public void listProveedor()throws SQLException  {
			Proveedor proveedor;
			String sql = "select * from Proveedor ";
			conexión.consulta(sql);
			ResultSet resultSet = conexión.resultado();
			while (resultSet.next()) {
				proveedor = new Proveedor(resultSet.getInt("codigoProveedor"), resultSet.getString("nombreProveedor"));
				System.out.println(proveedor);
			}
		}
	
	public void deleteProveedor() throws SQLException{
		int codProveedor = InputTypes.readInt("Ingrese el codigo del proveedor", scanner);
		
			String sql = "delete " + "from Proveedor " + "where código = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, codProveedor);
			conexión.modificacion();
		}
	
	public void update() throws SQLException, proveedorFantasma{
		ResultSet resultSet;
		Proveedor proveedor;
		String nombreProveedor;
		int codProveedor = InputTypes.readInt("Código del proveedor: ", scanner);
		String sql = "select * from Proveedor where código = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codProveedor);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nombreProveedor = resultSet.getString("nombreProvedor");
			proveedor = new Proveedor(codProveedor, nombreProveedor);
		} else {
			throw new proveedorFantasma();
		}

		System.out.println(proveedor);
		proveedorMenu.menúModificar(scanner, proveedor);

		sql = "update proveedor set nombreProveedor = ? where código = ? ";

		conexión.consulta(sql);
		conexión.getSentencia().setString(1, proveedor.getNombreProveedor());
		conexión.modificacion();
	}


	}

