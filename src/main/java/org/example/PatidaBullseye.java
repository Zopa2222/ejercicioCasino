package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class PatidaBullseye {

	public static JugadorBullseye ingresoUsuario(Usuario jugador, ArrayList<Caballo> listaCaballos) {
		String nombre = jugador.getNombre();
		JugadorBullseye jugadorBullseye = new JugadorBullseye(nombre);

		opcionesApuesta();
		int opcion = Tools.ingresarSoloNumero();
		/*while (!Tools.validarRangoNumero(opcion, 1, 6)) {
			System.out.println("Ingrese un valor dentro de las opciones: ");
			opcion = Tools.ingresarSoloNumero();
		} */
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

	public static String partida(JugadorBullseye jugador, ArrayList<Caballo> listaCaballos){
		//ArrayList<JugadorBlackJack.Caballo> listaCaballos = inicializarCaballos();
		//JugadorBullseye jugador = ingresoUsuario(usuario, listaCaballos);

		listaCaballos.remove(jugador.getCaballo());
		Collections.shuffle(listaCaballos);
		JugadorBullseye jugador2 = new JugadorBullseye("Segundo", listaCaballos.get(0));
		JugadorBullseye jugador3 = new JugadorBullseye("Tercero", listaCaballos.get(1));
		JugadorBullseye jugador4 = new JugadorBullseye("Cuarto", listaCaballos.get(2));
		JugadorBullseye jugador5 = new JugadorBullseye("Quinto", listaCaballos.get(3));
		JugadorBullseye jugador6 = new JugadorBullseye("Sexto", listaCaballos.get(4));
		listaCaballos.add(jugador.getCaballo());

		Caballo caballoGanador = carrera(listaCaballos);
		return resultado(jugador,caballoGanador);
	}

	public static Caballo carrera(ArrayList<Caballo> listaCaballos){
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

	public static String resultado(JugadorBullseye jugador, Caballo caballoGanador){
		if (jugador.getCaballo()==caballoGanador){
			jugador.setApuesta(ganancia(jugador.getApuesta()));
			return ("Felicidades, ganaste! "+"Tu ganancia total es de: " + jugador.getApuesta());
			//System.out.println("Tu ganancia total es de: " + ganancia(jugador.getApuesta()));
		} else {
			//System.out.println("Perdiste :(");
			jugador.setApuesta(0);
			return "Has perdido";
		}
	}

	public static ArrayList<Caballo> inicializarCaballos(){
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

	public static void opcionesCaballos(ArrayList<Caballo> listaCaballos){
		System.out.println("Los caballos son: ");
		System.out.println(listaCaballos.get(0).toString());
		System.out.println(listaCaballos.get(1).toString());
		System.out.println(listaCaballos.get(2).toString());
		System.out.println(listaCaballos.get(3).toString());
		System.out.println(listaCaballos.get(4).toString());
		System.out.println(listaCaballos.get(5).toString());
	}

	public static int ganancia(int apuesta){
		switch (apuesta){
			case 0:
				return 500*2;
			case 1:
				return 1000*3;
			case 2:
				return 5000*4;
			case 3:
				return 10000*5;
			case 4:
				return 25000*7;
			case 5:
				return 50000*10;
		}
		return 2;
	}

	public static int apuesta(int opcion){
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