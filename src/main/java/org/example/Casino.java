package org.example;

import gui.Gui;

import java.util.Scanner;

public class Casino {
    private static Usuario registro(){
        System.out.println("Bienvenid@ al casino Deluxe, ingrese su nombre: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        Usuario jugador = new Usuario(nombre);
        return jugador;
    }

    public static void menu(){
        Usuario usuario = registro();
        opciones();
        int opcion = Tools.ingresarSoloNumero();
        while (!Tools.validarRangoNumero(opcion,1,2)){
            System.out.println("Ingrese una opción válida: ");
            opcion = Tools.ingresarSoloNumero();
        }
        switch (opcion){
            case 1:
                //PartidaBlackJack.partida(usuario);
                break;
            case 2:
                PatidaBullseye.partida(usuario);
        }
    }

    private static void opciones(){
        System.out.println("¿Qué juego desea jugar?");
        System.out.println("[1] BlackJack");
        System.out.println("[2] Bullseye");
    }
    //----------------------------------------------------------------------

    public static void ventanaPrincipal(){
        Gui principal = new Gui();
        principal.mostrarVentanas();
    }


}
