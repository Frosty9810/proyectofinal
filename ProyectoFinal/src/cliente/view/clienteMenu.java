package cliente.view;

import java.util.Scanner;

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
					System.out.println("0. Salir");
					System.out.println();
					
					opcion = InputTypes.readInt("¿Su opcion?", scanner);
					
					if(opcion >= 0 && opcion <=3) {
						return opcion;
					}
				}
			}
			public static void menu (Scanner scanner, clienteView clienteView) {
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
						} catch (clienteFantasma e) {
							System.out.println("No existe cliente");
						}
						break;
					}
				}
				
				
			}

}
