package empleado.view;
 import java.util.Scanner;

import empleado.entity.empleado;
import excepcionesInputTypes.InputTypes;
public class empleadoRegistro {
		public static empleado ingresar(Scanner scanner) {
			
			String nombreEmpleado= InputTypes.readString("Nombre: ", scanner);
			int codigoEmpleado = InputTypes.readInt("Codigo empleado: ", scanner);
			int DNIEmpleado = InputTypes.readInt("DNI empleado: ", scanner);
			
			return new empleado(codigoEmpleado,nombreEmpleado,DNIEmpleado);
			
		}
	}
