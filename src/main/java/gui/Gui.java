package gui;

import org.example.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Gui extends JFrame implements ActionListener {

    private JFrame ventanaPrincipal;
    private JFrame ventanaBJ;
    private JFrame ventanaBE;

    public Gui() {
        initVentanaPrincipal();
        ventanaPrincipal.setSize(600, 400);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initVentanaPrincipal() {
        ventanaPrincipal = new JFrame();
        JPanel panel = new JPanel();

        JLabel texto = new JLabel();
        texto.setText("Bienvenido, elija un juego");

        JButton BJbutton = new JButton();
        BJbutton.setText("BlackJack");

        JButton BEbutton = new JButton();
        BEbutton.setText("Bullseye");

        panel.add(texto);
        panel.add(BJbutton);
        panel.add(BEbutton);
        ventanaPrincipal.add(panel);

        BJbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.setVisible(false);
                initVentanaBJ();
            }
        });

        BEbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.setVisible(false);
                initVentanaBE();
            }
        });
    }

    public void initVentanaBE(){
        JugadorBullseye jugador = generarJugador();
        ventanaBE = new JFrame();
        JPanel panel1 = new JPanel();

        JLabel texto1 = new JLabel();
        texto1.setText("Defina el monto a apostar");

        Integer[] opciones = {500, 1000, 5000, 10000, 25000, 50000};
        JComboBox comboBoxApuesta = new JComboBox<Integer>(opciones);

        JLabel texto2 = new JLabel();
        texto2.setText("Defina su caballo");

        ArrayList caballos = PatidaBullseye.inicializarCaballos();
        String[] datosCaballos = verCaballos(caballos);
        JComboBox comboBoxCaballo = new JComboBox<>(datosCaballos);

        JButton jugar = new JButton();
        jugar.setText("Jugar");

        JLabel resultado = new JLabel();

        JButton volver = new JButton();
        volver.setText("Volver al inicio");

        JButton volverAJugar = new JButton();
        volverAJugar.setText("Volver a jugar");

        panel1.add(texto1);
        panel1.add(comboBoxApuesta);

        panel1.add(texto2);
        panel1.add(comboBoxCaballo);

        panel1.add(jugar);
        panel1.add(resultado);

        panel1.add(volver);
        panel1.add(volverAJugar);

        ventanaBE.add(panel1);

        ventanaBE.setSize(600,400);
        ventanaBE.setLocationRelativeTo(null);
        ventanaBE.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        comboBoxApuesta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxApuesta.setEnabled(false);
                int opcionSeleccionada = (int) comboBoxApuesta.getSelectedItem();
                jugador.setApuesta(opcionSeleccionada);
            }
        });

        comboBoxCaballo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxCaballo.setEnabled(false);
                int indiceCaballo = comboBoxCaballo.getSelectedIndex();
                jugador.setCaballo((Caballo) caballos.get(indiceCaballo));
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
                ventanaBE.setVisible(false);
                ventanaPrincipal.setVisible(true);
            }
        });

        ventanaBE.setVisible(true);
    }

    public static JugadorBullseye generarJugador(){
        JugadorBullseye jugador = new JugadorBullseye("jugador");
        return jugador;
    }

    public static String[] verCaballos(ArrayList<Caballo> caballos){
        String[] datosCaballos= new String[6];
        for (int i = 0; i<6; i++){
            datosCaballos[i] = (caballos.get(i).toString());
        }
        return datosCaballos;
    }

    public void initVentanaBJ(){
        ventanaBJ = new JFrame();
        JPanel panel = new JPanel();

        JLabel texto = new JLabel();
        texto.setText(resultadoBJ());

        JButton volver = new JButton();
        volver.setText("Volver al inicio");

        JButton volverAJugar = new JButton();
        volverAJugar.setText("Volver a jugar");

        panel.add(texto);
        panel.add(volver);
        panel.add(volverAJugar);

        ventanaBJ.add(panel);

        ventanaBJ.setSize(600,400);
        ventanaBJ.setLocationRelativeTo(null);
        ventanaBJ.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaBJ.setVisible(false);
                ventanaPrincipal.setVisible(true);
            }
        });

        volverAJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(resultadoBJ());
            }
        });

        ventanaBJ.setVisible(true);
    }

    public void mostrarVentanas(){
        ventanaPrincipal.setVisible(true);
    }

    public static String resultadoBJ(){
        int resultado = PartidaBlackJack.partida();
        switch (resultado) {
            case -1:
                return "Empate";
            case 0:
                return "No hay ganador";
            case 1:
                return "Gana el jugador";
            case 2:
                return "Gana la casa";
        }
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
