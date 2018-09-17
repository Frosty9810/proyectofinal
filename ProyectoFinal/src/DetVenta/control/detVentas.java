package DetVenta.control;

import DetVenta.entity.detVenta;
import excepcionesInputTypes.detVentaFantasma;

public class detVentas {
			private detVenta[] detVentas;
		private int cantidad;
		private int ultimo;
		
		public detVentas (int tamaño) {
			detVentas = new detVenta[tamaño];
			cantidad = 0;
			ultimo = -1;
		}
		public void ingresar(detVenta detVenta) throws java.lang.ArrayIndexOutOfBoundsException {
			detVentas[++ultimo]=detVenta;
				cantidad++;
		}
		public void eliminar(int codDetVenta) throws detVentaFantasma {
			int indice = buscar(codDetVenta);
			if(indice>=0) {
				if(indice!=ultimo) {
					for(int i=indice; i<=ultimo;i++) {
						detVentas[i]=detVentas[i+1];
					}
				}
				ultimo--;
				cantidad--;
			}
			
		}
		public int buscar(int codDetVenta) throws detVentaFantasma {
			int posicion = -1;
			
			int indice=0;
			while(indice<=ultimo) {
				if(detVentas[indice].getCodigoDetVenta()==codDetVenta) {
					posicion=indice;
					break;
				}
				indice++;
			}
			if (posicion==-1){
			throw new detVentaFantasma();
			}
			return posicion;
		}
		
		
		public detVenta[] getDetVenta() {
			return detVentas;
		}
		public int getCantidad() {
			return cantidad;
		}
		
		
	}