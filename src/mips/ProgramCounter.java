package mips;

import java.awt.Graphics;

public class ProgramCounter extends Componente {
	private int valor;

	public ProgramCounter(int posx, int posy) {
		super(posx, posy);
		valor = 0;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void draw(Graphics grf) {
		int altura = grf.getFontMetrics().getHeight();
		int largura = grf.getFontMetrics().stringWidth("PC");

		grf.drawRect(posx, posy, largura + 10, 90);
		grf.drawString("PC", posx + 5, posy + 45 + (altura / 2));
	}
}