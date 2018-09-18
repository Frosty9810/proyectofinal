package com.automovil.control;

import com.automovil.entity.Auto;

import excepcionesInputTypes.autoFantasma;

public class Autos {
	private Auto[] autos;
	private int cantidad;
	private int ultimo;
	
	public Autos (int tamaño) {
		autos = new Auto[tamaño];
		cantidad = 0;
		ultimo = -1;
	}
	public void ingresar(Auto auto) throws java.lang.ArrayIndexOutOfBoundsException {
			autos[++ultimo]=auto;
			cantidad++;
	}
	public void eliminar(int codigoAutomovil) throws autoFantasma {
		int indice = buscar(codigoAutomovil);
		if(indice>=0) {
			if(indice!=ultimo) {
				for(int i=indice; i<=ultimo;i++) {
					autos[i]=autos[i+1];
				}
			}
			ultimo--;
			cantidad--;
		}
		
	}
	public int buscar(int codigoAutomovil) throws autoFantasma {
		int posicion = -1;
		
		for(int indice=0; posicion<=autos.length;posicion++) {
			if(autos[indice].getCodigoAutomovil()==codigoAutomovil) {
				posicion=indice;
				break;
			}indice++;
		}
		if (posicion==-1){
		throw new autoFantasma();
		}
		return posicion;
	}
	public Auto[] getAutos() {
		return autos;
	}
	public int getCantidad() {
		return cantidad;
	}
}
