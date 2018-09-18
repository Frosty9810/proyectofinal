package com.automovil.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.control.autos;
import com.automovil.entity.Auto;
import com.compra.control.compras;

import control.Conexi�n;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.autoFantasma;



public class AutoView {
	private Scanner scanner;
	private Conexi�n conexi�n;
	private autos autos;
	private compras compras;
	public AutoView(autos autos, compras compras,Conexi�n conexion, Scanner scanner) {
		this.conexi�n = conexion;
		this.autos=autos;
		this.compras=compras;
		this.scanner = scanner;
	}
	public AutoView(autos autos, compras compras, Scanner scanner2) {
		// TODO Auto-generated constructor stub
	}
	public void addAuto() {
		
		Auto auto = RegistroAuto.ingresar(scanner);
		String sql = "Insert into Auto (tipoAuto, marcaAuto, numeroChasis, procedencia, color, precio, garantia) " + "values(?,?,?,?,?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setString(1, auto.getTipoAuto());
			conexi�n.getSentencia().setString(2, auto.getMarcaAuto());
			conexi�n.getSentencia().setInt(3, auto.getNumeroChasis());
			conexi�n.getSentencia().setString(4, auto.getProcedencia());
			conexi�n.getSentencia().setString(5, auto.getColor());
			conexi�n.getSentencia().setDouble(6, auto.getPrecio());
			conexi�n.getSentencia().setString(7, auto.getGarantia());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
}
	
	public void listAuto()throws SQLException  {
			Auto auto;
			String sql = "select * from Auto ";
			conexi�n.consulta(sql);
			ResultSet resultSet = conexi�n.resultado();
			while (resultSet.next()) {
				auto = new Auto(resultSet.getInt("codigoAutomovil"), resultSet.getString("tipoAuto"), resultSet.getString("marcaAuto"), resultSet.getInt("tiponumeroChasis"), resultSet.getString("procedencia"), resultSet.getString("color"), resultSet.getDouble("precio"), resultSet.getString("garantia"));
				System.out.println(auto);
			}
		}
	
	public void deleteAuto() throws SQLException{
		int codAuto = InputTypes.readInt("Ingrese el codigo del Auto", scanner);
		
			String sql = "delete " + "from Auto " + "where c�digo = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codAuto);
			conexi�n.modificacion();
		}
	
	public void update() throws autoFantasma, SQLException {
		ResultSet resultSet;
		Auto auto;
		String tipoAuto;
		String marca;
		int numeroChasis;
		double precio;
		String procedencia;
		String color;
		String garantia;
		int codAuto = InputTypes.readInt("C�digo del auto: ", scanner);
		String sql = "select * from Auto where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codAuto);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			tipoAuto = resultSet.getString("tipoAuto");
			numeroChasis = resultSet.getInt("numeroChasis");
			marca= resultSet.getString("marcaAuto");
			precio = resultSet.getDouble("precio");
			procedencia= resultSet.getString("procedencia");
			color= resultSet.getString("color");
			garantia= resultSet.getString("garantia");
			
			auto = new Auto(codAuto, tipoAuto, marca, numeroChasis, procedencia, color, precio, garantia);
		} else {
			throw new autoFantasma();
		}

		System.out.println(auto);
		AutoMenu.men�Modificar(scanner, auto);

		sql = "update auto set tipoAuto = ?, marca = ?, numeroChasis = ?, procedencia = ?, color = ?, precio = ?, garantia = ? where c�digo = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setString(1, auto.getTipoAuto());
		conexi�n.getSentencia().setString(2, auto.getMarcaAuto());
		conexi�n.getSentencia().setInt(3, auto.getNumeroChasis());
		conexi�n.getSentencia().setString(4, auto.getProcedencia());
		conexi�n.getSentencia().setString(5, auto.getColor());
		conexi�n.getSentencia().setDouble(6, auto.getPrecio());
		conexi�n.getSentencia().setString(7, auto.getGarantia());
		conexi�n.modificacion();
	}

}
