package venta.control;

import venta.entity.venta;
import excepcionesInputTypes.ventaFantasma;

public class ventas {
			private venta[] ventas;
		private int cantidad;
		private int ultimo;
		
		public ventas (int tamaño) {
			ventas = new venta[tamaño];
			cantidad = 0;
			ultimo = -1;
		}
		public void ingresar(venta venta) throws java.lang.ArrayIndexOutOfBoundsException {
			ventas[++ultimo]=venta;
				cantidad++;
		}
		public void eliminar(int codVenta) throws ventaFantasma {
			int indice = buscar(codVenta);
			if(indice>=0) {
				if(indice!=ultimo) {
					for(int i=indice; i<=ultimo;i++) {
						ventas[i]=ventas[i+1];
					}
				}
				ultimo--;
				cantidad--;
			}
			
		}
		public int buscar(int codVenta) throws ventaFantasma {
			int posicion = -1;
			
			int indice=0;
			while(indice<=ultimo) {
				if(ventas[indice].getCodigoVenta()==codVenta) {
					posicion=indice;
					break;
				}
				indice++;
			}
			if (posicion==-1){
			throw new ventaFantasma();
			}
			return posicion;
		}
		
		
		public venta[] getVentas() {
			return ventas;
		}
		public int getCantidad() {
			return cantidad;
		}
		
		
	}