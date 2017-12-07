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

		px[0] = posx; py[0] = posy;
		px[1] = posx + 50; py[1] = posy + 25;
		px[2] = px[1]; py[2] = py[1] + 50;
		px[3] = posx; py[3] = posy + 100;
		px[4] = posx; py[4] = posy + 60;
		px[5] = posx + 10; py[5] = posy + 50;
		px[6] = posx; py[6] = posy + 40;

		grf.drawPolygon(px, py, npts);

		grf.drawString("Add", posx + 13, posy + 42 + altura);
	}
}