package mips;

import java.awt.Graphics;

public class BNE extends Componente {
	public BNE(int posx, int posy) {
		super(posx, posy);
	}

	public static int getSaida(int a, int b) {
		return a & b;
	}

	public void draw(Graphics grf) {
		int altura = grf.getFontMetrics().getHeight();
		int largura = grf.getFontMetrics().stringWidth("BNE");

		grf.drawOval(posx, posy, largura + 4, largura + 4);
		grf.drawString("BNE", posx + 2, posy + ((largura + 4) / 2) + (altura / 2));
	}
}