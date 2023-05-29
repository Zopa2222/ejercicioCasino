package org.example;

import java.util.ArrayList;
import java.util.Collections;


public class Patida {

	public static void generarPartida() {
		Mazo mazo = new Mazo();
		ArrayList<Carta> mazoCompleto = mazo.getMazo();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		ArrayList<Carta> mazoAtualizado = asignarCartas(mazoCompleto,jugador1);
		mazo.setCartas(mazoAtualizado);
		mazoAtualizado=asignarCartas(mazoCompleto,jugador2);
		mazo.setCartas(mazoAtualizado);
		juego(jugador1,jugador2);
	}

	public static ArrayList<Carta> asignarCartas(ArrayList<Carta> mazoCompleto, Jugador jugador){
		ArrayList<Carta> mano = new ArrayList<Carta>();
		for (int i=0; i<=3; i++){
			//int posicionCartaRandom = ((int) (Math.random() * mazoCompleto.size()) + 1);
			//Carta cartaRandom = mazoCompleto.get(posicionCartaRandom);
			Collections.shuffle(mazoCompleto);
			Carta cartaRandom = mazoCompleto.get(0);
			mano.add(cartaRandom);
			mazoCompleto.remove(cartaRandom);
		}
		jugador.setMano(mano);
		return mazoCompleto;
	}

	public static void juego(Jugador jugador1, Jugador jugador2){
		ArrayList<Carta> mano1 = jugador1.getMano();
		int sumaMano1=0;
		ArrayList<Carta> mano2 = jugador2.getMano();
		int sumaMano2=0;
		for (int i=0; i<3; i++){
			Carta carta = mano1.get(i);
			sumaMano1 += carta.getValor();
		}
		for (int i=0; i<3; i++){
			Carta carta = mano2.get(i);
			sumaMano2 += carta.getValor();
		}
		System.out.println("Puntos del judador1 = "+sumaMano1);
		System.out.println("Puntos del judador2 = "+sumaMano2);
		mostrarResultado(determinarGanador(sumaMano1,sumaMano2));
	}

	public static int determinarGanador(int mano1, int mano2) {
		if (mano1 > 21 && mano2 > 21) {
			return 0;
		} else if (mano1 < 21 && mano2 < 21) {
			if (mano1 > mano2) {
				return 1;
			} else if (mano2 > mano1) {
				return 2;
			} else {
				return -1;
			}
		} else if (mano1 == mano2) {
			return -1;
		} else if (mano1 <= 21) {
			return 1;
		} else {
			return 2;
		}
	}

	public static void mostrarResultado(int resultado) {
		switch (resultado) {
			case -1:
				System.out.println("Empate");
				break;
			case 0:
				System.out.println("No hay ganador");
				break;
			case 1:
				System.out.println("Gana el primer jugador");
				break;
			case 2:
				System.out.println("Gana el segundo jugador");
				break;
		}
	}
}