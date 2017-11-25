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
		px[1] = posx + 16 + largura; py[1] = posy + 13;
		px[2] = px[1]; py[2] = py[1] + 26;
		px[3] = px[0]; py[3] = py[0] + 52;
		px[4] = px[3]; py[4] = py[3] + 21;
		px[5] = px[4] + 10; py[5] = py[4] + 5;
		px[6] = px[4]; py[6] = py[5] + 5;

		grf.drawPolygon(px, py, npts);

		grf.drawString("Add", posx + 13, posy + 26 + altura);
	}
}