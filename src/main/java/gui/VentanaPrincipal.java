package gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JLabel texto;
    private JButton botonBJ;
    private JButton botonBE;
    private JPanel panel;
    public JFrame ventanaBJ;
    public JFrame ventanaBE;

    public VentanaPrincipal() {
        initVentanaPrincipal();
        this.setTitle("Casino");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

     private void initVentanaPrincipal(){
        JLabel texto = new JLabel();
        JButton botonBJ = new JButton();
        JButton botonBE = new JButton();
        JPanel panel = new JPanel();

        texto.setText("Bienvenido! Defina el juego en el que participará ");
        botonBJ.setText("Blackjack");
        botonBE.setText("Bullseye");

        panel.add(texto);
        panel.add(botonBJ);
        panel.add(botonBE);

        botonBJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarPrincipal();
                Controlador.abrirBJ();
            }
        });

        botonBE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarPrincipal();
                Controlador.abrirBE();
            }
        });

        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
