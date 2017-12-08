package mips;

import java.awt.Graphics;

public class InsIndicador extends Componente {
	private String texto;

	public InsIndicador(int posx, int posy) {
		super(posx, posy);
		texto = "nop";
	}

	public void setInstrucao(String instrucao) {
		texto = instrucao;
	}

	public void draw(Graphics grf) {
		int altura = grf.getFontMetrics().getHeight();
		grf.drawRoundRect(posx, posy, 200, altura + 10, 2, 2);
		grf.drawString(texto, posx + 5, posy + ((altura + 10) / 2) + (altura / 2));
	}
}