package empleado.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import control.Conexi�n;
import empleado.control.empleados;
import empleado.entity.empleado;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.empleadoFantasma;
public class empleadoView {
		private empleados empleados;
		private Scanner scanner;
		private Conexi�n conexi�n;
		public empleadoView(empleados empleados,Conexi�n conexion,Scanner scanner) {
			this.conexi�n = conexion;
			this.empleados = empleados;
			
			this.scanner = scanner;
		}
		public void addEmpleado() {
			
			empleado empleado= empleadoRegistro.ingresar(scanner);
			String sql = "Insert into empleado(String nombreEmpleado, int dNIEmpleado) " + "values(?,?)";
			try {
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setString(1, empleado.getNombreEmpleado());
				conexi�n.getSentencia().setInt(2, empleado.getDNIEmpleado());
				conexi�n.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
			
	}
		
		public void listEmpleado()throws SQLException  {
				empleado empleado;
				String sql = "select * from empleado ";
				conexi�n.consulta(sql);
				ResultSet resultSet = conexi�n.resultado();
				while (resultSet.next()) {
					empleado = new empleado(resultSet.getInt("codigoEmpleado"), resultSet.getString("nombreEmpleado"),resultSet.getInt("dNIEmpleado"));
					System.out.println(empleado);
				}
			}
		
		public void deleteEmpleado() throws SQLException{
			int codEmpleado = InputTypes.readInt("Ingrese el codigo del Empleado", scanner);
			
				String sql = "delete " + "from Empleado " + "where c�digo = ?";
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, codEmpleado);
				conexi�n.modificacion();
			}
		public void update() throws SQLException, empleadoFantasma{
			ResultSet resultSet;
			empleado empleado;
			String nombreEmpleado;
			int DNIEmpleado;
			int codEmpleado = InputTypes.readInt("C�digo del empleado: ", scanner);
			String sql = "select * from empleado where c�digo = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codEmpleado);
			resultSet = conexi�n.resultado();
			if (resultSet.next()) {
				
				nombreEmpleado = resultSet.getString("nombreEmpleado");
				DNIEmpleado = resultSet.getInt("DNIEmpleado");
				
				empleado = new empleado(codEmpleado, nombreEmpleado, DNIEmpleado);
			} else {
				throw new empleadoFantasma();
			}

			System.out.println(empleado);
			empleadoMenu.men�Modificar(scanner, empleado);
			sql = "update empleado set nombreEmpleado = ?. DNIEmpleado = ? where c�digo = ? ";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setString(1, empleado.getNombreEmpleado());
			conexi�n.getSentencia().setInt(2, empleado.getDNIEmpleado());
			conexi�n.modificacion();
		}


	}