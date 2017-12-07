package mips;

import java.awt.Graphics;

public class Somador extends Componente {
	public Somador(int posx, int posy) {
		super(posx, posy);
	}

	public static int getSoma(int op1, int op2) {
		return op1 + op2;
	}

	public void draw(Graphics grf) {
		final int npts = 7;
		int[] px = new int[npts];
		int[] py = new int[npts];

		int altura = grf.getFontMetrics().getHeight();
		int largura = grf.getFontMetrics().stringWidth("Add");

		px[0] = 

		grf.drawPolygon(px, py, npts);

		grf.drawString("Add", posx + 13, posy + 26 + altura);
	}
}