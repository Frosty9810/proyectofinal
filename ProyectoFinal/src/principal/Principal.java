package principal;

 
import java.util.Scanner;

import com.automovil.control.autos;

import DetVenta.control.detVentas;
import DetVenta.view.detVentaView;
import cliente.control.clientes;
import cliente.view.clienteView;
import empleado.control.empleados;
import empleado.view.empleadoView;
import menu.view.automovilView;
import menu.view.compraView;
import menu.view.proveedorView;
import venta.control.ventas;
import venta.view.ventaView;



public class Principal {
  public static void main(String[] args){

	  Scanner scanner = new Scanner(System.in);
	  clientes clientes = new clientes(10);
	  empleados empleados = new empleados(10);
	  proveedores proveedores = new proveedores(10);
	  ventas ventas = new ventas(10);
	  detVentas detVentas = new detVentas(10);
	  compras compras = new compras(10);
	  autos autos = new autos(10);
	  
	  clienteView clienteView = new clienteView(clientes, scanner);
	  empleadoView empleadoView = new empleadoView(empleados, scanner);
	  proveedorView proveedorView = new proveedorView(proveedor, scanner);
	  ventaView ventaView = new ventaView(ventas, clientes, scanner);
	  detVentaView detVentaView = new detVentaView(detVentas, empleados, ventas, autos, scanner);
	  compraView compraView = new compraView(compras, scanner);
	  autoView autoView = new autoView(autos, scanner);
	  
	  
	  menu.view.menuMenu.menu(scanner, clienteView, autoView,proveedorView, compraView, detVentaView, empleadoView, ventaView);
	  scanner.close();
	  
	  
	  
  }
}
