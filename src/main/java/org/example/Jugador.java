package org.example;

import java.util.ArrayList;

public class Jugador {

	private ArrayList<Carta> mano;
	private int puntaje;

	public Jugador() {
		this.mano = new ArrayList<Carta>();
		this.puntaje = 0;
	}
	public ArrayList<Carta> getMano() {
		return this.mano;
	}

	public int getPuntaje(){
		return this.puntaje;
	}

	public void setPuntaje(int puntaje){this.puntaje=puntaje;}

	public void agregarCarta(Carta carta) {
		mano.add(carta);
	}
}