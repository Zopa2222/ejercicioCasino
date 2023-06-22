package gui;

public enum Controlador {
    INSTANCE;
    public static VentanaPrincipal principal = new VentanaPrincipal();
    public static VentanaBlackjack ventanaBlackjack = new VentanaBlackjack();
    public static VentanaBullseye ventanaBullseye = new VentanaBullseye();


    public static void abrirPrincipal(){
        principal.setVisible(true);
    }

    public static void abrirBJ(){
        ventanaBlackjack.setVisible(true);
    }

    public static void abrirBE(){
        ventanaBullseye.setVisible(true);
    }

    public static void cerrarBE(){
        ventanaBullseye.setVisible(false);
    }

    public static void cerrarPrincipal(){
        principal.setVisible(false);
    }

    public static void cerrarBJ(){
        ventanaBlackjack.setVisible(false);
    }

}
