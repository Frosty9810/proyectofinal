package cliente.control;

import cliente.entity.Cliente;
import excepcionesInputTypes.clienteFantasma;

public class clientes {
			private Cliente[] clientes;
		private int cantidad;
		private int ultimo;
		
		public clientes (int tamaño) {
			clientes = new Cliente[tamaño];
			cantidad = 0;
			ultimo = -1;
		}
		public void ingresar(Cliente cliente) throws java.lang.ArrayIndexOutOfBoundsException {
				clientes[++ultimo]=cliente;
				cantidad++;
		}
		public void eliminar(int codCliente) throws clienteFantasma {
			int indice = buscar(codCliente);
			if(indice>=0) {
				if(indice!=ultimo) {
					for(int i=indice; i<=ultimo;i++) {
						clientes[i]=clientes[i+1];
					}
				}
				ultimo--;
				cantidad--;
			}
			
		}
		public int buscar(int codCliente) throws clienteFantasma {
			int posicion = -1;
			
			int indice=0;
			while(indice<=ultimo) {
				if(clientes[indice].getCodCliente()==codCliente) {
					posicion=indice;
					break;
				}
				indice++;
			}
			if (posicion==-1){
			throw new clienteFantasma();
			}
			return posicion;
		}
		
		
		public Cliente[] getClientes() {
			return clientes;
		}
		public int getCantidad() {
			return cantidad;
		}
		
		
	}