package gui;

import org.example.Caballo;
import org.example.JugadorBullseye;
import org.example.PatidaBullseye;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaBullseye extends JFrame implements ActionListener  {
    private JugadorBullseye jugador;
    private JLabel textoApuesta;
    private JLabel textoCaballos;
    private JLabel resultado;
    private JComboBox apuestas;
    private JComboBox caballos;
    private JButton jugar;
    private JButton volver;

    public VentanaBullseye(){
        initVentanaBE();
        this.setTitle("Casino");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initVentanaBE(){
        JPanel panel = new JPanel();
        JLabel textoApuesta = new JLabel();
        JLabel textoCaballos = new JLabel();
        JLabel resultado = new JLabel();
        JButton volver = new JButton();
        JButton jugar = new JButton();
        JugadorBullseye jugador = new JugadorBullseye("jugador");

        Integer[] opciones = {500, 1000, 5000, 10000, 25000, 50000};
        JComboBox apuestas = new JComboBox<Integer>(opciones);

        ArrayList caballos = PatidaBullseye.inicializarCaballos();
        String[] datosCaballos = verCaballos(caballos);
        JComboBox caballoss = new JComboBox<>(datosCaballos);

        textoApuesta.setText("Defina el monto a apostar");
        textoCaballos.setText("Ingrese su caballo");
        volver.setText("Volver atrás");
        jugar.setText("Jugar");

        panel.add(textoApuesta);
        panel.add(apuestas);

        panel.add(textoCaballos);
        panel.add(caballoss);

        panel.add(resultado);

        panel.add(jugar);
        panel.add(volver);

        caballoss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceCaballo = caballoss.getSelectedIndex();
                jugador.setCaballo((Caballo) caballos.get(indiceCaballo));
            }
        });

        apuestas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcionSeleccionada = (int) apuestas.getSelectedIndex();
                jugador.setApuesta(opcionSeleccionada);
            }
        });

        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText(PatidaBullseye.partida(jugador, caballos));
            }
        });

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarBE();
                Controlador.abrirPrincipal();
            }
        });

        this.add(panel);
    }

    public static String[] verCaballos(ArrayList<Caballo> caballos){
        String[] datosCaballos= new String[6];
        for (int i = 0; i<6; i++){
            datosCaballos[i] = (caballos.get(i).toString());
        }
        return datosCaballos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
