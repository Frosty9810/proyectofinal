package cliente.view;
 import java.util.Scanner;

import cliente.entity.Cliente;
import excepcionesInputTypes.InputTypes;
public class clienteRegistro {
		public static Cliente ingresar(Scanner scanner) {
			String nombreCliente= InputTypes.readString("Nombre: ", scanner);
			int codCliente = InputTypes.readInt("Codigo Cliente: ", scanner);
			String direccion =InputTypes.readString("Direccion: ", scanner);
			int DNIcliente = InputTypes.readInt("DNI Cliente: ", scanner);
			int telefono = InputTypes.readInt("Telefono Cliente: ", scanner);
			
			return new Cliente(codCliente,DNIcliente,nombreCliente,direccion,telefono);
			
		}
	}
