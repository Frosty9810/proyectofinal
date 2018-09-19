package menu.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.control.autos;
import com.automovil.view.AutoView;
import com.compra.control.compras;
import com.compra.view.CompraView;
import com.proveedor.control.ProveedorC;
import com.proveedor.view.ProveedorView;

import DetVenta.control.detVentas;
import DetVenta.view.detVentaView;
import cliente.control.clientes;
import cliente.view.clienteView;
import control.Conexión;
import empleado.control.empleados;
import empleado.view.empleadoView;
import excepcionesInputTypes.InputTypes;
import venta.control.ventas;
import venta.view.ventaView;


public class menuMenu {

	
	private static int encabezado (Scanner scanner) {
		int opcion;
		
		while (true) {
			System.out.println("Ingrese una opcion; ");
			System.out.println("------------------- ");
			System.out.println("1.  Clientes");
			System.out.println("2.  Automoviles");
			System.out.println("3.  Proveedores");
			System.out.println("4.  Compras");
			System.out.println("5.  Detalles de Ventas");
			System.out.println("6.  Empleados");
			System.out.println("7.  Ventas");
			
			System.out.println("0. Salir");
			System.out.println();
			
			opcion = InputTypes.readInt("¿Su opcion?", scanner);
			
			if(opcion >= 0 && opcion <=7) {
				return opcion;
			}
		}
	}
	public static void menu (Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		Conexión conexión = new Conexión("root","","agenciadeautos");
		clientes clientes = new clientes(10);
		  empleados empleados = new empleados(10);
		  ProveedorC proveedores = new ProveedorC(10);
		  ventas ventas = new ventas(10);
		  detVentas detVentas = new detVentas(10);
		  compras compras = new compras(10);
		  autos autos = new autos(10);
		  
		  
		  clienteView clienteView = new clienteView(clientes,conexión, scanner);
		  empleadoView empleadoView = new empleadoView(empleados,conexión, scanner);
		  ProveedorView proveedorView = new ProveedorView(scanner, conexión,proveedores );
		  ventaView ventaView = new ventaView(ventas, clientes,conexión, scanner);
		  detVentaView detVentaView = new detVentaView(detVentas, empleados, ventas, autos,conexión, scanner);
		  CompraView compraView = new CompraView(compras,conexión, scanner);
		  AutoView autoView = new AutoView(autos,compras,conexión, scanner);
		  
		
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				
				try {
					cliente.view.clienteMenu.menu(scanner, clienteView);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
			
				break;
			case 2:
				com.automovil.view.AutoMenu.menu(scanner, autoView);
				break;
			case 3:
				com.proveedor.view.proveedorMenu.menu(scanner, proveedorView);
				break;
			case 4:
				com.compra.view.compraMenu.menu(scanner, compraView);
				break;
			case 5:
				DetVenta.view.detVentaMenu.menu(scanner, detVentaView);
				break;
			case 6:
				empleado.view.empleadoMenu.menu(scanner, empleadoView);
				break;
			case 7:
				venta.view.ventaMenu.menu(scanner, ventaView);
				break;
			}
		}
		conexión.close();
		
	}
	
}
