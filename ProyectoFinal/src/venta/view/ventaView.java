package venta.view;
import java.util.Scanner;

import cliente.control.clientes;
import venta.control.ventas;
import venta.entity.venta;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;
import excepcionesInputTypes.ventaFantasma;
public class ventaView {
		private ventas ventas;
		private Scanner scanner;
		private clientes clientes;
		public ventaView(ventas ventas, clientes clientes ,Scanner scanner) {
			
			this.ventas = ventas;
			
			this.scanner = scanner;
		}
		
		public void addVenta() throws clienteFantasma {
			venta venta;
			
			venta = ventaRegistro.ingresar(scanner,clientes);
			ventas.ingresar(venta);
					
		}
		
		public void listVenta() {
			for(int i=0; i<ventas.getCantidad(); i++) {
				System.out.println(ventas.getVentas()[i]);
			}
		}
		
		public void deleteVenta() throws ventaFantasma {
			int codVenta = InputTypes.readInt("Ingrese el codigo de la venta", scanner);
			ventas.eliminar(codVenta);	
		}

		public ventas getVenta() {
			return ventas;
		}
	}