package org.example;

public class JugadorBullseye extends Usuario{

    private int apuesta = 50000;
    private JugadorBlackJack.Caballo caballo;

    public JugadorBullseye(String name) {
        super(name);
    }

    public JugadorBullseye (String name, JugadorBlackJack.Caballo caballo){
        super(name);
        this.caballo = caballo;
    }

    public JugadorBlackJack.Caballo getCaballo() {
        return caballo;
    }

    public void setCaballo(JugadorBlackJack.Caballo caballo) {
        this.caballo = caballo;
    }

    public void setApuesta(int apostar) {
        this.apuesta = apostar;
    }

    public int getApuesta() {
        return apuesta;
    }
}
