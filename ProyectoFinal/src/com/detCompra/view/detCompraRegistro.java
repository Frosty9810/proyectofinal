package com.detCompra.view;

import DetVenta.entity.detVenta;
import excepcionesInputTypes.InputTypes;

public class detCompraRegistro {
	int codigoDetVenta= InputTypes.readInt("Codigo Detalle Venta: ", scanner);
	int fechaVentaDia = InputTypes.readInt("fecha Venta Dia: ", scanner);
	int fechaVentaMes = InputTypes.readInt("fecha Venta Mes: ", scanner);
	int fechaVentaA�o = InputTypes.readInt("fecha Venta A�o: ", scanner);
	int codigoEmpleado = InputTypes.readInt("Codigo Empleado", scanner);
	empleados.buscar(codigoEmpleado);
	
	
	int codigoAutomovil = InputTypes.readInt("Codigo Automovil", scanner);
	autos.buscar(codigoAutomovil);
	
	
	int codigoVenta = InputTypes.readInt("Codigo Venta", scanner);
	ventas.buscar(codigoVenta);
	
	
	return new detVenta(codigoDetVenta,fechaVentaA�o,fechaVentaMes,fechaVentaDia,codigoEmpleado,codigoAutomovil, codigoVenta);
	
}

}
