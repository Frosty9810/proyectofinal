package principal;

 
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
import control.Conexi�n;
import empleado.control.empleados;
import empleado.view.empleadoView;
import venta.control.ventas;
import venta.view.ventaView;



public class Principal {
  public static void main(String[] args) throws ClassNotFoundException, SQLException{

	  Scanner scanner = new Scanner(System.in);
	  clientes clientes = new clientes(10);
	  empleados empleados = new empleados(10);
	  ProveedorC proveedores = new ProveedorC(10);
	  ventas ventas = new ventas(10);
	  detVentas detVentas = new detVentas(10);
	  compras compras = new compras(10);
	  autos autos = new autos(10);
	  Conexi�n conexi�n = new Conexi�n("root","","Tienda");
		
	  
	  clienteView clienteView = new clienteView(clientes,conexi�n, scanner);
	  empleadoView empleadoView = new empleadoView(empleados,conexi�n, scanner);
	  ProveedorView proveedorView = new ProveedorView(scanner, conexi�n,proveedores );
	  ventaView ventaView = new ventaView(ventas, clientes,conexi�n, scanner);
	  detVentaView detVentaView = new detVentaView(detVentas, empleados, ventas, autos,conexi�n, scanner);
	  CompraView compraView = new CompraView(compras,conexi�n, scanner);
	  AutoView autoView = new AutoView(autos,compras,conexi�n, scanner);
	  
	  
	  menu.view.menuMenu.menu(scanner, clienteView, autoView,proveedorView, compraView, detVentaView, empleadoView, ventaView);
	  scanner.close();
	  conexi�n.close();
	  
	  
	  
  }
}
