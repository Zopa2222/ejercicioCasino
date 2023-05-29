package org.example;

import java.util.ArrayList;

public class Mazo {

	private ArrayList<Carta> cartas;

	public ArrayList<Carta> getMazo() {
		return this.cartas;
	}

	public Mazo() {
		cartas = new ArrayList<Carta>();
		llenarMazo("Corazón");
		llenarMazo("Trébol");
		llenarMazo("Diamante");
		llenarMazo("Pica");
	}

	public void llenarMazo(String pinta) {
		Carta carta1 = new Carta(pinta, 'a', 11);
		this.cartas.add(carta1);
		for (int i = 2; i <= 10; i++) {
			char numchar = (char) i;
			Carta carta = new Carta(pinta, numchar, i);
			this.cartas.add(carta);
		}
		Carta carta11 = new Carta(pinta, 'j', 10);
		this.cartas.add(carta11);
		Carta carta12 = new Carta(pinta, 'q', 10);
		this.cartas.add(carta12);
		Carta carta13 = new Carta(pinta, 'k', 10);
		this.cartas.add(carta13);
	}

	public static void descartarCarta(int posicion) {
		this.mazo.remove(posicion);
	}
}