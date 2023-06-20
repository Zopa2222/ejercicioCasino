package gui;

import org.example.PartidaBlackJack;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        ventanaBE = new JFrame();
        JPanel panel1 = new JPanel();

        JLabel texto = new JLabel();
        texto.setText("Defina el monto a apostar");

        Integer[] opciones = {500, 1000, 5000, 10000, 25000, 50000};
        JComboBox comboBoxApuesta = new JComboBox<>(opciones);

        JButton volver = new JButton();
        volver.setText("Volver al inicio");

        JButton volverAJugar = new JButton();
        volverAJugar.setText("Volver a jugar");

        panel1.add(comboBoxApuesta);
        panel1.add(texto);
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
            }
        });

        ventanaBE.setVisible(true);
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
