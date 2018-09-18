package DetVenta.view;

import java.sql.SQLException;
import java.util.Scanner;


import DetVenta.entity.detVenta;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.autoFantasma;
import excepcionesInputTypes.empleadoFantasma;
import excepcionesInputTypes.ventaFantasma;

public class detVentaMenu {
			private static int encabezado (Scanner scanner) {
				int opcion;
				
				while (true) {
					System.out.println("Ingrese una opcion; ");
					System.out.println("------------------- ");
					System.out.println("1. Ingresar detalle de venta");
					System.out.println("2. Listar detalle de venta");
					System.out.println("3. Eliminar detalle de venta");
					System.out.println("0. Salir");
					System.out.println();
					
					opcion = InputTypes.readInt("¿Su opcion?", scanner);
					
					if(opcion >= 0 && opcion <=3) {
						return opcion;
					}
				}
			}
			public static void menu (Scanner scanner, detVentaView detVentaView) {
				boolean salir = false;
				while(!salir) {
					switch(encabezado(scanner)) {
					case 0:
						salir = true;
						break;
					case 1:
						try {
							detVentaView.addDetVenta();
						
						} catch (empleadoFantasma e1) {
							System.out.println("No existe el empleado");
						} catch (autoFantasma e2){
							System.out.println("No existe el automovil");
						} catch (ventaFantasma e3){
							System.out.println("No existe la venta");
						}
						break;
					case 2:
						try {
							detVentaView.listDetVenta();
						} catch (SQLException e1) {
							System.out.println("No existe detalle de venta");
							}
						break;
					case 3:
						try {
							detVentaView.deletedetVenta();
						} catch (SQLException e) {
							System.out.println("No existe detalle de venta");
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
					System.out.println("1. Modificar fechaaño");
					System.out.println("2. Modificar fechames");
					System.out.println("3. Modificar fechadia");
					System.out.println("4. Modificar codigo automovil");
					System.out.println("5. Modificar codigo empleado");
					System.out.println("6. Modificar codigo venta");
					
					System.out.println("0. Salir");
					System.out.println();

					opcion = InputTypes.readInt("¿Su opción? ", scanner);

					if (opcion >= 0 && opcion <= 6) {
						return opcion;
					}
				}
			}


			public static void menúModificar(Scanner scanner, detVenta detVenta) {
					boolean salir = false;

				
				
				while (!salir) {
					switch (encabezadoModificar(scanner)) {
					case 0:
						salir = true;
						break;
					case 1:
						detVenta.setFechaVentaAño(InputTypes.readInt("fecha año", scanner));
						break;
					case 2:
						detVenta.setFechaVentaMes(InputTypes.readInt("fecha mes", scanner));
						break;
					
					case 3:
						detVenta.setFechaVentaDia(InputTypes.readInt("fecha dia", scanner));
						break;
					case 4:
						detVenta.setCodigoAutomovil(InputTypes.readInt("codigoAutomovil", scanner));
						break;      
					case 5:         
						detVenta.setCodigoEmpleado(InputTypes.readInt("codigoEmpleado", scanner));
						break;      
					case 6:         
						detVenta.setCodigoVenta(InputTypes.readInt("codioVenta", scanner));
						break;
					
					
					}
				}
			}
			


}
