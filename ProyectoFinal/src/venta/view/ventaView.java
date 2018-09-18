package venta.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.entity.Auto;
import com.automovil.view.RegistroAuto;

import cliente.control.clientes;
import control.Conexi�n;
import venta.control.ventas;
import venta.entity.venta;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;
import excepcionesInputTypes.ventaFantasma;
public class ventaView {
		private ventas ventas;
		private Scanner scanner;
		private clientes clientes;
		private Conexi�n conexi�n;
		public ventaView(ventas ventas, clientes clientes ,Conexi�n conexion,Scanner scanner) {
			
			this.ventas = ventas;
			this.conexi�n = conexion;
			this.scanner = scanner;
		}
		
		public void addVenta() {
			
			venta venta = ventaRegistro.ingresar(scanner);
			String sql = "Insert into venta ( int numeroVenta, String reservacion, int codigoCliente) " + "values(?,?,?)";
			try {
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, venta.getNumeroVenta());
				conexi�n.getSentencia().setString(2, venta.getReservacion());
				conexi�n.getSentencia().setInt(3, venta.getCodigoCliente());
				conexi�n.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
			
	}
		
		public void listVenta()throws SQLException  {
				venta venta;
				String sql = "select * from venta ";
				conexi�n.consulta(sql);
				ResultSet resultSet = conexi�n.resultado();
				while (resultSet.next()) {
					venta = new venta(resultSet.getInt("codigoVenta"), resultSet.getInt("numeroVenta"), resultSet.getString("reservacion"), resultSet.getInt("codigoCliente"));
					System.out.println(venta);
				}
			}
		
		public void deleteVenta() throws SQLException{
			int codVenta = InputTypes.readInt("Ingrese el codigo de la venta", scanner);
			
				String sql = "delete " + "from venta " + "where c�digo = ?";
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, codVenta);
				conexi�n.modificacion();
			}
	}