package gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Gui extends JFrame {

    private JLabel textBienvenida;
    private JLabel textResultadoBlackJack;
    private JLabel textResultadoBullseye;
    private JLabel textGanancia;
    private JButton blackJackButton;
    private JButton BullseyeButton;
    private JButton volverButton;
    private JButton volverAJugarBlackJackButton;
    private JButton volverAJugarBullseyeButton;
    private JPanel panelPrincipal;
    private JPanel panelBlackJack;
    private JPanel panelBullseye;

    public void Gui(){
        initVentanaPrincipal();
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initVentanaPrincipal(){
        JPanel panel = new JPanel();

        JLabel texto = new JLabel();
        texto.setText("Bienvenido, eliga un juego");

        JButton BJbutton = new JButton();
        BJbutton.setText("BlackJack");

        JButton BEbutton = new JButton();
        BEbutton.setText("BlackJack");

        panel.add(texto);
        panel.add(BJbutton);
        panel.add(BEbutton);

        this.add(panel);
    }
}
