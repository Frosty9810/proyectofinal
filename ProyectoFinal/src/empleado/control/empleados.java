package empleado.control;

import empleado.entity.empleado;
import excepcionesInputTypes.empleadoFantasma;

public class empleados {
			private empleado[] empleados;
		private int cantidad;
		private int ultimo;
		
		public empleados (int tamaño) {
			empleados = new empleado[tamaño];
			cantidad = 0;
			ultimo = -1;
		}
		public void ingresar(empleado empleado) throws java.lang.ArrayIndexOutOfBoundsException {
			empleados[++ultimo]=empleado;
				cantidad++;
		}
		public void eliminar(int codEmpleado) throws empleadoFantasma {
			int indice = buscar(codEmpleado);
			if(indice>=0) {
				if(indice!=ultimo) {
					for(int i=indice; i<=ultimo;i++) {
						empleados[i]=empleados[i+1];
					}
				}
				ultimo--;
				cantidad--;
			}
			
		}
		public int buscar(int codEmpleado) throws empleadoFantasma {
			int posicion = -1;
			
			int indice=0;
			while(indice<=ultimo) {
				if(empleados[indice].getCodigoEmpleado()==codEmpleado) {
					posicion=indice;
					break;
				}
				indice++;
			}
			if (posicion==-1){
			throw new empleadoFantasma();
			}
			return posicion;
		}
		
		
		public empleado[] getEmpleados() {
			return empleados;
		}
		public int getCantidad() {
			return cantidad;
		}
		
		
	}