package DetVenta.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.control.Autos;
import com.automovil.entity.Auto;
import com.automovil.view.RegistroAuto;

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
		private Autos autos;
		private Conexi�n conexi�n;
		
		
		public detVentaView(detVentas detVentas,empleados empleados,ventas ventas,Autos autos,Conexi�n conexion,Scanner scanner) {
			this.conexi�n= conexion;
			this.detVentas = detVentas;
			this.empleados = empleados;
			this.autos = autos;
			this.ventas = ventas;
			
			this.scanner = scanner;
		}
		public void addDetVenta() {
			
			detVenta detVenta= detVentaRegistro.ingresar(scanner);
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
	}