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
import control.Conexión;
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
	  Conexión conexión = new Conexión("root","","Tienda");
		
	  
	  clienteView clienteView = new clienteView(clientes,conexión, scanner);
	  empleadoView empleadoView = new empleadoView(empleados,conexión, scanner);
	  ProveedorView proveedorView = new ProveedorView(scanner, conexión,proveedores );
	  ventaView ventaView = new ventaView(ventas, clientes,conexión, scanner);
	  detVentaView detVentaView = new detVentaView(detVentas, empleados, ventas, autos,conexión, scanner);
	  CompraView compraView = new CompraView(compras,conexión, scanner);
	  AutoView autoView = new AutoView(autos,compras,conexión, scanner);
	  
	  
	  menu.view.menuMenu.menu(scanner, clienteView, autoView,proveedorView, compraView, detVentaView, empleadoView, ventaView);
	  scanner.close();
	  conexión.close();
	  
	  
	  
  }
}
