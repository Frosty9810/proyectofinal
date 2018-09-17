package empleado.view;

import java.util.Scanner;

import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.empleadoFantasma;

public class empleadoMenu {
			private static int encabezado (Scanner scanner) {
				int opcion;
				
				while (true) {
					System.out.println("Ingrese una opcion; ");
					System.out.println("------------------- ");
					System.out.println("1. Ingresar empleado");
					System.out.println("2. Listar empleado");
					System.out.println("3. Eliminar empleado");
					System.out.println("0. Salir");
					System.out.println();
					
					opcion = InputTypes.readInt("¿Su opcion?", scanner);
					
					if(opcion >= 0 && opcion <=3) {
						return opcion;
					}
				}
			}
			public static void menu (Scanner scanner, empleadoView empleadoView) {
				boolean salir = false;
				while(!salir) {
					switch(encabezado(scanner)) {
					case 0:
						salir = true;
						break;
					case 1:
						empleadoView.addEmpleado();
						break;
					case 2:
						empleadoView.listEmpleado();
						break;
					case 3:
						try {
							empleadoView.deleteEmpleado();
						} catch (empleadoFantasma e) {
							System.out.println("No existe empleado");
						}
						break;
					}
				}
				
				
			}

}
