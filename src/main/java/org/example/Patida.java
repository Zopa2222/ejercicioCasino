package org.example;

import java.util.ArrayList;

public class Patida {

	public static void generarPartida() {
		Mazo mazo = new Mazo();
		mostrarMazo(mazo);
	}

	public static void mostrarResultado() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
	}
	public static void mostrarMazo(ArrayList<Carta> mazo ) {
		for (Carta carta : mazo) {
			System.out.println(carta.toString());
		}
	}
}