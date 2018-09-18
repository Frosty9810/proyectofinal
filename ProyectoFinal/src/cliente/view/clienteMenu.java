package cliente.view;

import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;

public class clienteMenu {
			private static int encabezado (Scanner scanner) {
				int opcion;
				
				while (true) {
					System.out.println("Ingrese una opcion; ");
					System.out.println("------------------- ");
					System.out.println("1. Ingresar cliente");
					System.out.println("2. Listar cliente");
					System.out.println("3. Eliminar cliente");
					System.out.println("4. Actualizar cliente");
					
					System.out.println("0. Salir");
					System.out.println();
					
					opcion = InputTypes.readInt("¿Su opcion?", scanner);
					
					if(opcion >= 0 && opcion <=4) {
						return opcion;
					}
				}
			}
			public static void menu (Scanner scanner, clienteView clienteView) throws SQLException {
				boolean salir = false;
				while(!salir) {
					switch(encabezado(scanner)) {
					case 0:
						salir = true;
						break;
					case 1:
						clienteView.addCliente();
						break;
					case 2:
						clienteView.listCliente();
						break;
					case 3:
						try {
							clienteView.deleteCliente();
						} catch (SQLException e) {
							System.out.println("No existe cliente");
						}
						break;
					case 4:
						try {
							clienteView.update();
						} catch (clienteFantasma e) {
							System.out.println("No existe el cliente");
							}
						break;
					}
				}
				
				
			}
			
			private static int encabezadoModificar(Scanner scanner) {
				int opcion;


				
				while (true) {
					System.out.println("Ingrese una opcion: ");
					System.out.println("------------------- ");
					System.out.println("1. Modificar nombre");
					System.out.println("2. Modificar DNI ");
					System.out.println("3. Modificar direccion ");
					System.out.println("4. Modificar telefono ");
					System.out.println("0. Salir");
					System.out.println();

					opcion = InputTypes.readInt("¿Su opción? ", scanner);

					if (opcion >= 0 && opcion <= 4) {
						return opcion;
					}
				}
			}


			public static void menúModificar(Scanner scanner, Cliente cliente) {
				boolean salir = false;

				
				
				while (!salir) {
					switch (encabezadoModificar(scanner)) {
					case 0:
						salir = true;
						break;
					case 1:
						cliente.setNombreCliente(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
						break;
					case 2:
						cliente.setDNIcliente(InputTypes.readInt("Ingrese el nuevo DNI: ", scanner));
						break;
					case 3:
						cliente.setDireccion(InputTypes.readString("ingrese la nueva direccion: ", scanner));
						break;
					case 4:
						cliente.setTelefono(InputTypes.readInt("ingrese el nuevo telefono", scanner));
						break;
					}
				}
			}


}
