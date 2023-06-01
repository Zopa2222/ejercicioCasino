package org.example;

public class Carta {

	private String pinta;
	private char simbolo;
	private int valor;

	public Carta(String pinta, char simbolo, int valor) {
		this.pinta = pinta;
		this.simbolo = simbolo;
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}