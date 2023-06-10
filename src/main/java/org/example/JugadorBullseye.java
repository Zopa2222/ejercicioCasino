package org.example;

public class JugadorBullseye extends Usuario{

    private int apuesta = 50000;
    private Caballo caballo;

    public JugadorBullseye(String name) {
        super(name);
    }

    public JugadorBullseye (String name, Caballo caballo){
        super(name);
        this.caballo = caballo;
    }

    public Caballo getCaballo() {
        return caballo;
    }

    public void setCaballo(Caballo caballo) {
        this.caballo = caballo;
    }

    public void setApuesta(int apostar) {
        this.apuesta = apostar;
    }

    public int getApuesta() {
        return apuesta;
    }
}
