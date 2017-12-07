package mips;

import java.awt.Graphics;

public class ULA extends Componente {
	private int input1, input2;
	private int zero;
	private int resultado;
	private int operacao;

	public ULA(int posx, int posy) {
		super(posx, posy);
	}

	public void setInputs(int input1, int input2) {
		this.input1 = input1;
		this.input2 = input2;
	}

	public void setOperacao(int op) {
		operacao = op;
	}

	public void operate() {
		switch(operacao) {
			case 2:	//add
			resultado = input1 + input2;
			break;

			case 6:	//sub
			resultado = input1 - input2;
			break;

			case 0:
			resultado = input1 & input2;
			break;

			case 1:
			resultado = input1 | input2;
			break;
		}
		
		if(resultado == 0)
				zero = 1;
			else
				zero = 0;
	}

	public int getResultado() {
		return resultado;
	}

	public int getZeroFlag() {
		return zero;
	}

	public void draw(Graphics grf) {
		final int npts = 7;
		int[] px = new int[npts];
		int[] py = new int[npts];

		int altura = grf.getFontMetrics().getHeight();
		int largura = grf.getFontMetrics().stringWidth("ULA");

		px[0] = posx; py[0] = posy;
		px[1] = posx + 50; py[1] = posy + 25;
		px[2] = px[1]; py[2] = py[1] + 50;
		px[3] = posx; py[3] = posy + 100;
		px[4] = posx; py[4] = posy + 60;
		px[5] = posx + 10; py[5] = posy + 50;
		px[6] = posx; py[6] = posy + 40;

		grf.drawPolygon(px, py, npts);

		grf.drawString("ULA", posx + 13, posy + 50 + (altura / 2));
	}
}