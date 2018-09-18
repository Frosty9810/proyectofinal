package venta.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


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
		
		public void addVenta() throws clienteFantasma {
			
			venta venta = ventaRegistro.ingresar(scanner, clientes);
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
		public void update() throws SQLException, ventaFantasma{
			ResultSet resultSet;
			venta venta;
			
			 int codigoCliente;
			 int numeroVenta;
			 String reservacion;
			int codVenta = InputTypes.readInt("Código de la venta: ", scanner);
			String sql = "select * from venta where código = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, codVenta);
			resultSet = conexión.resultado();
			if (resultSet.next()) {
				codigoCliente = resultSet.getInt("codigoCliente");
				numeroVenta = resultSet.getInt("numeroVenta");
				reservacion = resultSet.getString("reservacion");
				
				venta = new venta(codVenta, numeroVenta, reservacion,codigoCliente);
			} else {
				throw new ventaFantasma();
			}

			System.out.println(venta);
			ventaMenu.menúModificar(scanner, venta);

			sql = "update venta set codigoCliente = ?, numeroVenta = ?, reservacion = ? where código = ? ";

			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, venta.getNumeroVenta());
			conexión.getSentencia().setString(2, venta.getReservacion());
			conexión.getSentencia().setInt(3, venta.getCodigoCliente());
			conexión.modificacion();
		}

		
	}