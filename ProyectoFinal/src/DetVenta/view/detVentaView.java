package DetVenta.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.control.autos;

import DetVenta.control.detVentas;
import DetVenta.entity.detVenta;
import control.Conexi�n;
import empleado.control.empleados;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.autoFantasma;
import excepcionesInputTypes.detVentaFantasma;
import excepcionesInputTypes.empleadoFantasma;
import excepcionesInputTypes.ventaFantasma;
import venta.control.ventas;
public class detVentaView {
		private detVentas detVentas;
		private Scanner scanner;
		private empleados empleados;
		private ventas ventas;
		private autos autos;
		private Conexi�n conexi�n;
		
		
		public detVentaView(detVentas detVentas,empleados empleados,ventas ventas,autos autos,Conexi�n conexion,Scanner scanner) {
			this.conexi�n= conexion;
			this.detVentas = detVentas;
			this.empleados = empleados;
			this.autos = autos;
			this.ventas = ventas;
			
			this.scanner = scanner;
		}
		public void addDetVenta() throws empleadoFantasma, autoFantasma, ventaFantasma {
			
			detVenta detVenta= detVentaRegistro.ingresar(scanner, empleados, ventas, autos);
			String sql = "Insert into detVenta (fechaVentaA�o, fechaVentaMes, fechaVentaDia, codigoEmpleado,codigoAutomovil,codigoVenta) " + "values(?,?,?,?,?,?)";
			try {
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, detVenta.getFechaVentaA�o());
				conexi�n.getSentencia().setInt(2, detVenta.getFechaVentaMes());
				conexi�n.getSentencia().setInt(3, detVenta.getFechaVentaDia());
				conexi�n.getSentencia().setInt(4, detVenta.getCodigoEmpleado());
				conexi�n.getSentencia().setInt(5, detVenta.getCodigoAutomovil());
				conexi�n.getSentencia().setInt(6, detVenta.getCodigoVenta());
				conexi�n.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
			
	}
		
		public void listDetVenta()throws SQLException  {
				detVenta detVenta;
				String sql = "select * from detVenta ";
				conexi�n.consulta(sql);
				ResultSet resultSet = conexi�n.resultado();
				while (resultSet.next()) {
					detVenta = new detVenta(resultSet.getInt("codigoDetVenta"), resultSet.getInt("fechaVentaA�o"), resultSet.getInt("fechaVentaMes"), resultSet.getInt("fechaVentaDia"), resultSet.getInt("codigoEmpleado"), resultSet.getInt("codigoAutomovil"), resultSet.getInt("codigoVenta"));
					System.out.println(detVenta);
				}
			}
		
		public void deletedetVenta() throws SQLException{
			int codDetVenta = InputTypes.readInt("Ingrese el codigo del detalle de venta", scanner);
			
				String sql = "delete " + "from detVenta " + "where c�digo = ?";
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, codDetVenta);
				conexi�n.modificacion();
			}
		public void update() throws SQLException, detVentaFantasma{
			ResultSet resultSet;
			detVenta detVenta;
			
			 int fechaVentaA�o;
			 int fechaVentaMes;
			 int fechaVentaDia;
			 int codigoEmpleado;
			 int codigoAutomovil;
			 int codigoVenta;
			int coddetVenta = InputTypes.readInt("C�digo del detalle de venta: ", scanner);
			String sql = "select * from detVenta where c�digo = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, coddetVenta);
			resultSet = conexi�n.resultado();
			if (resultSet.next()) {
				fechaVentaA�o = resultSet.getInt("fechaVentaA�o");
				fechaVentaMes = resultSet.getInt("fechaVentaMes");
				fechaVentaDia = resultSet.getInt("fechaVentaDia");
				codigoEmpleado = resultSet.getInt("codigoEmpleado");
				codigoAutomovil = resultSet.getInt("codigoAutomovil");
				
				codigoVenta = resultSet.getInt("codigoVenta");
				detVenta = new detVenta(coddetVenta, fechaVentaA�o, fechaVentaMes, fechaVentaDia, codigoEmpleado,codigoAutomovil,codigoVenta);
			} else {
				throw new detVentaFantasma();
			}

			System.out.println(detVenta);
			detVentaMenu.men�Modificar(scanner, detVenta);

			sql = "update detVenta set fechaVentaA�o=?, fechaVentaMes=?, fechaVentaDia=?, codigoEmpleado=?,codigoAutomovil=?,codigoVenta = ? where c�digo = ? ";

			conexi�n.consulta(sql);

			conexi�n.getSentencia().setInt(1, detVenta.getFechaVentaA�o());
			conexi�n.getSentencia().setInt(1, detVenta.getFechaVentaMes());
			conexi�n.getSentencia().setInt(1, detVenta.getFechaVentaDia());
			conexi�n.getSentencia().setInt(1, detVenta.getCodigoAutomovil());
			conexi�n.getSentencia().setInt(1, detVenta.getCodigoEmpleado());
			conexi�n.getSentencia().setInt(1, detVenta.getCodigoVenta());
			conexi�n.modificacion();
		}

		
	}