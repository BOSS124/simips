package mips;

import java.awt.Graphics;

public abstract class Multiplexador extends Componente {
	public int nentradas;
	public int[] entradas;

	public Multiplexador(int posx, int posy, int entradas) {
		super(posx, posy);
		nentradas = entradas;
		this.entradas = new int[entradas];
	}

	public abstract int getSaida(int seletor);

	public void setEntrada(int index, int valor) {
		if(index < nentradas)
			entradas[index] = valor;
	}

	public void draw(Graphics grf) {
		int altura = grf.getFontMetrics().getHeight();
		int largura = grf.getFontMetrics().stringWidth("MUX");

		grf.drawOval(posx, posy, largura + 4, 90);
		grf.drawString("MUX", posx + 2, posy + 45 + (altura / 2));
	}
}