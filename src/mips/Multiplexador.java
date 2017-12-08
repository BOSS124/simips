package mips;

import java.awt.Graphics;

public abstract class Multiplexador extends Componente {
	public int nentradas;
	public int[] entradas;
	public int seletor;

	public Multiplexador(int posx, int posy, int entradas) {
		super(posx, posy);
		nentradas = entradas;
		this.entradas = new int[entradas];
		for(int i = 0; i < entradas; i++)
			this.entradas[i] = 0;
		seletor = 0;
	}

	public abstract int getSaida();

	public void setEntrada(int index, int valor) {
		if(index < nentradas)
			entradas[index] = valor;
	}

	public void setSeletor(int seletor) {
		this.seletor = seletor;
	}

	public void draw(Graphics grf) {
		int altura = grf.getFontMetrics().getHeight();
		int largura = grf.getFontMetrics().stringWidth("MUX");

		grf.drawOval(posx, posy, largura + 4, 90);
		grf.drawString("MUX", posx + 2, posy + 45 + (altura / 2));
	}
}