package org.example;

public class Caballo {
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

    @Override
    public String toString() {
        return "Caballo{" +
                "nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public void setTiempo(int time){
        this.tiempo = time;
    }

    public int getTiempo(){
        return this.tiempo;
    }
}