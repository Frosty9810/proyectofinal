package principal;

 
import java.util.Scanner;

import com.automovil.control.Autos;
import com.automovil.view.AutoView;
import com.compra.control.compras;
import com.compra.view.CompraView;
import com.proveedor.control.ProveedorC;
import com.proveedor.view.proveedorView;

import DetVenta.control.detVentas;
import DetVenta.view.detVentaView;
import cliente.control.clientes;
import cliente.view.clienteView;
import empleado.control.empleados;
import empleado.view.empleadoView;
import venta.control.ventas;
import venta.view.ventaView;



public class Principal {
  public static void main(String[] args){

	  Scanner scanner = new Scanner(System.in);
	  clientes clientes = new clientes(10);
	  empleados empleados = new empleados(10);
	  ProveedorC proveedores = new ProveedorC(10);
	  ventas ventas = new ventas(10);
	  detVentas detVentas = new detVentas(10);
	  compras compras = new compras(10);
	  Autos autos = new Autos(10);
	  
	  clienteView clienteView = new clienteView(clientes, scanner);
	  empleadoView empleadoView = new empleadoView(empleados, scanner);
	  proveedorView proveedorView = new proveedorView(scanner, proveedores );
	  ventaView ventaView = new ventaView(ventas, clientes, scanner);
	  detVentaView detVentaView = new detVentaView(detVentas, empleados, ventas, autos, scanner);
	  CompraView compraView = new CompraView(compras, scanner);
	  AutoView autoView = new AutoView(autos,compras, scanner);
	  
	  
	  menu.view.menuMenu.menu(scanner, clienteView, autoView,proveedorView, compraView, detVentaView, empleadoView, ventaView);
	  scanner.close();
	  
	  
	  
  }
}
