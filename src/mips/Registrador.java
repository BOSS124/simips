package mips;

import java.awt.Graphics;

public class Registrador extends Componente {
	private String nome;
	private int valor;

	public Registrador(String nome, int posx, int posy) {
		super(posx, posy);
		this.nome = nome;
		this.valor = 0;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void draw(Graphics grf, int tick) {

	}
}