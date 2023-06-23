package gui;

import org.example.PartidaBlackJack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBlackjack extends JFrame implements ActionListener {

    private JLabel resultado;
    private JButton volver;
    private JButton jugarAgain;

    public VentanaBlackjack(){
        initVentanaPrincipal();
        this.setTitle("Casino");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initVentanaPrincipal(){
        JLabel resultado = new JLabel();
        JButton volver = new JButton();
        JButton jugarAgain = new JButton();
        JPanel panel = new JPanel();

        jugarAgain.setText("Jugar");
        volver.setText("Volver atrás");
        resultado.setText("Haga clic en Jugar");

        panel.add(resultado);
        panel.add(jugarAgain);
        panel.add(volver);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.abrirPrincipal();
                Controlador.cerrarBJ();
            }
        });

        jugarAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText(resultadoBJ());
            }
        });

        this.add(panel);
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


