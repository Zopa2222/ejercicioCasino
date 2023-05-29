package org.example;

import java.util.ArrayList;

public class Patida {

	public static void generarPartida() {
		Mazo mazo = new Mazo();
		ArrayList<Carta> mazoCompleto = mazo.getMazo();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		ArrayList<Carta> mazoAtualizado = asignarCartas(mazoCompleto,jugador1);
		mazo.setCartas(mazoAtualizado);
		mazoAtualizado=asignarCartas(mazoCompleto,jugador1);
		mazo.setCartas(mazoAtualizado);
	}

	public static ArrayList<Carta> asignarCartas(ArrayList<Carta> mazoCompleto, Jugador jugador){
		ArrayList<Carta> mano = new ArrayList<Carta>();
		for (int i=0; i<=3; i++){
			int posicionCartaRandom = ((int) (Math.random() * mazoCompleto.size()) + 1);
			Carta cartaRandom = mazoCompleto.get(posicionCartaRandom);
			mano.add(cartaRandom);
			mazoCompleto.remove(cartaRandom);
		}
		jugador.setMano(mano);
		return mazoCompleto;
	}

	public static void juego(Jugador jugador1, Jugador jugador2){
		
	}

	public static void mostrarResultado() {

	}
}