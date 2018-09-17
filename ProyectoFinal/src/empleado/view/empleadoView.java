package empleado.view;
import java.util.Scanner;

import empleado.control.empleados;
import empleado.entity.empleado;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.empleadoFantasma;
public class empleadoView {
		private empleados empleados;
		private Scanner scanner;
		
		public empleadoView(empleados empleados,Scanner scanner) {
			
			this.empleados = empleados;
			
			this.scanner = scanner;
		}
		
		public void addEmpleado() {
			empleado empleado;
			
			empleado = empleadoRegistro.ingresar(scanner);
			empleados.ingresar(empleado);
					
		}
		
		public void listEmpleado() {
			for(int i=0; i<empleados.getCantidad(); i++) {
				System.out.println(empleados.getEmpleados()[i]);
			}
		}
		
		public void deleteEmpleado() throws empleadoFantasma {
			int codEmpleado = InputTypes.readInt("Ingrese el codigo del empleado", scanner);
			empleados.eliminar(codEmpleado);	
		}

		public empleados getEmpleado() {
			return empleados;
		}
	}