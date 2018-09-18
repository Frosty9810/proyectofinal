package empleado.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.entity.Auto;
import com.automovil.view.RegistroAuto;

import control.Conexión;
import empleado.control.empleados;
import empleado.entity.empleado;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.empleadoFantasma;
public class empleadoView {
		private empleados empleados;
		private Scanner scanner;
		private Conexión conexión;
		public empleadoView(empleados empleados,Conexión conexion,Scanner scanner) {
			this.conexión = conexion;
			this.empleados = empleados;
			
			this.scanner = scanner;
		}
		public void addEmpleado() {
			
			empleado empleado= empleadoRegistro.ingresar(scanner);
			String sql = "Insert into empleado(String nombreEmpleado, int dNIEmpleado) " + "values(?,?)";
			try {
				conexión.consulta(sql);
				conexión.getSentencia().setString(1, empleado.getNombreEmpleado());
				conexión.getSentencia().setInt(2, empleado.getDNIEmpleado());
				conexión.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
			
	}
		
		public void listEmpleado()throws SQLException  {
				empleado empleado;
				String sql = "select * from empleado ";
				conexión.consulta(sql);
				ResultSet resultSet = conexión.resultado();
				while (resultSet.next()) {
					empleado = new empleado(resultSet.getInt("codigoEmpleado"), resultSet.getString("nombreEmpleado"),resultSet.getInt("dNIEmpleado"));
					System.out.println(empleado);
				}
			}
		
		public void deleteEmpleado() throws SQLException{
			int codEmpleado = InputTypes.readInt("Ingrese el codigo del Empleado", scanner);
			
				String sql = "delete " + "from Empleado " + "where código = ?";
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, codEmpleado);
				conexión.modificacion();
			}

	}