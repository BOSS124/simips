package mips;

import java.awt.Graphics;

public class ExtensorSinal extends Componente {
	public ExtensorSinal(int posx, int posy) {
		super(posx, posy);
	}

	public void draw(Graphics grf) {
		int altura = grf.getFontMetrics().getHeight();
		int largura = grf.getFontMetrics().stringWidth("extend");

		grf.drawOval(posx, posy, largura + 6, (int) ((largura + 6) * 1.5));
		grf.drawString("Sign-", posx + 3, posy + (int) (((largura + 6) * 1.5) / 2) + (altura / 2));
		grf.drawString("extend", posx + 3, posy + (int) (((largura + 6) * 1.5) / 2) + altura);
	}
}