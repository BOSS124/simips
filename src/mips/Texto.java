package mips;

import java.awt.Graphics;

public class Texto extends Componente {
	private String texto;

	public Texto(int posx, int posy, String texto) {
		super(posx, posy);
		this.texto = texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void draw(Graphics grf) {
		int altura = grf.getFontMetrics().getHeight();

		grf.drawString(texto, posx, posy + altura);
	}
}