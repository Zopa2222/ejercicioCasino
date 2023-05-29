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

	public String getPinta() {
		return this.pinta;
	}
	public char getSimbolo() {
		return this.simbolo;
	}
	public int getValor() {
		return this.valor;
	}
	public String toString() {
		return "Carta: " + getSimbolo() + " de " + getPinta() + " (Valor: " + getPinta() + ")";
	}
}