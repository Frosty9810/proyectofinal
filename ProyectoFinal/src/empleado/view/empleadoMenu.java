package empleado.view;

import java.sql.SQLException;
import java.util.Scanner;


import empleado.entity.empleado;
import excepcionesInputTypes.InputTypes;

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
						try {
							empleadoView.listEmpleado();
						} catch (SQLException e1) {
							System.out.println("No existe empleado");
							}
						break;
					case 3:
						try {
							empleadoView.deleteEmpleado();
						} catch (SQLException e) {
							System.out.println("No existe empleado");
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
					System.out.println("2. Modificar DNI");
					
					System.out.println("0. Salir");
					System.out.println();

					opcion = InputTypes.readInt("¿Su opción? ", scanner);

					if (opcion >= 0 && opcion <= 2) {
						return opcion;
					}
				}
			}


			public static void menúModificar(Scanner scanner, empleado empleado) {
					boolean salir = false;

				
				
				while (!salir) {
					switch (encabezadoModificar(scanner)) {
					case 0:
						salir = true;
						break;
					case 1:
						 empleado.setNombreEmpleado(InputTypes.readString("nombre empleado:", scanner));
						break;
					case 2:
						 empleado.setDNIEmpleado(InputTypes.readInt("DNI empleado:", scanner));
						break;
					}
				}
			}
			


}
