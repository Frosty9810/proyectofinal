package venta.view;
 import java.util.Scanner;

import cliente.control.clientes;
import venta.entity.venta;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;
public class ventaRegistro {
		public static venta ingresar(Scanner scanner,clientes clientes) throws clienteFantasma {
			
			String reservacion= InputTypes.readString("reservacion: ", scanner);
			int codigoVenta= InputTypes.readInt("Codigo empleado: ", scanner);
			int numeroVenta = InputTypes.readInt("Numero Venta: ", scanner);
			int codigoCliente = InputTypes.readInt("Codigo Cliente", scanner);
			clientes.buscar(codigoCliente);
			
			return new venta(codigoVenta, numeroVenta,reservacion, codigoCliente);
			
		}
	}
