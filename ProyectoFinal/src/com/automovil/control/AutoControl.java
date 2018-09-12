package com.automovil.control;

import com.automovil.entity.Auto;

public class AutoControl {
	private Auto[] auto;
	private int cantidad;
	private int ultimo;
	
	public void Auto (int tamaño) {
		auto = new Auto[tamaño];
		cantidad = 0;
		ultimo = -1;
	}
	public void ingresar(Auto autos) throws java.lang.ArrayIndexOutOfBoundsException {
			auto[++ultimo]=autos;
			cantidad++;
	}
	public void eliminar(int codigoAutomovil) {
		int indice = buscar(codigoAutomovil);
		if(indice>=0) {
			if(indice!=ultimo) {
				for(int i=indice; i<=ultimo;i++) {
					auto[i]=auto[i+1];
				}
			}
			ultimo--;
			cantidad--;
		}
		
	}
	private int buscar(int codigoAutomovil) {
		int posicion = -1;
		
		for(int indice=0; posicion<=auto.length;posicion++) {
			if(auto[indice].getCodigoAutomovil()==codigoAutomovil) {
				posicion=indice;
				break;
			}
		}
		return posicion;
	}
	public Auto[] getAutos() {
		return auto;
	}
	public int getCantidad() {
		return cantidad;
	}
}
