/**
 * 
 */
package com.quieroviajar.model;

import java.util.ArrayList;
import java.util.Date;

import com.quieroviajar.impl.IVisualizable;
import com.quieroviajar.impl.Transporte;

/**
 * @author stick
 *
 */
public class Avion extends Transporte implements IVisualizable {

	private int id;
	private int travelTime;
	
	public Avion(String marca, String placa, String origen, String destino, int numeroPasajeros, double precio) {
		super(marca, placa, origen, destino, numeroPasajeros, precio);
	}
	
	public Avion() {}
	
	@Override
	public String toString() {
		return "\n :: AVI�N ::" + "\n Marca: " + getMarca() + "\n Placa: " + getPlaca() + "\n Origen: " + getOrigen()
				+ "\n Destino: " + getDestino() + "\n N� de Pasajeros: " + getNumeroPasajeros() + "\n Precio: "
				+ getPrecio();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int travelTime) {
		this.travelTime = travelTime;
	}

	@Override
	public Date iniciarViaje(Date dateoI) {
		// TODO Auto-generated method stub
		return dateoI;
	}

	@Override
	public void terminarViaje(Date dateI, Date dateF) {
		if (dateF.getTime() > dateI.getTime()) {
			setTravelTime((int) (dateF.getTime() - dateI.getTime()));
		} else {
			setTravelTime(0);
		}
	}

	@Override
	public void Used() {
		setUsed(true);
		Date dateI = iniciarViaje(new Date());

		for (int i = 0; i < 1000; i++) {
			System.out.println("....................");
		}

		/* Terminar viaje */
		terminarViaje(dateI, new Date());
		System.out.println();
		System.out.println("Termino el viaje en Avi�n : " + toString());
		System.out.println("Por :" + getTravelTime() + " horas");
		
	}
	
	public static ArrayList<Avion> hacerListaAviones() {
		ArrayList<Avion> aviones = new ArrayList<>();
		for (int i = 1; i < 6; i++) {
			aviones.add(new Avion("Marca "+i, "Placa "+i, "Origen "+i, "Destino "+i, 10*1, 1000*i));
		}
		return aviones;
	}
	
}
