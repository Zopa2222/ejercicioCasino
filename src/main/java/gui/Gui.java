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
                // Acciones cuando se presione el botón Bullseye
            }
        });
    }

    public void initVentanaBJ(){
        ventanaBJ = new JFrame();
        JPanel panel = new JPanel();

        JLabel texto = new JLabel();
        texto.setText(resultado());

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
                texto.setText(resultado());
            }
        });

        ventanaBJ.setVisible(true);
    }

    public void mostrarVentanas(){
        ventanaPrincipal.setVisible(true);
    }

    public static String resultado(){
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
