package venta.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


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
		
		public void addVenta() throws clienteFantasma {
			
			venta venta = ventaRegistro.ingresar(scanner, clientes);
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
		public void update() throws SQLException, ventaFantasma{
			ResultSet resultSet;
			venta venta;
			
			 int codigoCliente;
			 int numeroVenta;
			 String reservacion;
			int codVenta = InputTypes.readInt("C�digo de la venta: ", scanner);
			String sql = "select * from venta where c�digo = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codVenta);
			resultSet = conexi�n.resultado();
			if (resultSet.next()) {
				codigoCliente = resultSet.getInt("codigoCliente");
				numeroVenta = resultSet.getInt("numeroVenta");
				reservacion = resultSet.getString("reservacion");
				
				venta = new venta(codVenta, numeroVenta, reservacion,codigoCliente);
			} else {
				throw new ventaFantasma();
			}

			System.out.println(venta);
			ventaMenu.men�Modificar(scanner, venta);

			sql = "update venta set codigoCliente = ?, numeroVenta = ?, reservacion = ? where c�digo = ? ";

			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, venta.getNumeroVenta());
			conexi�n.getSentencia().setString(2, venta.getReservacion());
			conexi�n.getSentencia().setInt(3, venta.getCodigoCliente());
			conexi�n.modificacion();
		}

		
	}