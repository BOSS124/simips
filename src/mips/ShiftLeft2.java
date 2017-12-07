package mips;

import java.awt.Graphics;

public class ShiftLeft2 extends Componente {
	public ShiftLeft2(int posx, int posy) {
		super(posx, posy);
	}

	public void draw(Graphics grf) {
		int altura = grf.getFontMetrics().getHeight();
		int largura = grf.getFontMetrics().stringWidth("Shift");

		grf.drawOval(posx, posy, largura + 8, 90);
		grf.drawString("Shift", posx + 2, posy + 45);
		grf.drawString("Left2", posx + 2, posy + 45 + altura);
	}

	public static int getSaida(int entrada) {
		return entrada << 2;
	}
}