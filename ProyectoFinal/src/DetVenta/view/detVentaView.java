package DetVenta.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.control.Autos;
import com.automovil.entity.Auto;
import com.automovil.view.RegistroAuto;

import DetVenta.control.detVentas;
import DetVenta.entity.detVenta;
import control.Conexión;
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
		private Conexión conexión;
		
		
		public detVentaView(detVentas detVentas,empleados empleados,ventas ventas,Autos autos,Conexión conexion,Scanner scanner) {
			this.conexión= conexion;
			this.detVentas = detVentas;
			this.empleados = empleados;
			this.autos = autos;
			this.ventas = ventas;
			
			this.scanner = scanner;
		}
		public void addDetVenta() {
			
			detVenta detVenta= detVentaRegistro.ingresar(scanner);
			String sql = "Insert into detVenta (fechaVentaAño, fechaVentaMes, fechaVentaDia, codigoEmpleado,codigoAutomovil,codigoVenta) " + "values(?,?,?,?,?,?)";
			try {
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, detVenta.getFechaVentaAño());
				conexión.getSentencia().setInt(2, detVenta.getFechaVentaMes());
				conexión.getSentencia().setInt(3, detVenta.getFechaVentaDia());
				conexión.getSentencia().setInt(4, detVenta.getCodigoEmpleado());
				conexión.getSentencia().setInt(5, detVenta.getCodigoAutomovil());
				conexión.getSentencia().setInt(6, detVenta.getCodigoVenta());
				conexión.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
			
	}
		
		public void listDetVenta()throws SQLException  {
				detVenta detVenta;
				String sql = "select * from detVenta ";
				conexión.consulta(sql);
				ResultSet resultSet = conexión.resultado();
				while (resultSet.next()) {
					detVenta = new detVenta(resultSet.getInt("codigoDetVenta"), resultSet.getInt("fechaVentaAño"), resultSet.getInt("fechaVentaMes"), resultSet.getInt("fechaVentaDia"), resultSet.getInt("codigoEmpleado"), resultSet.getInt("codigoAutomovil"), resultSet.getInt("codigoVenta"));
					System.out.println(detVenta);
				}
			}
		
		public void deletedetVenta() throws SQLException{
			int codDetVenta = InputTypes.readInt("Ingrese el codigo del detalle de venta", scanner);
			
				String sql = "delete " + "from detVenta " + "where código = ?";
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, codDetVenta);
				conexión.modificacion();
			}
	}