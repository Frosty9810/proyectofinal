package venta.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.entity.Auto;
import com.automovil.view.RegistroAuto;

import cliente.control.clientes;
import control.Conexión;
import venta.control.ventas;
import venta.entity.venta;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;
import excepcionesInputTypes.ventaFantasma;
public class ventaView {
		private ventas ventas;
		private Scanner scanner;
		private clientes clientes;
		private Conexión conexión;
		public ventaView(ventas ventas, clientes clientes ,Conexión conexion,Scanner scanner) {
			
			this.ventas = ventas;
			this.conexión = conexion;
			this.scanner = scanner;
		}
		
		public void addVenta() {
			
			venta venta = ventaRegistro.ingresar(scanner);
			String sql = "Insert into venta ( int numeroVenta, String reservacion, int codigoCliente) " + "values(?,?,?)";
			try {
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, venta.getNumeroVenta());
				conexión.getSentencia().setString(2, venta.getReservacion());
				conexión.getSentencia().setInt(3, venta.getCodigoCliente());
				conexión.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
			
	}
		
		public void listVenta()throws SQLException  {
				venta venta;
				String sql = "select * from venta ";
				conexión.consulta(sql);
				ResultSet resultSet = conexión.resultado();
				while (resultSet.next()) {
					venta = new venta(resultSet.getInt("codigoVenta"), resultSet.getInt("numeroVenta"), resultSet.getString("reservacion"), resultSet.getInt("codigoCliente"));
					System.out.println(venta);
				}
			}
		
		public void deleteVenta() throws SQLException{
			int codVenta = InputTypes.readInt("Ingrese el codigo de la venta", scanner);
			
				String sql = "delete " + "from venta " + "where código = ?";
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, codVenta);
				conexión.modificacion();
			}
	}