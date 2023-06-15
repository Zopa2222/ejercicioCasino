package org.example;

import java.util.ArrayList;

public class JugadorBlackJack extends Usuario {

    private ArrayList<Carta> mano;
    private int puntaje;

    public JugadorBlackJack(String name) {
        super(name);
        this.mano = new ArrayList<Carta>();
        this.puntaje = 0;
    }
    public ArrayList<Carta> getMano() {
        return this.mano;
    }

    public int getPuntaje(){
        return this.puntaje;
    }

    public void setPuntaje(int puntaje){this.puntaje=puntaje;}

    public void agregarCarta(Carta carta) {
        mano.add(carta);
    }

    public static class Caballo {
        private String nombre;
        private int  numero;
        private String color;
        private int tiempo;

        public Caballo(String name, String color, int num){
            this.nombre = name;
            this.color = color;
            this.numero = num;
            this.tiempo = 0;
        }

        public int getNumero() {
            return numero;
        }

        public String toString() {
            return "[" + numero + "] " + nombre + ", Color = " + color;
        }

        public void setTiempo(int time){
            this.tiempo = time;
        }

        public int getTiempo(){
            return this.tiempo;
        }
    }
}
