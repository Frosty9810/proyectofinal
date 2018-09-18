package com.automovil.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.control.autos;
import com.automovil.entity.Auto;
import com.compra.control.compras;

import control.Conexión;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.autoFantasma;



public class AutoView {
	private Scanner scanner;
	private Conexión conexión;
	private autos autos;
	private compras compras;
	public AutoView(autos autos, compras compras,Conexión conexion, Scanner scanner) {
		this.conexión = conexion;
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
			conexión.consulta(sql);
			conexión.getSentencia().setString(1, auto.getTipoAuto());
			conexión.getSentencia().setString(2, auto.getMarcaAuto());
			conexión.getSentencia().setInt(3, auto.getNumeroChasis());
			conexión.getSentencia().setString(4, auto.getProcedencia());
			conexión.getSentencia().setString(5, auto.getColor());
			conexión.getSentencia().setDouble(6, auto.getPrecio());
			conexión.getSentencia().setString(7, auto.getGarantia());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
}
	
	public void listAuto()throws SQLException  {
			Auto auto;
			String sql = "select * from Auto ";
			conexión.consulta(sql);
			ResultSet resultSet = conexión.resultado();
			while (resultSet.next()) {
				auto = new Auto(resultSet.getInt("codigoAutomovil"), resultSet.getString("tipoAuto"), resultSet.getString("marcaAuto"), resultSet.getInt("tiponumeroChasis"), resultSet.getString("procedencia"), resultSet.getString("color"), resultSet.getDouble("precio"), resultSet.getString("garantia"));
				System.out.println(auto);
			}
		}
	
	public void deleteAuto() throws SQLException{
		int codAuto = InputTypes.readInt("Ingrese el codigo del Auto", scanner);
		
			String sql = "delete " + "from Auto " + "where código = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, codAuto);
			conexión.modificacion();
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
		int codAuto = InputTypes.readInt("Código del auto: ", scanner);
		String sql = "select * from Auto where código = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codAuto);
		resultSet = conexión.resultado();
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
		AutoMenu.menúModificar(scanner, auto);

		sql = "update auto set tipoAuto = ?, marca = ?, numeroChasis = ?, procedencia = ?, color = ?, precio = ?, garantia = ? where código = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setString(1, auto.getTipoAuto());
		conexión.getSentencia().setString(2, auto.getMarcaAuto());
		conexión.getSentencia().setInt(3, auto.getNumeroChasis());
		conexión.getSentencia().setString(4, auto.getProcedencia());
		conexión.getSentencia().setString(5, auto.getColor());
		conexión.getSentencia().setDouble(6, auto.getPrecio());
		conexión.getSentencia().setString(7, auto.getGarantia());
		conexión.modificacion();
	}

}
