package org.example;

import java.util.ArrayList;

public class Patida {

	public static void inicializarPartida() {
		Mazo mazo = new Mazo();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		asignarCartas(mazo,jugador1);
		asignarCartas(mazo,jugador2);
		detPuntajes(jugador1,jugador2);
	}

	private static void asignarCartas(Mazo mazo, Jugador jugador){
		for (int i=0; i<=3; i++){
			Carta cartaRandom = mazo.getMazo().get(0);
			jugador.agregarCarta(cartaRandom);
			mazo.descartarCartaMazo(cartaRandom);
		}
	}

	private static void detPuntajes(Jugador jugador1, Jugador jugador2){
		int sumaMano1=0;
		int sumaMano2=0;
		for (int i=0; i<3; i++){
			sumaMano1 += jugador1.getMano().get(i).getValor();
		}
		jugador1.setPuntaje(sumaMano1);
		for (int i=0; i<3; i++){
			sumaMano2 += jugador2.getMano().get(i).getValor();
		}
		jugador2.setPuntaje(sumaMano2);
		System.out.println("Puntos del judador1 = " + jugador1.getPuntaje());
		System.out.println("Puntos del judador2 = " + jugador2.getPuntaje());
		mostrarResultado(determinarGanador(jugador1.getPuntaje(), jugador2.getPuntaje()));
	}

	private static int determinarGanador(int mano1, int mano2) {
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

	private static void mostrarResultado(int resultado) {
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