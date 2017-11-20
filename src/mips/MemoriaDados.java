package mips;

import java.awt.Graphics;

public class MemoriaDados extends Componente {
	private char memoria[];
	public static final int CAPACIDADE = 1000;

	public MemoriaDados(int posx, int posy) {
		super(posx, posy);

		memoria = new char[MemoriaDados.CAPACIDADE];
	}

	public int getMemEndValor(int endereco) {
		int aux = 0;

		if(endereco <= (MemoriaDados.CAPACIDADE - 4) && endereco >= 0) {
			aux |= memoria[endereco];
			aux <<= 8;
			aux |= memoria[endereco+1];
			aux <<= 8;
			aux |= memoria[endereco+2];
			aux <<= 8;
			aux |= memoria[endereco+3];
		}
		return aux;
	}

	public void setMemEndValor(int endereco, int valor) {
		if(endereco <= (MemoriaDados.CAPACIDADE - 4) && endereco >= 0) {
			memoria[endereco] = (char) (valor >> 24);
			memoria[endereco+1] = (char) (valor >> 16);
			memoria[endereco+2] = (char) (valor >> 8);
			memoria[endereco+3] = (char) valor;
		}
	}

	public void draw(Graphics grf) {

	}
}
