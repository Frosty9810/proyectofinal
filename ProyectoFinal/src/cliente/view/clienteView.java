package cliente.view;
import java.util.Scanner;

import cliente.control.clientes;
import cliente.entity.Cliente;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;
public class clienteView {
		private clientes clientes;
		private Scanner scanner;
		
		public clienteView(clientes clientes,Scanner scanner) {
			
			this.clientes = clientes;
			
			this.scanner = scanner;
		}
		
		public void addCliente() {
			Cliente cliente;
			
			cliente = clienteRegistro.ingresar(scanner);
			clientes.ingresar(cliente);
					
		}
		
		public void listCliente() {
			for(int i=0; i<clientes.getCantidad(); i++) {
				System.out.println(clientes.getClientes()[i]);
			}
		}
		
		public void deleteCliente() throws clienteFantasma {
			int codCliente = InputTypes.readInt("Ingrese el codigo del cliente", scanner);
			clientes.eliminar(codCliente);	
		}

		public clientes getClientes() {
			return clientes;
		}
	}