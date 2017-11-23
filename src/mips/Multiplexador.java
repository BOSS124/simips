package mips;

import java.awt.Graphics;

public abstract class Multiplexador extends Componente {
	int nentradas;
	int[] entradas;

	public Multiplexador(int entradas) {
		nentradas = entradas;
		this.entradas = new int[entradas];
	}

	public void draw(Graphics grf) {
		int altura = grf.getFontMetrics().getHeight();
		int largura = grf.getFontMetrics().stringWidth("MUX");

		grf.drawOval(posx, posy, largura + 4, 90);
		grf.drawString("MUX", posx + 2, posy + 45 + altura);
	}
}