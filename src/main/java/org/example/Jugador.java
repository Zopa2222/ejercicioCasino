package org.example;

import java.util.ArrayList;

public class Jugador {

	private ArrayList<Carta> mano;

	public ArrayList<Carta> getMano() {
		return this.mano;
	}

	public void Jugador(){
		int posicionCarta = ((int) (Math.random() * 52) + 1);
		this.mano.add(Mazo.mazo.getMazo(posicionCarta));
		Mazo.descartarCarta(posicionCarta);
	}
	public void tomarCarta() {
		// TODO - implement Jugador.tomarCarta
		throw new UnsupportedOperationException();
	}

}