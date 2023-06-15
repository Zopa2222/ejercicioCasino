package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class PatidaBullseye {

	private static JugadorBullseye ingresoUsuario(Usuario jugador, ArrayList<JugadorBlackJack.Caballo> listaCaballos) {
		String nombre = jugador.getNombre();
		JugadorBullseye jugadorBullseye = new JugadorBullseye(nombre);

		opcionesApuesta();
		int opcion = Tools.ingresarSoloNumero();
		while (!Tools.validarRangoNumero(opcion, 1, 6)) {
			System.out.println("Ingrese un valor dentro de las opciones: ");
			opcion = Tools.ingresarSoloNumero();
		}
		jugadorBullseye.setApuesta(apuesta(opcion));

		opcionesCaballos(listaCaballos);
		System.out.println("Ingrese el número del caballo a apostar: ");
		int numCaballo = Tools.ingresarSoloNumero();
		while (!Tools.validarRangoNumero(numCaballo, 1, 6)) {
			System.out.println("Ingrese un valor dentro de las opciones: ");
			numCaballo = Tools.ingresarSoloNumero();
		}
		jugadorBullseye.setCaballo(listaCaballos.get(numCaballo - 1));

		return jugadorBullseye;
	}

	public static void partida(Usuario usuario){
		ArrayList<JugadorBlackJack.Caballo> listaCaballos = inicializarCaballos();
		JugadorBullseye jugador = ingresoUsuario(usuario, listaCaballos);

		listaCaballos.remove(jugador.getCaballo());
		Collections.shuffle(listaCaballos);
		JugadorBullseye jugador2 = new JugadorBullseye("Segundo", listaCaballos.get(0));
		JugadorBullseye jugador3 = new JugadorBullseye("Tercero", listaCaballos.get(1));
		JugadorBullseye jugador4 = new JugadorBullseye("Cuarto", listaCaballos.get(2));
		JugadorBullseye jugador5 = new JugadorBullseye("Quinto", listaCaballos.get(3));
		JugadorBullseye jugador6 = new JugadorBullseye("Sexto", listaCaballos.get(4));
		listaCaballos.add(jugador.getCaballo());

		JugadorBlackJack.Caballo caballoGanador = carrera(listaCaballos);
		resultado(jugador,caballoGanador);
	}

	private static JugadorBlackJack.Caballo carrera(ArrayList<JugadorBlackJack.Caballo> listaCaballos){
		for (int i=0; i<6; i++){
			listaCaballos.get(i).setTiempo((int)(Math.random()*100+1));
		}
		JugadorBlackJack.Caballo caballoGanador=listaCaballos.get(0);
		for (int i=1; i<6; i++){
			if(caballoGanador.getTiempo()>listaCaballos.get(i).getTiempo()){
				caballoGanador = listaCaballos.get(i);
			}
		}
		return caballoGanador;
	}

	private static void resultado(JugadorBullseye jugador, JugadorBlackJack.Caballo caballoGanador){
		if (jugador.getCaballo()==caballoGanador){
			System.out.println("Felicidades, ganaste!");
			System.out.println("Tu ganancia total es de: " + ganancia(jugador.getApuesta()));
		} else {
			System.out.println("Perdiste :(");
			jugador.setApuesta(0);
		}
	}

	private static ArrayList<JugadorBlackJack.Caballo> inicializarCaballos(){
		JugadorBlackJack.Caballo caballo1 = new JugadorBlackJack.Caballo("Pollo","Amarillo",1);
		JugadorBlackJack.Caballo caballo2 = new JugadorBlackJack.Caballo("Gato","Blanco",2);
		JugadorBlackJack.Caballo caballo3 = new JugadorBlackJack.Caballo("Perro", "Rosa", 3);
		JugadorBlackJack.Caballo caballo4 = new JugadorBlackJack.Caballo("Pato", "Naranjo", 4);
		JugadorBlackJack.Caballo caballo5 = new JugadorBlackJack.Caballo("Conejo", "Verde", 5);
		JugadorBlackJack.Caballo caballo6 = new JugadorBlackJack.Caballo("Tigre","Rojo", 6);
		ArrayList<JugadorBlackJack.Caballo> listaCaballos = new ArrayList<JugadorBlackJack.Caballo>();
		listaCaballos.add(caballo1);
		listaCaballos.add(caballo2);
		listaCaballos.add(caballo3);
		listaCaballos.add(caballo4);
		listaCaballos.add(caballo5);
		listaCaballos.add(caballo6);
		return listaCaballos;
	}

	private static void opcionesCaballos(ArrayList<JugadorBlackJack.Caballo> listaCaballos){
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
}