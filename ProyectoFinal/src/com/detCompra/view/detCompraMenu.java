package com.detCompra.view;

import java.util.Scanner;

import DetVenta.view.autoFantasma;
import DetVenta.view.detVentaView;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.detVentaFantasma;
import excepcionesInputTypes.empleadoFantasma;
import excepcionesInputTypes.ventaFantasma;

public class detCompraMenu {
	private static int encabezado (Scanner scanner) {
		int opcion;
		
		while (true) {
			System.out.println("Ingrese una opcion; ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar detalle de compra");
			System.out.println("2. Listar detalle de compra");
			System.out.println("3. Eliminar detalle de compra");
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
					System.out.println("No existe el cliente");
				} catch (autoFantasma e2){
					System.out.println("No existe el automovil");
				} catch (ventaFantasma e3){
					System.out.println("No existe la venta");
				}
				break;
			case 2:
				detVentaView.listDetVenta();
				break;
			case 3:
				try {
					detVentaView.deleteDetVenta();
				} catch (detVentaFantasma e) {
					System.out.println("No existe detalle de venta");
				}
				break;
			}
		}
		
		
	}

}
