package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/*Debido al método 'ingresarSoloNumero' de la case Tools me aseguro que todos los input son de tipo int, pero al
  tener interacción directa con la consola no corresponde realizar una prueba unitaria. Además, gracias al método
  'validarRongoNumero' de la clase Tools me aseguro de que en el método 'apuesta' de la clase PartidaBullseye la
  opcion entregada al mismo sea uno de los casos dentro del switch*/

class ToolsTest {
    int testearValor1;
    int testearValor2;
    int testearValor3;
    int valorMax1;
    int valorMax2;
    int valorMax3;
    int valorMin1;
    int valorMin2;
    int valorMin3;

    int ganancia1;
    int ganancia2;
    int ganancia3;

    @BeforeEach
    void setUp() {
        testearValor1= 0;
        testearValor2= -1;
        testearValor3= -3;

        valorMax1 = 0;
        valorMax2 = 3;
        valorMax3 = -1;

        valorMin1 = 0;
        valorMin2 = 0;
        valorMin3 = -4;

        ganancia1 = 1000;
        ganancia2 = 10000;
        ganancia3 = 25000;
    }

    @Test
    void validarRangoNumeroTest() {
        assertTrue(Tools.validarRangoNumero(testearValor1,valorMin1,valorMax1));
        assertFalse(Tools.validarRangoNumero(testearValor2,valorMin2,valorMax2));
        assertTrue(Tools.validarRangoNumero(testearValor3,valorMin3,valorMax3));
    }
}