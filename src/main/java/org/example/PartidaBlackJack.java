package org.example;

public class PartidaBlackJack {

    public static void partida(Usuario jugador){
        JugadorBlackJack[] listaJugadores = inicializarPartida(jugador);
        detPuntajes(listaJugadores[0],listaJugadores[1]);
        finalizarPartida(listaJugadores[0],listaJugadores[1]);
    }

    private static JugadorBlackJack[] inicializarPartida(Usuario jugador) {
        Mazo mazo = new Mazo();
        String name = jugador.getNombre();
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
