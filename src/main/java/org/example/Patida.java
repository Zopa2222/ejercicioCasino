package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Patida {

	public static Usuario registro(){
		System.out.println("Bienvenid@ al casino Deluxe, ingrese su nombre: ");
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();
		Usuario jugador = new Usuario(nombre);
		return jugador;
	}
	public static int ingresarSoloNumero() {
		Scanner in = new Scanner(System.in);
		while (!in.hasNextInt()) {
			System.out.println("Entrada no válida. Ingrese un número entero:");
			in.next();
		}
		int numero = in.nextInt();
		return numero;
	}
	public static boolean validarRangoNumero(int numero, int min, int max) {
		if (numero < min || numero > max) {
			return false;
		}
		return true;
	}

	public static void previoCarrera(Usuario jugador){
		String nombre = jugador.getNombre();
		JugadorBullseye jugadorBullseye = new JugadorBullseye(nombre);
		opcionesApuesta();
		int opcion = ingresarSoloNumero();
		while (!validarRangoNumero(opcion,1,6)){
			System.out.println("Ingrese un valor dentro de las opciones: ");
			opcion = ingresarSoloNumero();
		}
		jugadorBullseye.setApuesta(apuesta(opcion));
		ArrayList<Caballo> listaCaballos = inicializarCaballos();
		opcionesCaballos(listaCaballos);
		System.out.println("Ingrese el número del caballo a apostar: ");
		int numCaballo = ingresarSoloNumero();
		while (!validarRangoNumero(opcion,1,6)){
			System.out.println("Ingrese un valor dentro de las opciones: ");
			numCaballo = ingresarSoloNumero();
		}
		Caballo caballoApuesta = listaCaballos.get(numCaballo-1);
		listaCaballos.remove(caballoApuesta);
		Collections.shuffle(listaCaballos);
		JugadorBullseye jugador2 = new JugadorBullseye("Segundo", listaCaballos.get(0));
		JugadorBullseye jugador3 = new JugadorBullseye("Tercero", listaCaballos.get(1));
		JugadorBullseye jugador4 = new JugadorBullseye("Cuarto", listaCaballos.get(2));
		JugadorBullseye jugador5 = new JugadorBullseye("Quinto", listaCaballos.get(3));
		JugadorBullseye jugador6 = new JugadorBullseye("Sexto", listaCaballos.get(4));
		listaCaballos.add(caballoApuesta);
		Caballo caballoGanador = carrera(listaCaballos);
		
	}

	private static Caballo carrera(ArrayList<Caballo> listaCaballos){
		for (int i=0; i<6; i++){
			listaCaballos.get(i).setTiempo((int)(Math.random()*100+1));
		}
		Caballo caballoGanador=listaCaballos.get(0);
		for (int i=1; i<6; i++){
			if(caballoGanador.getTiempo()>listaCaballos.get(i).getTiempo()){
				caballoGanador = listaCaballos.get(i);
			}
		}
		return caballoGanador;
	}

	private static ArrayList<Caballo> inicializarCaballos(){
		Caballo caballo1 = new Caballo("Pollo","Amarillo",1);
		Caballo caballo2 = new Caballo("Gato","Blanco",2);
		Caballo caballo3 = new Caballo("Perro", "Rosa", 3);
		Caballo caballo4 = new Caballo("Pato", "Naranjo", 4);
		Caballo caballo5 = new Caballo("Conejo", "Verde", 5);
		Caballo caballo6 = new Caballo("Tigre","Rojo", 6);
		ArrayList<Caballo> listaCaballos = new ArrayList<Caballo>();
		listaCaballos.add(caballo1);
		listaCaballos.add(caballo2);
		listaCaballos.add(caballo3);
		listaCaballos.add(caballo4);
		listaCaballos.add(caballo5);
		listaCaballos.add(caballo6);
		return listaCaballos;
	}

	private static void opcionesCaballos(ArrayList<Caballo> listaCaballos){
		System.out.println("Los caballos son: ");
		System.out.println(listaCaballos.get(0).toString());
		System.out.println(listaCaballos.get(1).toString());
		System.out.println(listaCaballos.get(2).toString());
		System.out.println(listaCaballos.get(3).toString());
		System.out.println(listaCaballos.get(4).toString());
		System.out.println(listaCaballos.get(5).toString());
	}

	private static int ganancia(int apuesta){
		switch (apuesta){
			case 500:
				return 500*2;
			case 1000:
				return 1000*3;
			case 5000:
				return 5000*4;
			case 10000:
				return 10000*5;
			case 25000:
				return 25000*7;
			case 50000:
				return 50000*10;
		}
		return 0;
	}

	private static int apuesta(int opcion){
		switch (opcion){
			case 1:
				return 500;
			case 2:
				return 1000;
			case 3:
				return 5000;
			case 4:
				return 10000;
			case 5:
				return 25000;
			case 6:
				return 50000;
		}
		return 0;
	}

	private static void opcionesApuesta(){
		System.out.println("¿Cuánto desea aportar?");
		System.out.println("1. 500");
		System.out.println("2. 1.000");
		System.out.println("3. 5.000");
		System.out.println("4. 10.000");
		System.out.println("5. 25.000");
		System.out.println("6. 50.000");
	}

//-------------------------------------------------------------------------------
	private static JugadorBlackJack[] inicializarPartida(String name) {
		Mazo mazo = new Mazo();
		JugadorBlackJack jugador1 = new JugadorBlackJack(name);
		JugadorBlackJack jugador2 = new JugadorBlackJack("Casa");
		JugadorBlackJack[] listaJugadores = new JugadorBlackJack[2];
		listaJugadores[0] = jugador1;
		listaJugadores[1] = jugador2;
		asignarCartas(mazo,jugador1);
		asignarCartas(mazo,jugador2);
		return listaJugadores;
	}

	private static void asignarCartas(Mazo mazo, JugadorBlackJack jugador){
		for (int i=0; i<=3; i++){
			Carta cartaRandom = mazo.getMazo().get(0);
			jugador.agregarCarta(cartaRandom);
			mazo.descartarCartaMazo(cartaRandom);
		}
	}

	public static void partida(){
		JugadorBlackJack[] listaJugadores = inicializarPartida("Ingresa el name aaaaaa");
		JugadorBlackJack jugador1 = listaJugadores[0];
		JugadorBlackJack jugador2 = listaJugadores[1];
		detPuntajes(jugador1,jugador2);
		finalizarPartida(jugador1,jugador2);
	}

	private static void detPuntajes(JugadorBlackJack jugador1, JugadorBlackJack jugador2){
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
	}

	private static void finalizarPartida(JugadorBlackJack jugador1, JugadorBlackJack jugador2){
		mostrarResultado(determinarGanador(jugador1.getPuntaje(), jugador2.getPuntaje()),jugador1,jugador2);
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

	private static void mostrarResultado(int resultado, JugadorBlackJack jugador1, JugadorBlackJack jugador2) {
		switch (resultado) {
			case -1:
				System.out.println("Empate");
				break;
			case 0:
				System.out.println("No hay ganador");
				break;
			case 1:
				System.out.println("Gana: " + jugador1.getNombre());
				break;
			case 2:
				System.out.println("Gana: " + jugador2.getNombre());
				break;
		}
	}
}