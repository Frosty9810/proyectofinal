package DetVenta.view;
 import java.util.Scanner;

import com.automovil.control.autos;

import DetVenta.entity.detVenta;
import empleado.control.empleados;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.empleadoFantasma;
import excepcionesInputTypes.ventaFantasma;
import venta.control.ventas;
public class detVentaRegistro {
		public static detVenta ingresar(Scanner scanner, empleados empleados, ventas ventas, autos autos)throws empleadoFantasma, autoFantasma, ventaFantasma {
			
			int codigoDetVenta= InputTypes.readInt("Codigo Detalle Venta: ", scanner);
			int fechaVentaDia = InputTypes.readInt("fecha Venta Dia: ", scanner);
			int fechaVentaMes = InputTypes.readInt("fecha Venta Mes: ", scanner);
			int fechaVentaAño = InputTypes.readInt("fecha Venta Año: ", scanner);
			int codigoEmpleado = InputTypes.readInt("Codigo Empleado", scanner);
			empleados.buscar(codigoEmpleado);
			
			
			int codigoAutomovil = InputTypes.readInt("Codigo Automovil", scanner);
			autos.buscar(codigoAutomovil);
			
			
			int codigoVenta = InputTypes.readInt("Codigo Venta", scanner);
			ventas.buscar(codigoVenta);
			
			
			return new detVenta(codigoDetVenta,fechaVentaAño,fechaVentaMes,fechaVentaDia,codigoEmpleado,codigoAutomovil, codigoVenta);
			
		}
	}
