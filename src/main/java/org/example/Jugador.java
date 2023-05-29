package org.example;

import java.util.ArrayList;

public class Jugador {

	private ArrayList<Carta> mano;

	public ArrayList<Carta> getMano() {
		return this.mano;
	}

	public void setMano(ArrayList<Carta> cartas) {
		this.mano = cartas;
	}

	public void Jugador(){
		ArrayList<Carta> mano = new ArrayList<>();
		this.mano = mano;
	}
}